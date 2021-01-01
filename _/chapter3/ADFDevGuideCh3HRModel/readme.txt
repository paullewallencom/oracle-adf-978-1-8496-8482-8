Notes
-----
Please go through the instructions before you run the sample.

Extract the zip file to your local file system.
Open ADFDevGuideCh3HRModel workspace in JDeveloper 11.1.2.2.0 or higher

This Sample Contains the Following Items:
----------------------------------------
1. The package com.packtpub.adfguide.ch3.model.entity.datasource contains entities built using View, Materialized View and Synonym.

EmployeeDBViewEO - Entity based on database view
EmployeeMVEO - Entity based on materialized view
EmployeeSynEO - Entity based on Synonym

2. The package com.packtpub.adfguide.ch3.model.entity.inheritance contains entities built using inheritance heirarchy

MarketingBaseEmployeeEO - Parent EO
ExecutiveSubEmployeeEO - Child EO
SalesSubEmployeeEO - Child EO

To run the sample please follow the steps listed below:
-------------------------------------------------------
The sample ADFDevGuideCh3HRModel uses HR schema as database. 
1. Change the database connection setting to reflect your local database settings.
   To change the connection,
   1.1 Goto Application Resources panel and expand Connections | Database.
   1.2 Right click the HR connection and choose properties. In the Edit Database Connection dialog change the settings to point to your local database
2. Run the script.sql that you may find in the same folder. This creates View, Materialized View and Synonym used for building entities   
3. To test application module, Right click HRServiceAppModule and choose Run

Test Using Java Client
----------------------
You can edit the TestClient.java to test application module methods.
To run, right click  TestClient.java and choose Run

  
