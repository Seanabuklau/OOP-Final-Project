package g2t1.DigitalRemittance.transactionstatus;

import java.util.ArrayList;
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
public class TransactionStatusController {
    private final TransactionStatusService transactionStatusService;

    @Autowired
    public TransactionStatusController(TransactionStatusService transactionStatusService) {
        this.transactionStatusService = transactionStatusService;
    }

    @PostMapping(path = "/status")
    public TransactionStatus getTransactionStatus(@RequestBody Map<String, String> payload){
        return transactionStatusService.getTransactionStatus(payload);
    }

    @PostMapping(path = "/all")
    public ArrayList<TransactionStatus> getAllTransactionStatus(@RequestBody Map<String, ArrayList<Long>> payload){
        return transactionStatusService.getAllTransactionStatus(payload);
    }
    
}
