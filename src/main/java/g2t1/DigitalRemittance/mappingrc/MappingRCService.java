package g2t1.DigitalRemittance.mappingrc;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MappingRCService {
    private final MappingRCRepository mappingRCRepository;

    @Autowired
    public MappingRCService(MappingRCRepository mappingRCRepository) {
        this.mappingRCRepository = mappingRCRepository;
    }

    public ArrayList<String> getMappingRCByCompanyName(String companyName) {
        return mappingRCRepository.getSSOTFieldByCompanyName(companyName);
    }

    public String getCompanyFieldBySSOTAndCompanyName(String companyName, String ssotField) {
        return mappingRCRepository.getCompanyFieldBySSOTAndCompanyName(companyName, ssotField);
    }

    public String getSSOTFieldByCompanyNameAndCompanyField(String companyName, String companyField) {
        return mappingRCRepository.getSSOTFieldByCompanyNameAndCompanyField(companyName, companyField);
    }

    public ArrayList<MappingRC> getAll() {
        return (ArrayList<MappingRC>) mappingRCRepository.findAll();
    }
}
