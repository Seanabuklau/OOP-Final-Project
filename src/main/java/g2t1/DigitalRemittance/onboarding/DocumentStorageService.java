package g2t1.DigitalRemittance.onboarding;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class DocumentStorageService {

    private Path fileStorageLocation = null;


    @Autowired
    DocumentStoragePropertiesRepo docStorageRepo;

    @Autowired
    public DocumentStorageService(DocumentStorageProperties fileStorageProperties, Environment env) throws DocumentStorageException {
        this.fileStorageLocation = Paths.get( fileStorageProperties.getUploadDir()).toAbsolutePath().normalize();
        try {
            Files.createDirectories(this.fileStorageLocation);

        } catch (Exception ex) {
            throw new DocumentStorageException("Could not create the directory where the uploaded files will be stored.", ex);

        }

    }

    public Path storeFile(MultipartFile file) throws DocumentStorageException {

        String originalFileName = StringUtils.cleanPath(file.getOriginalFilename());
        String fileName = "";

        try {

            // Check if the file's name contains invalid characters
            if(originalFileName.contains("..")) {
                throw new DocumentStorageException("Sorry! Filename contains invalid path sequence " + originalFileName);

            }

            fileName = originalFileName;
            // Copy file to the target location (Replacing existing file with the same name)

            Path targetLocation = this.fileStorageLocation.resolve(fileName);
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
            DocumentStorageProperties newDoc = new DocumentStorageProperties();
            newDoc.setDocumentFormat(file.getContentType());
            newDoc.setFileName(fileName);
            docStorageRepo.save(newDoc);

            return targetLocation;


        } catch (IOException ex) {
            throw new DocumentStorageException("Could not store file " + fileName + ". Please try again!", ex);

        }

    }

    public Resource loadFileAsResource(String fileName) throws Exception {
        try {
            Path filePath = this.fileStorageLocation.resolve(fileName).normalize();
            Resource resource = new UrlResource(filePath.toUri());

            if(resource.exists()) {
                return resource;

            } else {
                throw new FileNotFoundException("File not found " + fileName);
            }

        } catch (MalformedURLException ex) {
            throw new FileNotFoundException("File not found " + fileName);
        }

    }


}
