package g2t1.DigitalRemittance.mappingrc;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MappingRCRepository extends JpaRepository<MappingRC, MappingRcPK> {
    @Query("SELECT ssotField FROM MappingRC WHERE companyName = ?1")
    ArrayList<String> getSSOTFieldByCompanyName(String companyName);
    
    @Query("SELECT companyField FROM MappingRC WHERE companyName = ?1 AND ssotField = ?2")
    String getCompanyFieldBySSOTAndCompanyName(String companyName, String ssotField);

    @Query("SELECT ssotField From MappingRC WHERE companyName = ?1 AND companyField = ?2")
    String getSSOTFieldByCompanyNameAndCompanyField(String companyName, String companyField);
}
