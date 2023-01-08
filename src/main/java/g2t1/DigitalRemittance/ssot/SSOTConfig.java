package g2t1.DigitalRemittance.ssot;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SSOTConfig {
    
    @Bean
    CommandLineRunner clrSSOT(SSOTRepository repository){
        return args -> {
            SSOT s1 = new SSOT("ReceiverBankAccountNo", "String");
            SSOT s2 = new SSOT("PaymentMode", "String");
            SSOT s3 = new SSOT("ReceiverCurrency", "String");
            SSOT s4 = new SSOT("PurposeOfRemittance", "String");
            SSOT s5 = new SSOT("ReceiverAddress", "String");
            SSOT s6 = new SSOT("ReceiverCity", "String");
            SSOT s7 = new SSOT("ReceiverCountry", "String");
            SSOT s8 = new SSOT("ReceiverFirstName", "String");
            SSOT s9 = new SSOT("ReceiverIdNumber", "String");
            SSOT s10 = new SSOT("ReceiverIdType", "String");
            SSOT s11 = new SSOT("ReceiverLastName", "String");
            SSOT s12 = new SSOT("SenderAddress", "String");
            SSOT s13 = new SSOT("SenderRelationship", "String");
            SSOT s14 = new SSOT("SenderCity", "String");
            SSOT s15 = new SSOT("SenderCountry", "String");
            SSOT s16 = new SSOT("SenderDOB", "String");
            SSOT s17 = new SSOT("SenderFirstName", "String");
            SSOT s18 = new SSOT("SenderIdNumber", "String");
            SSOT s19 = new SSOT("SenderIdType", "String");
            SSOT s20 = new SSOT("SenderLastName", "String");
            SSOT s21 = new SSOT("SenderNationality", "String");
            SSOT s22 = new SSOT("SenderSourceOfFund", "String");
            SSOT s23 = new SSOT("SenderState", "String");
            SSOT s24 = new SSOT("ReceiverNationality", "String");
            SSOT s25 = new SSOT("DestinationAmount", "String");
            SSOT s26 = new SSOT("SettlementCurrency", "String");
            SSOT s27 = new SSOT("ReceiverDOB", "String");
            SSOT s28 = new SSOT("ReceiverMobileNumber", "String");
            SSOT s29 = new SSOT("ReceiverBankName", "String");
            SSOT s30 = new SSOT("ReceiverBankBranchName", "String");
            SSOT s31 = new SSOT("SenderBankAccountNo", "String");
            SSOT s32 = new SSOT("SourceType", "String");
            SSOT s33 = new SSOT("SenderIDCountryOfIssue", "String");
            SSOT s34 = new SSOT("SenderBirthCountry", "String");
            SSOT s35 = new SSOT("BankAccountType", "String");
            SSOT s36 = new SSOT("EWalletID", "String");
            SSOT s37 = new SSOT("Segment", "String");

            repository.saveAll(List.of(
                    s1, s2, s3, s4, s5, s6, s7, s8, s9, s10,
                    s11, s12, s13, s14, s15, s16, s17, s18, s19, s20, 
                    s21, s22, s23, s24, s25, s26, s27, s28, s29, s30, 
                    s31, s32, s33, s34, s35, s36, s37));
        };
    }   
}
