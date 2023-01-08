package g2t1.DigitalRemittance.mappingrc;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(MappingRcPK.class)
public class MappingRC {
    @Id
    @Column(length = 150)
    private String companyName;
    @Column(length = 150)
    private String companyField;
    @Id
    @Column(length = 150)
    private String ssotField;
    
    public MappingRC(){
    }

    public MappingRC(String companyName, String companyField, String ssotField) {
        this.companyName = companyName;
        this.companyField = companyField;
        this.ssotField = ssotField;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyField() {
        return companyField;
    }

    public void setCompanyField(String companyField) {
        this.companyField = companyField;
    }

    public String getSsotField() {
        return ssotField;
    }

    public void setSsotField(String ssotField) {
        this.ssotField = ssotField;
    }
    

    
}
