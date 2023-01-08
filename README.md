# IS442-OOP
Digital Remittance Portal 
Our project aims to provide corporate users a convenient way to do cross-border funds transfer. By building a Single Source of Truth, our application allows corporate users (CU) to make transfers to various APIs with different mandatory fields.
Technologies
We built our UI using Bootstrap and Vue.js framework. We use Java and SpringBoot for the backend processes and MySQL for the database.

Building a RESTful web service with Spring

File Structure
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
Run the Application
Download and unzip the source repository for this guide, or clone it using Git: git clone [insert link]
Place the source repository inside wamp/www directory
cd into IS442-OOP/DigitalRemittance
To run the application, run the following command in a terminal window (in the complete) directory:
./mvnw spring-boot:run or mvnw spring-boot:run or mvn spring-boot:run

UI Designs
Following Nielsen’s 10 heuristic evaluation, our team created a simple and clean UI:
UI for Mapping (Onboarding)

UI for Transaction
	

Onboarding
During onboarding, the key features are as follow:
CU uploads CSV containing Corporate Fields
Portal maps Corporate Fields to SSOT
Portal saves Mapping configuration in MySQL

Transaction
When CU wants to send transaction, the key processes are:
CU uploads transactions using a CSV file
App validates data uploaded 
Returns status to UI
App calls Sandbox for authentication
App sends transaction to Sandbox
Returns status to UI
Store transactions in MySQL 


Diving into the Code
Big picture: We’re going to create a simple remittance service that maps the fields of a corporation to send transactions to various APIs. We’ll store company objects in a (H2 in-memory) database, and access them (via something called JPA). Then we’ll wrap that with something that will allow access over the internet (called the Spring MVC layer).

Company
DigitalRemittance/src/main/java/g2t1/DigitalRemittance/Company

/Company.java defines Remittance Companies. 
/CompanyRepository.java is an interface, extending JpaRepository. 
By declaring the interface, CompanyRepository will be able to:
Create new companies
Update existing companies
Delete Companies
Find Companies 
/CompanyController.java 
@RestController indicates that the data returned by each method will be written straight into the response body instead of rendering a template.
A companyService is injected by the constructor into the controller.
We have @GetMapping, corresponding to HTTP GET to:
Get all companies, 
Get company fields by company name,
We have @PostMapping, corresponding to HTTP POST to:
Add company fields 
/CompanyId.java implements Serializable to convert object state into String (as REST APIs send/receive JSON/XML)
/CompanyService.java
@Service provides following business functionalities:
Get all companies
Get company fields by company name 
Save new fields to company by company name

Mapping CU to SSOT
DigitalRemittance/src/main/java/g2t1/DigitalRemittance/MappingCU
/MappingCU.java defines Corporate Users and SSOT fields. 
/MappingCURepository.java is an interface, extending JpaRepository. 
By declaring the interface, MappingCURepository will be able to:
Create new fields
Update existing fields
Delete fields
Find fields 
/MappingCUController.java 
@RestController indicates that the data returned by each method will be written straight into the response body instead of rendering a template.
@RequestMapping annotation ensures that HTTP requests to /api/MappingCY are mapped to the addMapping() and getAll() method.
@CrossOrigin annotation enables cross-origin resource sharing only for this specific method
A mappingCUService is injected by the constructor into the controller.
We have @GetMapping, corresponding to HTTP GET to:
Get all mapping, 
We have @PostMapping, corresponding to HTTP POST to:
Add mapping to database 
/MappingCUId.java implements Serializable to convert object state into String (as REST APIs send/receive JSON/XML)
/MappingCUService.java
@Service provides following business functionalities:
Get all mapping
Save mapping to SSOT

Mapping RC to SSOT
DigitalRemittance/src/main/java/g2t1/DigitalRemittance/MappingRC

