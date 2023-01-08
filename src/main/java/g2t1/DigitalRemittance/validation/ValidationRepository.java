package g2t1.DigitalRemittance.validation;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ValidationRepository extends JpaRepository<Validation, ValidationPK> {
    @Query("SELECT v from Validation v where v.companyName = ?1 and v.ssotField = ?2")
    ArrayList<Validation> getValidationsBySSOT(String companyName, String ssotField);
}
