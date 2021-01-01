How to use this sample?
----------------------------------------------
Please go through the instructions before you run the sample.

Extract the zip file to your local file system.
Open ADFDevGuideCh6HRModel workspace in JDeveloper 11.1.2.2.0 or higher
Workspace contains the following:
-LookUpModel Porject
    - This project contains shared application module with LocationLookUpVO
-HR Model Project
   - DepartmentVO uses the shared LocationLookupVO from 'LookUpModel' project for building LOV on LocationID in DepartmentVO
     (Instructions for adding dependency to LookUpModel project is here http://jobinesh.blogspot.in/2012/01/consuming-adf-bc-model-project.html)
   - HRAppModuleImpl::passivateState() and HRAppModuleImpl::activateState()  conatins sample for custom passivation - activation
   - HRAppModuleImpl::findDepartmentById() and HRAppModuleImpl::findEmployeeIdByEmail contains sample for JDBC API usage
   - HRAppModuleImpl::createMasterChildViewObjects conatins code snippter for building dynamic VO + view link
- NonDBModel
    - This contains application module with no database connection
    - All the required classes for building AM with no DB are available in com.packtpub.adfguide.ch6.model.nondb.generic.*
    - See the bc4j.xcfg file (used for NonDBAppModuleService) to understand the custom classes used for building AM with no DB

How to run the sample?
-------------------------------------------------------
1. This uses  Uses HR schema. Change the database connection setting to reflect your local database settings.
   To change the connection,
   1.1 Goto Application Resources panel and expand Connections | Database.
   1.2 Right click the HR connection and choose properties. In the Edit Database Connection dialog change the settings to point to your local database
2. HRDataModel uses view object from LookupModel(shared AM). Follow the steps below for consuming LookupModel as lib
   2.1 See the instruction from this link to add dependency  to another model project
     http://jobinesh.blogspot.in/2012/01/consuming-adf-bc-model-project.html
   2.2 To define LOV  seeChapter 4 and 5
3. To test application module, Right click HRServiceAppModule and choose Run

How to run the Web UI?
-------------------------
1. Select the JSF file in the view controller , right click and Run