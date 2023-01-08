package g2t1.DigitalRemittance.onboarding;

import g2t1.DigitalRemittance.company.CompanyService;
import g2t1.DigitalRemittance.processor.ExcelProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.nio.file.Path;
import java.util.ArrayList;


@RestController
@CrossOrigin(origins = "http://localhost")
public class DocumentController {

    @Autowired
    private DocumentStorageService documentStorageService;
    private CompanyService companyService;

    public DocumentController (DocumentStorageService documentStorageService, CompanyService companyService) {
        this.documentStorageService = documentStorageService;
        this.companyService = companyService;
    }

    // change to accept both file and header row
    @PostMapping("/uploadFile")
    public UploadFileResponse uploadFile(@RequestParam("file") MultipartFile file,
         @RequestParam("companyName") String companyName) throws DocumentStorageException{

        Path fileStorageLocation = documentStorageService.storeFile(file);

        // read excel for headers
        ArrayList<String> headers = ExcelProcessor.uploadAndGetHeaders(String.valueOf(fileStorageLocation), 2);
        // add headers to company table
        companyService.addFields(headers, companyName);

        return new UploadFileResponse(file.getName(), file.getContentType(), file.getSize());
    }

    @PostMapping("/uploadTransactionFile")
    public String uploadTransactionFile(@RequestParam("file") MultipartFile file) throws DocumentStorageException{

        Path fileStorageLocation = documentStorageService.storeFile(file);
        String[] filePathArr = String.valueOf(fileStorageLocation).split("\\\\");
        String fileName = filePathArr[filePathArr.length - 1];
        System.out.println("data/" + fileName);
        return "data/" + fileName;
    }

}