/MappingRC.java defines Remittance Companies and SSOT fields. 
/MappingRCRepository.java is an interface, extending JpaRepository. 
By declaring the interface, MappingRCRepository will be able to:
Create new fields
Update existing fields
Delete fields
Find fields 
/MappingRCController.java 
@RestController indicates that the data returned by each method will be written straight into the response body instead of rendering a template.
@RequestMapping annotation ensures that HTTP requests to /api/MappingRC are mapped to the getAll() method.
@CrossOrigin annotation enables cross-origin resource sharing only for this specific method
A mappingRCService is injected by the constructor into the controller.
We have @GetMapping, corresponding to HTTP GET to:
Get all mapping, 
/MappingRCId.java implements Serializable to convert object state into String (as REST APIs send/receive JSON/XML)
/MappingRCService.java
@Service provides following business functionalities:
Get all mapping

Onboarding
DigitalRemittance/src/main/java/g2t1/DigitalRemittance/Onboarding

/UploadFileResponse.java defines an uploaded file by name, type and size.
/OnboardingController.java
We have @PostMapping /onboarding, corresponding to HTTP POST to:
Get all headers from file

/DocumentController.java
We have @PostMapping /uploadFile, corresponding to HTTP POST to:
Add all headers to company table

/DocumentStorageException.java throws exception for invalid document storage
/DocumentStorageProperties.java defines document storage
/DocumentStoragePropertiesRepo.java is an interface, extending JpaRepository for CRUD operations.
/DocumentStorageService.java 
@Service provides following business functionalities:
Store file
Throws exception for invalid filename.
Load file
Throws exception for wrong URL/ file not found
Processor
DigitalRemittance/src/main/java/g2t1/DigitalRemittance/Processor
ExcelProcessor.java get headers of excel file uploaded by CU

Transaction
DigitalRemittance/src/main/java/g2t1/DigitalRemittance/Transaction

/Transaction.java defines transactions with SSOT field, value, and company name. 
/TransactionRepository.java is an interface, extending JpaRepository. 
By declaring the interface, MappingRCRepository will be able to:
Get latest transaction by transaction ID
/TransactionController.java 
@RestController indicates that the data returned by each method will be written straight into the response body instead of rendering a template.
@RequestMapping annotation ensures that HTTP requests to /api/transaction :
/header are mapped to the getSSOTBasedOnTransaction() method.
/auth are mapped to the authenticate() method.
/send are mapped to the sendTransactionsToSandbox() method.
/excel are mapped to the getTransactionsRecords() method.

A transactionService is injected by the constructor into the controller.
We have @PostMapping, corresponding to HTTP POST to:
Get all SSOT fields by transaction
Authentication transaction
Send transactions to Sandbox
Get transactions record
 
/TransactionPK.java implements Serializable to convert object state into String (as REST APIs send/receive JSON/XML)
/TransactionService.java
@Service provides following business functionalities:
Get SSOT fields based on transaction
Get transaction records
Authenticate:
Send HTTP request to API to get API token
Store access token
Send Transaction to Sandbox

Transaction Status
DigitalRemittance/src/main/java/g2t1/DigitalRemittance/TransactionStatus

/TransactionStatus.java defines transaction status by transaction ID. 
/TransactionStatusRepository.java is an interface, extending JpaRepository. 
By declaring the interface, MappingRCRepository will be able to:
Get transaction status by transaction ID
/TransactionStatusController.java 
@RestController indicates that the data returned by each method will be written straight into the response body instead of rendering a template.
@RequestMapping annotation ensures that HTTP requests to /api/transaction :
/status are mapped to the getTransactionStatus() method.
/all are mapped to the getAllTransactionStatus() method.

A transactionStatusService is injected by the constructor into the controller.
We have @PostMapping, corresponding to HTTP POST to:
Get transaction status
Get all transactions status

/TransactionStatusService.java
@Service provides following business functionalities:
Save transaction status by transaction ID
Get transaction status by transaction ID
Get all transaction status
