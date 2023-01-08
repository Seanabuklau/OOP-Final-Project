package g2t1.DigitalRemittance.mappingcu;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MappingCUConfig {

    @Bean
    CommandLineRunner clrMappingCU(MappingCURepository repository){
        return args -> {
            MappingCU cu1 = new MappingCU("TestCorp", "Sender First Name", "SenderFirstName");
            MappingCU cu2 = new MappingCU("TestCorp", "Sender Last Name", "SenderLastName");
            MappingCU cu3 = new MappingCU("TestCorp", "Sender ID Number", "SenderIdNumber");
            MappingCU cu4 = new MappingCU("TestCorp", "Sender ID Type", "SenderIdType");
            MappingCU cu5 = new MappingCU("TestCorp", "Sender Date of Birth", "SenderDOB");
            MappingCU cu6 = new MappingCU("TestCorp", "Sender Nationality", "SenderNationality");
            MappingCU cu7 = new MappingCU("TestCorp", "Sender Country", "SenderCountry");
            MappingCU cu8 = new MappingCU("TestCorp", "Sender City", "SenderCity");
            MappingCU cu9 = new MappingCU("TestCorp", "Sender Address", "SenderAddress");
            MappingCU cu10 = new MappingCU("TestCorp", "Purpose of Remittance", "PurposeOfRemittance");
            MappingCU cu11 = new MappingCU("TestCorp", "Relationship", "SenderRelationship");
            MappingCU cu12 = new MappingCU("TestCorp", "Source of Fund", "SenderSourceOfFund");
            MappingCU cu13 = new MappingCU("TestCorp", "Receiver First Name", "ReceiverFirstName");
            MappingCU cu14 = new MappingCU("TestCorp", "Receiver Last Name", "ReceiverLastName");
            MappingCU cu15 = new MappingCU("TestCorp", "Receiver ID Number", "ReceiverIdNumber");
            MappingCU cu16 = new MappingCU("TestCorp", "Receiver ID Type", "ReceiverIdType");
            MappingCU cu17 = new MappingCU("TestCorp", "Receiver Date of Birth", "ReceiverDOB");
            MappingCU cu18 = new MappingCU("TestCorp", "Receiver Account Number", "ReceiverBankAccountNo");
            MappingCU cu19 = new MappingCU("TestCorp", "Receiver Nationality", "ReceiverNationality");
            MappingCU cu20 = new MappingCU("TestCorp", "Receiver City", "ReceiverCity");
            MappingCU cu21 = new MappingCU("TestCorp", "Receiver Address", "ReceiverAddress");
            MappingCU cu22 = new MappingCU("TestCorp", "Receiving Amount", "DestinationAmount");

            repository.saveAll(List.of(cu1, cu2, cu3, cu4, cu5, cu6, cu7, cu8, cu9, cu10, cu11, cu12, cu13, cu14, cu15, cu16, cu17, cu18, cu19, cu20, cu21, cu22));
        };
    }
}