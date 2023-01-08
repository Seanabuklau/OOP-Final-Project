package g2t1.DigitalRemittance.validation;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/validations")
@CrossOrigin(origins = "http://localhost")
public class ValidationController {
    private final ValidationService validationService;

    @Autowired
    public ValidationController(ValidationService validationService) {
        this.validationService = validationService;
    }

    @PostMapping(path = "ssot")
    public ArrayList<Validation> getValidationsBySSOT(@RequestBody Map<String, String> payload) {
        return validationService.getValidationsBySSOT(payload.get("companyName"), payload.get("ssotField"));
    }

    
}
