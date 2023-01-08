package g2t1.DigitalRemittance.ssot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping(path="/api/SSOT")
@CrossOrigin(origins = "http://localhost")
public class SSOTController {
    private SSOTService ssotService;

    @Autowired
    public SSOTController(SSOTService ssotService) {
        this.ssotService = ssotService;
    }

    @GetMapping
    public ArrayList<SSOT> getAll() {
        return ssotService.getAll();
    }

}
