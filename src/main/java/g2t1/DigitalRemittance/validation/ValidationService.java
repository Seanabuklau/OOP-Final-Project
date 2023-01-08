package g2t1.DigitalRemittance.validation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ValidationService {
    private final ValidationRepository validationRepository;

    @Autowired
    public ValidationService(ValidationRepository validationRepository) {
        this.validationRepository = validationRepository;
    }

    public ArrayList<Validation> getValidationsBySSOT(String companyName, String ssotField) {
        return validationRepository.getValidationsBySSOT(companyName, ssotField);
    }

    public boolean validLength(String ssotField, String requirement, String specifications) {
        if(requirement.equals("minLength")){
            return ssotField.length() >= Integer.parseInt(specifications);
        }
        else if(requirement.equals("maxLength")){
            return ssotField.length() <= Integer.parseInt(specifications);
        }
        return false;
    }

    public boolean validValue(String ssotField, String specifications) {
        String[] specificationsList = specifications.split(",");
        return Arrays.asList(specificationsList).contains(ssotField);

    }

    public boolean validFormat(String ssotField, String regex) {
        return ssotField.matches(regex);
    }

    public boolean validateSSOT(String companyName, String ssotField){
        boolean valid = true;

        ArrayList<Validation> validations = getValidationsBySSOT(companyName, ssotField);
        Map<String, String> requirementSpecifications = new HashMap<>();
        for(Validation validation : validations){
            requirementSpecifications.put(validation.getRequirement(), validation.getSpecification());
        }

        for(String req: requirementSpecifications.keySet()){
            if(req.equals("minLength") || req.equals("maxLength")){
                valid = validLength(ssotField, req, requirementSpecifications.get(req));
            }
            else if(req.equals("value")){
                valid = valid && validValue(ssotField, requirementSpecifications.get(req));
            }
            else if(req.equals("regex")){
                valid = valid && validFormat(ssotField, requirementSpecifications.get(req));
            }

            if(valid == false){
                return false;
            }
        }

        return true;
    }
}
