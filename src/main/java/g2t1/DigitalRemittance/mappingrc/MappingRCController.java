package g2t1.DigitalRemittance.mappingrc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/MappingRC")
@CrossOrigin(origins = "http://localhost")
public class MappingRCController {
    private MappingRCService mappingRCService;

    @Autowired
    public MappingRCController(MappingRCService mappingRCService) {
        this.mappingRCService = mappingRCService;
    }

    @GetMapping
    public ArrayList<MappingRC> getAll() {
        return mappingRCService.getAll();
    }
}
