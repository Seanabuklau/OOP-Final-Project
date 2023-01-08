package g2t1.DigitalRemittance.company;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CompanyConfig {
 
    @Bean
    CommandLineRunner clrCompany(CompanyRepository repository){
        return args -> {
            Company er1 = new Company("EverywhereRemit",  "recipient_currency", "String" );
            Company er2 = new Company("EverywhereRemit",  "remittance_purpose", "String" ); 
            Company er3 = new Company("EverywhereRemit",  "recipient_country", "String" ); 
            Company er4 = new Company("EverywhereRemit",  "recipient_legal_name_first", "String" ); 
            Company er5 = new Company("EverywhereRemit",  "recipient_legal_name_last", "String" ); 
            Company er6 = new Company("EverywhereRemit",  "sender_address_line", "String" ); 
            Company er7 = new Company("EverywhereRemit",  "sender_address_city", "String" ); 
            Company er8 = new Company("EverywhereRemit",  "sender_address_country", "String" ); 
            Company er9 = new Company("EverywhereRemit",  "sender_date_of_birth", "String"); 
            Company er10 = new Company("EverywhereRemit",  "sender_legal_name_first", "String" ); 
            Company er11 = new Company("EverywhereRemit",  "sender_id_number", "String" ); 
            Company er12 = new Company("EverywhereRemit",  "sender_id_type", "String" ); 
            Company er13 = new Company("EverywhereRemit",  "sender_legal_name_last", "String" ); 
            Company er14 = new Company("EverywhereRemit",  "sender_nationality", "String" ); 
            Company er15 = new Company("EverywhereRemit",  "source_of_funds", "String" ); 
            Company er16 = new Company("EverywhereRemit",  "units", "Double" ); 
            Company er17 = new Company("EverywhereRemit",  "sender_currency", "String" ); 
            Company er18 = new Company("EverywhereRemit",  "recipient_mobile_number", "String" ); 
            Company er19 = new Company("EverywhereRemit",  "source_type", "String" ); 
            Company er20 = new Company("EverywhereRemit",  "sender_id_country", "String" ); 
            Company er21 = new Company("EverywhereRemit",  "sender_country", "String" ); 
            Company er22 = new Company("EverywhereRemit",  "recipient_type", "String" ); 
            Company er23 = new Company("EverywhereRemit",  "recipient_account_number", "String" ); 
            Company er24 = new Company("EverywhereRemit",  "segment", "String" );

            repository.saveAll(List.of(
                    er1, er2, er3, er4, er5, er6, er7, er8, er9, er10, er11, er12, er13, er14, er15, er16, er17, er18, er19, er20, er21, er22, er23, er24
            ));
        };
    }
}
