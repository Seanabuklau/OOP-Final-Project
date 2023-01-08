package g2t1.DigitalRemittance.transaction;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TransactionRepository extends JpaRepository<Transaction, TransactionPK> {
    @Query("SELECT MAX(transactionID) FROM Transaction")
    String getLatestTransactionID();
    
}
    
