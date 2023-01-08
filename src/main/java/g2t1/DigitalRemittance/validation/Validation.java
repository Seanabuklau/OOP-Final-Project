package g2t1.DigitalRemittance.validation;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(ValidationPK.class)
public class Validation {
    @Id
    @Column(length = 150)
    private String companyName;
    @Id
    @Column(length = 150)
    private String ssotField;
    @Id
    @Column(length = 150)
    private String requirement;
    @Column(length = 150)
    private String specification;

    public Validation() {
    }

    public Validation(String companyName, String ssotField, String requirement, String specification) {
        this.companyName = companyName;
        this.ssotField = ssotField;
        this.requirement = requirement;
        this.specification = specification;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getSsotField() {
        return ssotField;
    }

    public void setSsotField(String ssotField) {
        this.ssotField = ssotField;
    }

    public String getRequirement() {
        return requirement;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

}
