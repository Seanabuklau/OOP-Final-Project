package g2t1.DigitalRemittance.onboarding;

import g2t1.DigitalRemittance.processor.ExcelProcessor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Map;

@RestController
public class OnboardingController {

    // get headers from onboarding file
    @PostMapping(path="/onboarding", consumes="application/json", produces="application/json")
    public ArrayList<String> uploadOnboardingExcel(@RequestBody Map<String,Object> payload) {
        String fileName = (String) payload.get("fileName");
        int headerRow = (int) payload.get("headerRow");
        return ExcelProcessor.uploadAndGetHeaders(fileName, headerRow);
    }


}
