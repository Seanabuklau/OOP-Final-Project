package g2t1.DigitalRemittance.ssot;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SSOT {
    @Id
    @Column(length = 150)
    private String field;
    @Column(length = 150)
    private String dataType;
    public String getField() {
        return field;
    }

    public SSOT(){
    }
    
    public SSOT(String field, String dataType) {
        this.field = field;
        this.dataType = dataType;
    }

    public void setField(String field) {
        this.field = field;
    }
    public String getDataType() {
        return dataType;
    }
    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    
}
