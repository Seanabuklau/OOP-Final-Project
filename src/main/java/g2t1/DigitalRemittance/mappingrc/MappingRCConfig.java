package g2t1.DigitalRemittance.mappingrc;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MappingRCConfig {

    @Bean
    CommandLineRunner clrMappingRC(MappingRCRepository repository){
        return args -> {
            MappingRC rc1 = new MappingRC("EverywhereRemit",  "recipient_currency", "ReceiverCurrency" );
            MappingRC rc2 = new MappingRC("EverywhereRemit",  "remittance_purpose", "PurposeOfRemittance" ); 
            MappingRC rc3 = new MappingRC("EverywhereRemit",  "recipient_country", "ReceiverCountry" ); 
            MappingRC rc4 = new MappingRC("EverywhereRemit",  "recipient_legal_name_first", "ReceiverFirstName" ); 
            MappingRC rc5 = new MappingRC("EverywhereRemit",  "recipient_legal_name_last", "ReceiverLastName" ); 
            MappingRC rc6 = new MappingRC("EverywhereRemit",  "sender_address_line", "SenderAddress" ); 
            MappingRC rc7 = new MappingRC("EverywhereRemit",  "sender_address_city", "SenderCity" ); 
            MappingRC rc8 = new MappingRC("EverywhereRemit",  "sender_address_country", "SenderCountry" ); 
            MappingRC rc9 = new MappingRC("EverywhereRemit",  "sender_date_of_birth", "SenderDOB" ); 
            MappingRC rc10 = new MappingRC("EverywhereRemit",  "sender_legal_name_first", "SenderFirstName" ); 
            MappingRC rc11 = new MappingRC("EverywhereRemit",  "sender_id_number", "SenderIDNumber" ); 
            MappingRC rc12 = new MappingRC("EverywhereRemit",  "sender_id_type", "SenderIDType" ); 
            MappingRC rc13 = new MappingRC("EverywhereRemit",  "sender_legal_name_last", "SenderLastName" ); 
            MappingRC rc14 = new MappingRC("EverywhereRemit",  "sender_nationality", "SenderNationality" ); 
            MappingRC rc15 = new MappingRC("EverywhereRemit",  "source_of_funds", "SenderSourceOfFund" ); 
            MappingRC rc16 = new MappingRC("EverywhereRemit",  "units", "DestinationAmount" ); 
            MappingRC rc17 = new MappingRC("EverywhereRemit",  "sender_currency", "SettlementCurrency" ); 
            MappingRC rc18 = new MappingRC("EverywhereRemit",  "recipient_mobile_number", "ReceiverMobileNumber" ); 
            MappingRC rc19 = new MappingRC("EverywhereRemit",  "source_type", "SourceType" ); 
            MappingRC rc20 = new MappingRC("EverywhereRemit",  "sender_id_country", "SenderIDCountryOfIssue" ); 
            MappingRC rc21 = new MappingRC("EverywhereRemit",  "sender_country", "SenderBirthCountry" ); 
            MappingRC rc22 = new MappingRC("EverywhereRemit",  "recipient_type", "BankAccountType" ); 
            MappingRC rc23 = new MappingRC("EverywhereRemit",  "recipient_account_number", "EWalletID" ); 
            MappingRC rc24 = new MappingRC("EverywhereRemit",  "segment", "Segment" );

            MappingRC rc25 = new MappingRC("FinanceNow", "BankAccountNumber", "ReceiverBankAccountNo");
            MappingRC rc26= new MappingRC("FinanceNow", "PaymentMode", "PaymentMode");
            MappingRC rc27 = new MappingRC("FinanceNow", "PayoutCurrency", "ReceiverCurrency");
            MappingRC rc28 = new MappingRC("FinanceNow", "PurposeOfRemittance", "PurposeOfRemittance");
            MappingRC rc29 = new MappingRC("FinanceNow", "ReceiverAddress", "ReceiverAddress");
            MappingRC rc30 = new MappingRC("FinanceNow", "ReceiverCity", "ReceiverCity");
            MappingRC rc31 = new MappingRC("FinanceNow", "ReceiverCountry", "ReceiverCountry");
            MappingRC rc32 = new MappingRC("FinanceNow", "ReceiverFirstName", "ReceiverFirstName");
            MappingRC rc33 = new MappingRC("FinanceNow", "ReceiverIdNumber", "ReceiverIdNumber");
            MappingRC rc34 = new MappingRC("FinanceNow", "ReceiverIdType", "ReceiverIdType");
            MappingRC rc35 = new MappingRC("FinanceNow", "ReceiverLastName", "ReceiverLastName");
            MappingRC rc36 = new MappingRC("FinanceNow", "SenderAddress", "SenderAddress");
            MappingRC rc37 = new MappingRC("FinanceNow", "SenderBeneficiaryRelationship", "SenderRelationship");
            MappingRC rc38 = new MappingRC("FinanceNow", "SenderCity", "SenderCity");
            MappingRC rc39 = new MappingRC("FinanceNow", "SenderCountry", "SenderCountry");
            MappingRC rc40 = new MappingRC("FinanceNow", "SenderDateOfBirth", "SenderDOB");
            MappingRC rc41 = new MappingRC("FinanceNow", "SenderFirstName", "SenderFirstName");
            MappingRC rc42 = new MappingRC("FinanceNow", "SenderIdNumber", "SenderIdNumber");
            MappingRC rc43 = new MappingRC("FinanceNow", "SenderIdType", "SenderIdType");
            MappingRC rc44 = new MappingRC("FinanceNow", "SenderLastName", "SenderLastName");
            MappingRC rc45 = new MappingRC("FinanceNow", "SenderNationality", "SenderNationality");
            MappingRC rc46 = new MappingRC("FinanceNow", "SenderSourceOfFund", "SenderSourceOfFund");
            MappingRC rc47 = new MappingRC("FinanceNow", "SenderState", "SenderState");
            MappingRC rc48 = new MappingRC("FinanceNow", "ReceiverNationality", "ReceiverNationality");
            MappingRC rc49 = new MappingRC("FinanceNow", "TransferAmount", "DestinationAmount");

            MappingRC rc50 = new MappingRC("PaymentGo", "payeeAccountNo", "ReceiverBankAccountNo");
            MappingRC rc51 = new MappingRC("PaymentGo", "transCurrency", "ReceiverCurrency");
            MappingRC rc52 = new MappingRC("PaymentGo", "remitPurpose", "PurposeOfRemittance");
            MappingRC rc53 = new MappingRC("PaymentGo", "payeeGivenName", "ReceiverFirstName");
            MappingRC rc54 = new MappingRC("PaymentGo", "payeeCaNo", "ReceiverIdNumber");
            MappingRC rc55 = new MappingRC("PaymentGo", "payeeCaType", "ReceiverIdType");
            MappingRC rc56 = new MappingRC("PaymentGo", "payeeSurname", "ReceiverLastName");
            MappingRC rc57 = new MappingRC("PaymentGo", "remitAddress", "SenderAddress");
            MappingRC rc58 = new MappingRC("PaymentGo", "remitCountryCode", "SenderCountry");
            MappingRC rc59 = new MappingRC("PaymentGo", "remitGivenName", "SenderFirstName");
            MappingRC rc60 = new MappingRC("PaymentGo", "remitCaNo", "SenderIdNumber");
            MappingRC rc61 = new MappingRC("PaymentGo", "remitCaType", "SenderIdType");
            MappingRC rc62 = new MappingRC("PaymentGo", "remitSurname", "SenderLastName");
            MappingRC rc63 = new MappingRC("PaymentGo", "nationality", "SenderNationality");
            MappingRC rc64 = new MappingRC("PaymentGo", "sourceOfFunds", "SenderSourceOfFund");
            MappingRC rc65 = new MappingRC("PaymentGo", "merTransAmount", "DestinationAmount");
            MappingRC rc66 = new MappingRC("PaymentGo", "settleCurrency", "SettlementCurrency");
            MappingRC rc67 = new MappingRC("PaymentGo", "payeeBirthDate", "ReceiverDOB");
            MappingRC rc68 = new MappingRC("PaymentGo", "payeePhone", "ReceiverMobileNumber");
            MappingRC rc69 = new MappingRC("PaymentGo", "payeeBankName", "ReceiverBankName");
            MappingRC rc70 = new MappingRC("PaymentGo", "payeeBranchName", "ReceiverBankBranchName");
            MappingRC rc71 = new MappingRC("PaymentGo", "remitAccountNo", "SenderBankAccountNo");

            repository.saveAll(List.of(
                rc1, rc2, rc3, rc4, rc5, rc6, rc7, rc8, rc9, rc10, rc11, rc12, rc13, rc14, rc15, rc16, rc17, rc18, rc19, rc20, rc21, rc22, rc23, rc24, rc25, rc26, rc27, rc28, rc29, rc30, rc31, rc32, rc33, rc34, rc35, rc36, rc37, rc38, rc39, rc40, rc41, rc42, rc43, rc44, rc45, rc46, rc47, rc48, rc49, rc50, rc51, rc52, rc53, rc54, rc55, rc56, rc57, rc58, rc59, rc60, rc61, rc62, rc63, rc64, rc65, rc66, rc67, rc68, rc69, rc70, rc71
            ));
        };
    }
}