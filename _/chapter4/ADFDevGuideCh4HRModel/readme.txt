Notes
-----
Please go through the instructions before you run the sample.
Extract the zip file to your local file system.
Open ADFDevGuideCh4HRModel workspace in JDeveloper 11.1.2.2.0 or higher

This Sample Contains the Following Items:
----------------------------------------
-HR Model Project
  -Exercising API Usages
    1.  com.packtpub.adfguide.ch4.model.client.CRUDOperationClient:
    This class exrecises commonly used APIs for perfroming CRUD operations
    2.  com.packtpub.adfguide.ch4.model.client.InmemoryFilteringClient :
    This class exrecises commonly used APIs for perfroming in-memory filtering
   -Exercising VO Features   
    3. MarketingEmployeeGenericEO <--- MarketingEmployeeGenericEOEx  <--- SalesEmployeeExEO forms the entity inheritance hierarchy
    4. MarketingEmployeeGenericVO <--- MarketingEmployeeListVO forms view object inheritance hierarchy(with polymorphic EO usage)
    5. JobHistoryEO : This is an effective dated entity object
    6. JobHistoryVO : This is an effective dated view object
   
-UML Project
    All the Class diagrams and  UML sequences for this chapter is available here
   


To run the sample please follow the steps listed below:
-------------------------------------------------------
The sample ADFDevGuideCh4HRModel uses HR schema as database.
1. Change the database connection setting to reflect your local database settings.
   To change the connection,
   1.1 Goto Application Resources panel and expand Connections | Database.
   1.2 Right click the HR connection and choose properties. In the Edit Database Connection dialog change the settings to point to your local database
2. To test application module, Right click HRServiceAppModule and choose Run

Test Using Java Client
----------------------

This worskpace has 2 Java Clients packaged. You can alter the source to test all the codes
To run, Java Clients :
1. Right click com.packtpub.adfguide.ch4.model.client.CRUDOperationClient.java and choose Run
2. Right click com.packtpub.adfguide.ch4.model.client.InmemoryFilteringClient.java and Run
