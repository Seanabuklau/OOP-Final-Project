package g2t1.DigitalRemittance.transactionstatus;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TransactionStatusRepository extends JpaRepository<TransactionStatus, Long> {
    
    @Query("SELECT ts from TransactionStatus ts where transactionID = ?1")
    TransactionStatus getTransactionStatus(long transactionID);
}
