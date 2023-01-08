package g2t1.DigitalRemittance.transaction;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import g2t1.DigitalRemittance.mappingcu.*;
import g2t1.DigitalRemittance.mappingrc.*;
import g2t1.DigitalRemittance.transactionstatus.*;
import g2t1.DigitalRemittance.validation.*;

@Service
public class TransactionService {
    private TransactionRepository transactionRepository;
    private MappingCURepository mappingCURepository;
    private MappingRCRepository mappingRCRepository;
    private MappingRCService mappingRCService;
    private TransactionStatusService transactionStatusService;
    private ValidationService validationService;

    @Autowired
    public TransactionService(TransactionRepository transactionRepository, MappingCURepository mappingCURepository, MappingRCRepository mappingRCRepository, MappingRCService mappingRCService, TransactionStatusService transactionStatusService, ValidationService validationService) {
        this.transactionRepository = transactionRepository;
        this.mappingCURepository = mappingCURepository;
        this.mappingRCRepository = mappingRCRepository;
        this.mappingRCService = mappingRCService;
        this.transactionStatusService = transactionStatusService;
        this.validationService = validationService;
    }

    public ArrayList<String> getSSOTBasedOnTransaction(Map<String, String> payload) {
        ArrayList<String> headers = new ArrayList<>();
        ArrayList<String> ssot = new ArrayList<>();
        try{
            FileInputStream file = new FileInputStream(new File(payload.get("fileAndPath")));
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheetAt(0);
            Row row = sheet.getRow(1);
            for(Cell cell : row) {
                headers.add(cell.getStringCellValue());
            }
            workbook.close();
        } catch(FileNotFoundException e){
            System.out.print(e.getMessage());
        } catch(IOException e){
            System.out.print(e.getMessage());
        }
        for(String corporateField : headers){
            String ssotField = mappingCURepository.getSSOTFieldByCorporateField(corporateField, payload.get("corporateName"));
            ssot.add(ssotField);
        }
        return ssot;
    }

    public ArrayList<Map<String, String>> getTransactionsRecords(Map<String, String> payload) {
        ArrayList<Map<String, String>> transactions = new ArrayList<>();
        ArrayList<String> ssot = getSSOTBasedOnTransaction(payload);
        DataFormatter df = new DataFormatter();


        try{
            FileInputStream file = new FileInputStream(new File(payload.get("fileAndPath")));
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheetAt(0);
            for(int i = 2; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                Map<String, String> transaction = new HashMap<>();
                for(int j = 0; j < row.getLastCellNum(); j++) {
                    Cell cell = row.getCell(j);
                    transaction.put(ssot.get(j), df.formatCellValue(cell));
                }
                transactions.add(transaction);
            }
            workbook.close();
        } catch(FileNotFoundException e){
            System.out.print(e.getMessage());
        } catch(IOException e){
            System.out.print(e.getMessage());
        }
        return transactions;
    }

    public String authenticate(Map<String, String> payload) {
        // request url
        String url = "https://prelive.paywho.com/api/smu_authenticate";

        // create an instance of RestTemplate
        RestTemplate restTemplate = new RestTemplate();

        // create headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        
        // build the request
        HttpEntity<Map<String, String>> entity = new HttpEntity<>(payload, headers);

        // send POST request
        ResponseEntity<String> response = restTemplate.postForEntity(url, entity, String.class);

        JSONObject jsonObject = new JSONObject(response.getBody());
        String token = jsonObject.getString("access_token");
        return token;
    }

    public ArrayList<Long> sendTransactionsToSandbox(Map<String, String> payload) {
        // request url
        String url = "https://prelive.paywho.com/api/smu_send_transaction";

        // create an instance of RestTemplate
        RestTemplate restTemplate = new RestTemplate();

        // create headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        // request body parameters
        Map<String, String> credentials = new HashMap<>();
        credentials.put("username", payload.get("username"));
        credentials.put("password", payload.get("password"));

        ArrayList<Long> transactionIDs = new ArrayList<>();

        long transactionID = 1;

        if(transactionRepository.getLatestTransactionID() != null){
            transactionID = Integer.parseInt(transactionRepository.getLatestTransactionID()) + 1;
        }

        for (Map<String, String> transaction : getTransactionsRecords(payload)) {
            String api_name = null;
            boolean validSSOT = true;
            
            if(Integer.parseInt(transaction.get("DestinationAmount")) <= 3000) {
                api_name = "financenow";
            }
            else if(Integer.parseInt(transaction.get("DestinationAmount")) <= 6000){
                api_name = "everywhereremit";
            }
            else{
                api_name = "paymentgo";
            }

            String token = authenticate(credentials);
            
            ArrayList<String> ssotFields = mappingRCRepository.getSSOTFieldByCompanyName(api_name);
            Map<String, String> rcToSSOT = new HashMap<>();
            for(String ssot : ssotFields) {
                String companyField = mappingRCRepository.getCompanyFieldBySSOTAndCompanyName(api_name, ssot);
                rcToSSOT.put(companyField, ssot);
            }

            Map<String, String> rcToValue = new HashMap<>();
            for(String companyField : rcToSSOT.keySet()) {
                if(transaction.get(rcToSSOT.get(companyField)) != null){
                    rcToValue.put(companyField, transaction.get(rcToSSOT.get(companyField)));
                }
                else{
                    rcToValue.put(companyField, "-");
                }
            }

            String payloadParams = "{";
            for(String key : rcToValue.keySet()) {
                payloadParams += "\"" + key + "\":\"" + rcToValue.get(key) + "\",";
                String ssot = mappingRCService.getSSOTFieldByCompanyNameAndCompanyField(api_name, key);
                if(validSSOT && !(rcToValue.get(key).equals("-"))) {
                    validSSOT = validationService.validateSSOT(api_name, ssot);
                    System.out.println("SSOT: " + ssot + "Valid : " + validationService.validateSSOT(api_name, ssot));
                }
                transactionRepository.save(new Transaction(transactionID, ssot, rcToValue.get(key), payload.get("corporateName")));
            }
            payloadParams = payloadParams.substring(0, payloadParams.length() - 1);
            payloadParams += "}";

            System.out.println("Transaction ID: " + transactionID + " Valid: " + validSSOT);
            if(validSSOT){
                String sendTransaction = "{" + "\"access_token\" : \"" + token + "\", \"api_name\" : \"" + api_name + "\", \"payload\" : " + payloadParams + "}";
                
                HttpEntity<String> entity = new HttpEntity<>(sendTransaction, headers);
                // send POST request
                ResponseEntity<String> response = restTemplate.postForEntity(url, entity, String.class);
        
                JSONObject jsonObject = new JSONObject(response.getBody());
                String status = jsonObject.getString("message");
                transactionStatusService.storeTransactionStatus(transactionID, status);
            } else{
                transactionStatusService.storeTransactionStatus(transactionID, "Failed to send due to invalid SSOT values");
            }
            transactionIDs.add(transactionID);
            transactionID++;
        }
        
        return transactionIDs;
    }
}
