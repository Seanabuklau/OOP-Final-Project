package g2t1.DigitalRemittance.mappingcu;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MappingCURepository extends JpaRepository<MappingCU, MappingCuPK> {
    @Query("SELECT ssotField FROM MappingCU WHERE companyField = ?1 AND companyName = ?2")
    String getSSOTFieldByCorporateField(String corporateField, String corporateName);
}
    
