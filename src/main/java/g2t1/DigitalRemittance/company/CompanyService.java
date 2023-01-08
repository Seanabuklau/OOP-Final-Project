package g2t1.DigitalRemittance.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CompanyService {
    private final CompanyRepository companyRepository;

    @Autowired
    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public ArrayList<Company> getAll() {
        return (ArrayList<Company>) companyRepository.findAll();
    }

    public void addFields(ArrayList<String> companyFields, String companyName) {
        ArrayList<Company> companyFieldsToSave = new ArrayList<>();

        for (String companyField: companyFields) {
            Company company = new Company(companyName, companyField, "String");
            companyFieldsToSave.add(company);
        }

        companyRepository.saveAll(companyFieldsToSave);
    }

    public ArrayList<String> getOne(String companyName) {
        ArrayList<Company> queryResult = companyRepository.findCompanyFieldByName(companyName);

        ArrayList<String> companyFields = new ArrayList<>();
        for (Company c : queryResult) {
            companyFields.add(c.getField());
        }
        return companyFields;
    }
}
