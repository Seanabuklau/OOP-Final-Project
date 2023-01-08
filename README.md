# IS442-OOP
Digital Remittance Portal 
Our project aims to provide corporate users a convenient way to do cross-border funds transfer. By building a Single Source of Truth, our application allows corporate users (CU) to make transfers to various APIs with different mandatory fields.

## Technologies
We built our UI using Bootstrap and Vue.js framework. We use Java and SpringBoot for the backend processes and MySQL for the database.

## Building a RESTful web service with Spring

File Structure:
```
|-- .idea
|-- Digital Remittance
|   |-- .idea
|       |-- .gitignore
|       |-- compiler.xml
|       |-- encodings.xml
|       |-- jarRepositories.xml
|       |-- misc.xml
|       |-- vcs.xml
|       |-- workspace.xml
|   |-- .mvn
|       |-- maven-wrapper.jar
|       |-- maven-wrapper.properties
|   |-- data
|       |-- Transaction.xlsx
|   |-- frontend
|       |-- sources
|       |-- app.js
|       |-- end.html
|       |-- landing_page.html
|       |-- login_page.html
|       |-- mapping.html
|       |-- mapping.js
|       |-- signup_page.html
|       |-- signup.js
|       |-- styles.css
|       |-- transaction.js
|       |-- transactions.html
|       |-- upload.html
|       |-- upload.js
|   |-- src
|       |-- main
|           |-- java/g2t1/DigitalRemittance
|               |-- company
|                   |-- Company.java
|                   |-- CompanyConfig.java
|                   |-- CompanyController.java
|                   |-- CompanyPK.java
|                   |-- CompanyRepository.java
|                   |-- CompanyService.java      
|               |-- mappingcu   
|                   |-- MappingCU.java
|                   |-- MappingCUConfig.java
|                   |-- MappingCUController.java
|                   |-- MappingCuPK.java
|                   |-- MappingCURepository.java
|                   |-- MappingCUService.java      
|               |-- mappingrc
|                   |-- MappingRC.java
|                   |-- MappingRCConfig.java
|                   |-- MappingRCController.java
|                   |-- MappingRcPK.java
|                   |-- MappingRCRepository.java
|                   |-- MappingRCService.java 
|               |-- onboarding
|                   |-- DocumentController.java
|                   |-- DocumentStorageException.java
|                   |-- DocumentStorageProperties.java
|                   |-- DocumentStoragePropertiesRepo.java
|                   |-- DocumentStorageService.java
|                   |-- OnboardingController.java      
|                   |-- UploadFileResponse.java 
|               |-- processor
|                   |-- ExcelProcessor.java          
|               |-- ssot
|                   |-- Ssot.java
|                   |-- SsotConfig.java
|                   |-- SSOTController.java
|                   |-- SsotRepository.java
|                   |-- SSOTService.java
|               |-- transaction
|                   |-- Transaction.java
|                   |-- TransactionController.java
|                   |-- TransactionPK.java
|                   |-- TransactionRepository.java
|                   |-- TransactionService.java
|               |-- transactionstatus
|                   |-- TransactionStatus.java
|                   |-- TransactionStatusController.java
|                   |-- TransactionStatusRepository.java
|                   |-- TransactionStatusService.java      
|               |-- validation
|                   |-- Validation.java
|                   |-- ValidationConfig.java
|                   |-- ValidationController.java
|                   |-- ValidationPK.java
|                   |-- ValidationRepository.java 
|                   |-- ValidationService.java     
|           |-- DigitalRemittanceApplication.java        
|           |-- resources
|               |-- application.properties         
|       |-- test/java/g2t1/DigitalRemittance
|           |-- http-test
|               |-- onboarding.http         
|               |-- transaction.http         
|               |-- transactionStatus.http         
|               |-- validation.http         
|           |-- DigitalRemittanceApplicationTests.java
|   |-- target
|       |-- classes
|           |-- g2t1/DigitalRemittance
|               |-- company
|                   |-- Company.class
|                   |-- CompanyConfig.class
|                   |-- CompanyController.class
|                   |-- CompanyPK.class
|                   |-- CompanyRepository.class
|                   |-- CompanyService.class      
|               |-- mappingcu   
|                   |-- MappingCU.class
|                   |-- MappingCUConfig.class
|                   |-- MappingCUController.class
|                   |-- MappingCuPK.class
|                   |-- MappingCURepository.class
|                   |-- MappingCUService.class      
|               |-- mappingrc
|                   |-- MappingRC.class
|                   |-- MappingRCConfig.class
|                   |-- MappingRCController.class
|                   |-- MappingRcPK.class
|                   |-- MappingRCRepository.class
|                   |-- MappingRCService.class 
|               |-- onboarding
|                   |-- DocumentController.class
|                   |-- DocumentStorageException.class
|                   |-- DocumentStorageProperties.class
|                   |-- DocumentStoragePropertiesRepo.class
|                   |-- DocumentStorageService.class
|                   |-- OnboardingController.class      
|                   |-- UploadFileResponse.class 
|               |-- processor
|                   |-- ExcelProcessor.class          
|               |-- ssot
|                   |-- SSOT.class
|                   |-- SSOTConfig.class
|                   |-- SSOTController.class
|                   |-- SSOTRepository.class
|                   |-- SSOTService.class
|               |-- transaction
|                   |-- Transaction.class
|                   |-- TransactionController.class
|                   |-- TransactionPK.class
|                   |-- TransactionRepository.class
|                   |-- TransactionService.class
|               |-- transactionstatus
|                   |-- TransactionStatus.class
|                   |-- TransactionStatusController.class
|                   |-- TransactionStatusRepository.class
|                   |-- TransactionStatusService.class      
|               |-- validation
|                   |-- Validation.class
|                   |-- ValidationConfig.class
|                   |-- ValidationController.class
|                   |-- ValidationPK.class
|                   |-- ValidationRepository.class 
|                   |-- ValidationService.class     
|               |-- DigitalRemittanceApplication.class        
|           |-- application.properties
|       |-- test-classes/g2t1/DigitalRemittance
|           |-- http-test
|               |-- onboarding.http         
|               |-- transaction.http         
|               |-- transactionStatus.http         
|               |-- validation.http         
|           |-- DigitalRemittanceApplicationTests.class
|   |-- .gitignore
|   |-- mvnw
|   |-- mvnw.cmd
|   |-- pom.xml
|   |-- READ.me
```

## Running the Application
1. Clone this repository 
2. Place the source repository inside wamp/www directory
3. Change directory into IS442-OOP/DigitalRemittance
4. To run the application, run the following command in a terminal window (in the complete) directory:
./mvnw spring-boot:run or mvnw spring-boot:run or mvn spring-boot:run

## UI/UX Features
### User Interface
Following Nielsen’s 10 heuristic evaluation, our team created a simple and clean UI:
1. UI for Mapping (Onboarding)
2. UI for Transaction

### User Experience 
Onboarding
The key features of onboarding are as follow:
- CU uploads CSV containing Corporate Fields
- Portal maps Corporate Fields to SSOT
- Portal saves Mapping configuration in MySQL

Transaction
When CU wants to send transaction, the key processes are:
- CU uploads transactions using a CSV file
- App validates data uploaded 
- Returns status to UI
- App calls Sandbox for authentication
- App sends transaction to Sandbox
- Returns status to UI
- Store transactions in MySQL 
