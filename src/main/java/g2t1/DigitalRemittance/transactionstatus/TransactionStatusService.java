package g2t1.DigitalRemittance.transactionstatus;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionStatusService {
    private TransactionStatusRepository transactionStatusRepository;
    
    @Autowired
    public TransactionStatusService(TransactionStatusRepository transactionStatusRepository) {
        this.transactionStatusRepository = transactionStatusRepository;
    }

    public void storeTransactionStatus(long transactionID, String status) {
        transactionStatusRepository.save(new TransactionStatus(transactionID, status));
    }

    public TransactionStatus getTransactionStatus(Map<String, String> payload) {
        long transactionID = Long.parseLong(payload.get("transactionID"));
        return transactionStatusRepository.getTransactionStatus(transactionID);
    }

    public ArrayList<TransactionStatus> getAllTransactionStatus(Map<String, ArrayList<Long>> payload) {
        ArrayList<TransactionStatus> transactionStatuses = new ArrayList<>();
        
        for(long transactionID : payload.get("transactionIDs")) {
            TransactionStatus transactionStatus = transactionStatusRepository.getTransactionStatus(transactionID);
            transactionStatuses.add(transactionStatus);
        }
        
        return transactionStatuses;
    }
}
