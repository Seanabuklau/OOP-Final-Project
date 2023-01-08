package g2t1.DigitalRemittance.mappingcu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/MappingCU")
@CrossOrigin(origins = "http://localhost")
public class MappingCUController {
    private final MappingCUService mappingCUService;

    @Autowired
    public MappingCUController(MappingCUService mappingCUService) {
        this.mappingCUService = mappingCUService;
    }

    @GetMapping
    public ArrayList<MappingCU> getAll() {
        return mappingCUService.getAll();
    }

    @PostMapping(consumes="application/json")
    public void addMapping(@RequestBody ArrayList<MappingCU> mappings) {
        // add mapping to database
        mappingCUService.addMapping(mappings);
    }
}
