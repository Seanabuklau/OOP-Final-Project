package g2t1.DigitalRemittance.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/Company")
@CrossOrigin(origins = "http://localhost")
public class CompanyController {
    private final CompanyService companyService;

    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping
    public ArrayList<Company> getAll() {
        return companyService.getAll();
    }

    @GetMapping("/getCompanyFields/{companyName}")
    public ArrayList<String> getOne(@PathVariable("companyName") String companyName) {
        return companyService.getOne(companyName);
    }

    @PostMapping("/addCompanyFields")
    public void addCompanyFields(@RequestBody ArrayList<String> companyFields, @RequestBody String companyName) {
        // add company fields to database
        companyService.addFields(companyFields, companyName);
    }
}
