package g2t1.DigitalRemittance.validation;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ValidationConfig {
    @Bean
    CommandLineRunner clrValidation(ValidationRepository repository){
        return args -> {
            Validation v1 = new Validation("FinanceNow", "ReceiverBankAccountNo", "minLength", "1");
            Validation v2 = new Validation("FinanceNow", "ReceiverBankAccountNo", "maxLength", "20");
            Validation v3 = new Validation("FinanceNow", "PaymentMode", "minLength", "0");
            Validation v4 = new Validation("FinanceNow", "PaymentMode", "maxLength", "50");
            Validation v5 = new Validation("FinanceNow", "ReceiverCurrency", "minLength", "3");
            Validation v6 = new Validation("FinanceNow", "ReceiverCurrency", "maxLength", "3");
            Validation v7 = new Validation("FinanceNow", "PurposeOfRemittance", "minLength", "1");
            Validation v8 = new Validation("FinanceNow", "PurposeOfRemittance", "maxLength", "3");
            Validation v9 = new Validation("FinanceNow", "ReceiverAddress", "minLength", "1");
            Validation v10 = new Validation("FinanceNow", "ReceiverAddress", "maxLength", "25");
            Validation v11 = new Validation("FinanceNow", "ReceiverCity", "minLength", "1");
            Validation v12 = new Validation("FinanceNow", "ReceiverCity", "maxLength", "25");
            Validation v13 = new Validation("FinanceNow", "ReceiverCountry", "minLength", "1");
            Validation v14 = new Validation("FinanceNow", "ReceiverCountry", "maxLength", "3");
            Validation v15 = new Validation("FinanceNow", "ReceiverFirstName", "minLength", "1");
            Validation v16 = new Validation("FinanceNow", "ReceiverFirstName", "maxLength", "50");
            Validation v17 = new Validation("FinanceNow", "ReceiverIdNumber", "minLength", "1");
            Validation v18 = new Validation("FinanceNow", "ReceiverIdNumber", "maxLength", "50");
            Validation v19 = new Validation("FinanceNow", "ReceiverIdType", "minLength", "2");
            Validation v20 = new Validation("FinanceNow", "ReceiverIdType", "maxLength", "2");
            Validation v21 = new Validation("FinanceNow", "ReceiverLastName", "minLength", "1");
            Validation v22 = new Validation("FinanceNow", "ReceiverLastName", "maxLength", "30");
            Validation v23 = new Validation("FinanceNow", "SenderAddress", "minLength", "0");
            Validation v24 = new Validation("FinanceNow", "SenderAddress", "maxLength", "60");
            Validation v25 = new Validation("FinanceNow", "SenderRelationship", "minLength", "1");
            Validation v26 = new Validation("FinanceNow", "SenderRelationship", "maxLength", "10");
            Validation v27 = new Validation("FinanceNow", "SenderCity", "minLength", "0");
            Validation v28 = new Validation("FinanceNow", "SenderCity", "maxLength", "50");
            Validation v29 = new Validation("FinanceNow", "SenderCountry", "minLength", "0");
            Validation v30 = new Validation("FinanceNow", "SenderCountry", "maxLength", "3");
            Validation v31 = new Validation("FinanceNow", "SenderDOB", "minLength", "1");
            Validation v32 = new Validation("FinanceNow", "SenderDOB", "maxLength", "11");
            Validation v33 = new Validation("FinanceNow", "SenderFirstName", "minLength", "1");
            Validation v34 = new Validation("FinanceNow", "SenderFirstName", "maxLength", "50");
            Validation v35 = new Validation("FinanceNow", "SenderIdNumber", "minLength", "1");
            Validation v36 = new Validation("FinanceNow", "SenderIdNumber", "maxLength", "13");
            Validation v37 = new Validation("FinanceNow", "SenderIdType", "minLength", "2");
            Validation v38 = new Validation("FinanceNow", "SenderIdType", "maxLength", "2");
            Validation v39 = new Validation("FinanceNow", "SenderLastName", "minLength", "1");
            Validation v40 = new Validation("FinanceNow", "SenderLastName", "maxLength", "50");
            Validation v41 = new Validation("FinanceNow", "SenderNationality", "minLength", "1");
            Validation v42 = new Validation("FinanceNow", "SenderNationality", "maxLength", "3");
            Validation v43 = new Validation("FinanceNow", "SenderSourceOfFund", "minLength", "1");
            Validation v44 = new Validation("FinanceNow", "SenderSourceOfFund", "maxLength", "10");
            Validation v45 = new Validation("FinanceNow", "SenderState", "minLength", "0");
            Validation v46 = new Validation("FinanceNow", "SenderState", "maxLength", "20");
            Validation v47 = new Validation("FinanceNow", "ReceiverNationality", "minLength", "1");
            Validation v48 = new Validation("FinanceNow", "ReceiverNationality", "maxLength", "3");


            // Validation v49 = new Validation("EverywhereRemit", "SourceType", "", "");
            Validation v50 = new Validation("EverywhereRemit", "SenderBirthCountry", "minLength", "3");
            Validation v51 = new Validation("EverywhereRemit", "SenderBirthCountry", "maxLength", "3");
            //Validation v52 = new Validation("EverywhereRemit", "Segment", "", "");
            Validation v53 = new Validation("EverywhereRemit", "SenderFirstName", "maxLength", "50");
            Validation v54 = new Validation("EverywhereRemit", "SenderFirstName", "regex", "^[A-Za-z0-9.-]+$");
            Validation v55 = new Validation("EverywhereRemit", "SenderLastName", "maxLength", "50");
            Validation v56 = new Validation("EverywhereRemit", "SenderLastName", "regex", "^[A-Za-z0-9.-]+$");
            Validation v57 = new Validation("EverywhereRemit", "SenderDOB", "rege", "/\\d{4}-\\d{1,2}-\\d{1,2}/");
            Validation v58 = new Validation("EverywhereRemit", "SenderNationality", "minLength", "3");
            Validation v59 = new Validation("EverywhereRemit", "SenderNationality", "maxLength", "3");
            Validation v60 = new Validation("EverywhereRemit", "SenderIDType", "value", "national,passport");
            Validation v62 = new Validation("EverywhereRemit", "SenderIDCountryOfIssue", "minLength", "3");
            Validation v63 = new Validation("EverywhereRemit", "SenderIDCountryOfIssue", "maxLength", "3");
            //Validation v64 = new Validation("EverywhereRemit", "SenderIDNumber", "", "");
            Validation v65 = new Validation("EverywhereRemit", "SettlementCurrency", "currency", "EUR,SGD,USD");
            Validation v66 = new Validation("EverywhereRemit", "SenderAddress", "regex", "^[A-Za-z0-9.-]+$");
            Validation v67 = new Validation("EverywhereRemit", "SenderCity", "regex", "^[A-Za-z0-9.-]+$");
            Validation v68 = new Validation("EverywhereRemit", "SenderCountry", "minLength", "3");
            Validation v69 = new Validation("EverywhereRemit", "SenderCountry", "maxLength", "3");
            //Validation v70 = new Validation("EverywhereRemit", "BankAccountType", "", "");
            Validation v71 = new Validation("EverywhereRemit", "ReceiverCountry", "minLength", "3");
            Validation v72 = new Validation("EverywhereRemit", "ReceiverCountry", "maxLength", "3");
            Validation v73 = new Validation("EverywhereRemit", "ReceiverFirstName", "maxLength", "50");
            Validation v74 = new Validation("EverywhereRemit", "ReceiverFirstName", "regex", "^[A-Za-z0-9.-]+$");
            Validation v75 = new Validation("EverywhereRemit", "ReceiverLastName", "maxLength", "50");
            Validation v76 = new Validation("EverywhereRemit", "ReceiverLastName", "regex", "^[A-Za-z0-9.-]+$");
            //Validation v77 = new Validation("EverywhereRemit", "ReceiverMobileNumber", "", "");
            Validation v78 = new Validation("EverywhereRemit", "EWalletID", "maxLength", "128");
            //Validation v79 = new Validation("EverywhereRemit", "ReceiverCurrency", "", "");
            //Validation v80 = new Validation("EverywhereRemit", "DestinationAmount", "", "");
            //Validation v81 = new Validation("EverywhereRemit", "SenderSourceOfFund", "", "");
            //Validation v82 = new Validation("EverywhereRemit", "PurposeOfRemittance", "", "");


            // Validation v83 = new Validation("PaymentGo", "payeeAccountNo", "", "");
            // Validation v84 = new Validation("PaymentGo", "transCurrency", "", "");
            // Validation v85 = new Validation("PaymentGo", "remitPurpose", "", "");
            // Validation v86 = new Validation("PaymentGo", "payeeGivenName", "", "");
            // Validation v87 = new Validation("PaymentGo", "payeeCaNo", "", "");
            // Validation v88 = new Validation("PaymentGo", "payeeCaType", "", "");
            // Validation v89 = new Validation("PaymentGo", "payeeSurname", "", "");
            // Validation v90 = new Validation("PaymentGo", "remitAddress", "", "");
            // Validation v91 = new Validation("PaymentGo", "remitCountryCode", "", "");
            // Validation v92 = new Validation("PaymentGo", "remitGivenName", "", "");
            // Validation v93 = new Validation("PaymentGo", "remitCaNo", "", "");
            // Validation v94 = new Validation("PaymentGo", "remitCaType", "", "");
            // Validation v95 = new Validation("PaymentGo", "remitSurname", "", "");
            // Validation v96 = new Validation("PaymentGo", "nationality", "", "");
            // Validation v97 = new Validation("PaymentGo", "sourceOfFunds", "", "");
            // Validation v98 = new Validation("PaymentGo", "merTransAmount", "", "");
            // Validation v99 = new Validation("PaymentGo", "settleCurrency", "", "");
            // Validation v100 = new Validation("PaymentGo", "payeeBirthDate", "", "");
            // Validation v101 = new Validation("PaymentGo", "payeePhone", "", "");
            // Validation v102 = new Validation("PaymentGo", "payeeBankName", "", "");
            // Validation v103 = new Validation("PaymentGo", "payeeBranchName", "", "");
            // Validation v104 = new Validation("PaymentGo", "remitAccountNo", "", "");

            repository.saveAll(List.of(
                v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11, v12, v13, v14, v15, v16, v17, v18, v19, v20, v21, v22, v23, v24, v25, v26, v27, v28, v29, v30, v31, v32, v33, v34, v35, v36, v37, v38, v39, v40, v41, v42, v43, v44, v45, v46, v47, v48, v50, v51, v53, v54, v55, v56, v57, v58, v59, v60, v62, v63, v65, v66, v67, v68, v69, v71, v72, v73, v74, v75, v76, v78));
        };
    }
}