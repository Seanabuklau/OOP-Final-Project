package g2t1.DigitalRemittance.mappingcu;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MappingCUService {
    private final MappingCURepository mappingCURepository;

    @Autowired
    public MappingCUService(MappingCURepository mappingCURepository) {
        this.mappingCURepository = mappingCURepository;
    }
    
    public String getSSOTFieldByCorporateField(String corporateField, String corporateName) {
        return mappingCURepository.getSSOTFieldByCorporateField(corporateField, corporateName);
    }

    public ArrayList<MappingCU> getAll() {
        return (ArrayList<MappingCU>) mappingCURepository.findAll();
    }

    public ArrayList<MappingCU> addMapping(ArrayList<MappingCU> mappings) {
        return (ArrayList<MappingCU>) mappingCURepository.saveAll(mappings);
    }
}
