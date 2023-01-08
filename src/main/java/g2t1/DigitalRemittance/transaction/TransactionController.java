package g2t1.DigitalRemittance.transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/transaction")
@CrossOrigin(origins = "http://localhost")
public class TransactionController {
    private final TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping(path = "/header")
    public List<String> getSSOTBasedOnTransaction(@RequestBody Map<String, String> payload) {
        return transactionService.getSSOTBasedOnTransaction(payload);
    }

    @PostMapping(path = "/auth")
    public String authenticate(@RequestBody Map<String, String> payload) {
        return transactionService.authenticate(payload);
    }

    @PostMapping(path = "/send")
    public ArrayList<Long> sendTransactionsToSandbox(@RequestBody Map<String, String> payload){
        return transactionService.sendTransactionsToSandbox(payload);
    }

    @PostMapping(path = "/excel")
    public ArrayList<Map<String, String>> getTransactionsRecords(@RequestBody Map<String, String> payload){
        return transactionService.getTransactionsRecords(payload);
    }
}
