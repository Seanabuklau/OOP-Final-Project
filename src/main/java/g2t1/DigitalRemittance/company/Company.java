package g2t1.DigitalRemittance.company;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(CompanyPK.class)
public class Company {
    @Id
    @Column(length = 150)
    private String companyName;
    @Id
    @Column(length = 150)
    private String field;
    @Column(length = 150)
    private String dataType;

    public Company() {
    }

    public Company(String companyName, String field, String dataType) {
        this.companyName = companyName;
        this.field = field;
        this.dataType = dataType;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getField() {
        return field;
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
