# Progressive Software Development Project: Legal Records Manager

## Project Information
Student Name: Oscar Anaya
Course: CSC 223 - Data Structures and Algorithms
Professor: Emilia Butu
Java Version: OpenJDK 21.0.12.1
Current Status: Created initial project structure and README file. Minimum viable features not yet reached.

---

## Project Proposal

###Project Domain:
Business workflow


###Project Statement: 
The proposed application will help legal assistants track clients in active Records phase and manage requests for pending medical records, using data obtained from a Filevine platform report representing client objects with respective pending medical provider objects. 


###Intended Users: 
Legal assistants in the medical records department


###User needs: 
- Track clients in medical records phase and the pending medical providers
- Generate request letters in pdf format for billing, records or records and billing. Fax cover is optionally added to requests.
- Generate a HIPAA for each request


###Project value
With this application I intend to improve worker efficiency by facilitating the steps to generate a request. Currently, legal assistants need to generate a word document, edit it, convert it to pdf and combine it with HIPAA and/or fax cover. This application will significantly speed up the process by allowing the legal assistant to simply select the client, medical provider and letter type to generate the full packet.


###Primary Data:
####Client objects. 
Attributes: Record received date, Client ID, Date of Accident, Client Full Name, Client Date of Birth, Client's Details: Social Security Number, Client Address Block, Project Phase, Phase Date, Project Hashtags.

####Medical Provider Objects. 
Attributes: Records Received date, Provider Name, Ordered Date, Provider Address Block, Provider's Fax Number, Provider Email, Provider Notes

####Request Type.
Billing, Records, or Records and Billing

####Include Fax Cover: 
Yes, No

---

## Scope and Feature Plan

###Minimum Viable Features: 

- Display list of all clients in Records phase with pending medical providers, obtained from the Filevine report
- Sort the list of clients by pending number of medical providers
- Display pending medical provider objects for each client
- Generate Request Letters for Billing, Records or Records and Billing for each provider
- Generate and combine a Fax letter upon request
- Generate and combine a HIPAA form

###Optional enhancements:
- Print a .csv file with a list of the clients in records phase and pending number of medical providers. 
- Select the folder where the generated pdf packet will be saved, regardless of windows or linux
- Search for a specific client, and/or search a provider to show all the client that contain the medical provider

###Project Boundaries:

- No production deployment
- No authentication system or user selection. The app will use the information for a single user
- No use of real data. All data will be simulated/fake
- No running from web server. The app will be local. 
- No dependency on a paid or unstable service. 
- For simplicity, the app will not be able to select the filevine report file. A sample report will be saved in the environment folder.
- A HIPAA compliant app needs to track each user, client accessed and request generated. The scope of this app will not include a log. 

###Initial Success Criteria:

- Display a list of all clients in records phase with pending medical providers
- I will be able to generate a request letter with HIPAA for a specific client and assigned medical provider

---

## Instructions for Compiling and Running Tests

This project contains clean source files inside ('src/') and is structured to be imported directly into a standard Java Integrated Development Environment (IDE) configured for Java 21.

### Recommended Execution: Via IntelliJ IDEA
1. Open the Project: Launch IntelliJ IDEA, click Open, and select this unzipped project root folder.
2. Verify Java Version: Ensure Project SDK/JDK is set to Java 21.0.12.1.
3. Right-click on the main.java.edu.nova.csc223.module1 package and select Build
4. Right-click on the test.java.edu.nova.csc223.module1 package and select Build
5. If Intellij IDEA IDE does not automatically add the JUnit classpath: 
    - Click the little red  bulb on a Test and select "Add JUnit to classpath"
    - The IDE will then resolve the standard JUnit 5 testing dependencies
6. Select the JUnit test class you wish to run and click on Run

### Execution via Terminal / Command Line
This approach assumes a standard java development environment with SDK Java 21 and Junit 5 libraries

1. Navigate to the directory containing the src folder with the source code. Do not enter the src folder.
2. Compile the main application code: javac -d out src/main/java/edu/nova/csc223/module1/*.java
3. Compile teh test JUnit test suite: javac -d out -cp out src/test/java/edu/nova/csc223/module1/*.java
4. Execute the JUnit tests: java --class-path out --scan-class-path

---

## Responsible AI Use Disclosure
AI-assisted work: I used Gemini for submission review. I independently wrote, verified, tested, and can explain all submitted work.
