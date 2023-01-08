package g2t1.DigitalRemittance.company;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CompanyRepository extends JpaRepository<Company, CompanyPK> {
    @Query("SELECT c FROM Company c WHERE c.companyName = ?1")
    ArrayList<Company> findCompanyFieldByName(String companyName);
}
