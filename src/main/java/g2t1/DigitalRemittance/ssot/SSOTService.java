package g2t1.DigitalRemittance.ssot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class SSOTService {
    private final SSOTRepository ssotRepository;

    @Autowired
    public SSOTService(SSOTRepository ssotRepository) {
        this.ssotRepository = ssotRepository;
    }

    public ArrayList<SSOT> getAll() {
        // return List.of(
        // 	new Transaction(1L, "ABC", "abc@abc.com", LocalDate.of(2022, 1, 1))
        // );
        return (ArrayList<SSOT>) ssotRepository.findAll();
    }
}
