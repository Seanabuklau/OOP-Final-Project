package g2t1.DigitalRemittance.transactionstatus;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TransactionStatus {
    @Id
    private long transactionID;
    @Column(length = 150)
    private String status;

    public TransactionStatus() {
    }

    public TransactionStatus(long transactionID, String status) {
        this.transactionID = transactionID;
        this.status = status;
    }

    public long getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(long transactionID) {
        this.transactionID = transactionID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
}
