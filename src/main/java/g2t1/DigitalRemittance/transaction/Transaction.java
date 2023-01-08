package g2t1.DigitalRemittance.transaction;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(TransactionPK.class)
public class Transaction {
    @Id
    private long transactionID;
    @Id
    @Column(length = 150)
    private String ssotField;
    @Column(length = 150)
    private String value;
    @Column(length = 150)
    private String companyName;

    public Transaction() {
    }
    
    public Transaction(long transactionID, String ssotField, String value, String companyName) {
        this.transactionID = transactionID;
        this.ssotField = ssotField;
        this.value = value;
        this.companyName = companyName;
    }

    public long getTransactionID() {
        return transactionID;
    }
    public void setTransactionID(long transactionID) {
        this.transactionID = transactionID;
    }
    public String getSsotField() {
        return ssotField;
    }
    public void setSsotField(String ssotField) {
        this.ssotField = ssotField;
    }
    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }
    public String getCompanyName() {
        return companyName;
    }
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
    
}
