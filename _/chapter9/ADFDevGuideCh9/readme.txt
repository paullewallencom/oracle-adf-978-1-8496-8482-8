Note:
------
Please go through the instructions before you run the sample.

How to use this sample?
----------------------------------------------
Extract the zip file to your local file system.
Open ADFDevGuideCh9 workspace in JDeveloper 11.1.2.2.0 or higher

Workspace contains the following:

-HRServiceModel Project
   -  A basic ADF model project holding Department/Employee entity and view objects
  
-ViewController Project
    - WEB-INF\savepoint-sample-task-flow-definition.xml : This task flow demonstrates the usage of save points in task flow
    - WEB-INF\methodactiviyt-sample-task-flow-definition.xml : This task flow  demonstrates the usage of method activity to intialize view
    - main.jsf : You can navigate to book markable view namely 'bookMarkableDep.jsf' from main.jsf. The 'bookMarkableDep.jsf' illustrates book marking feature.
    - errHandlerCheck.jsf : Click on Error Handler Check button, this will trigger custom error handler class comp.packtpub.adfguide.ch9.view.CustomExceptionHandler

How to run the sample?
-------------------------------------------------------
1. This uses  Uses HR schema. Change the database connection setting to reflect your local database settings.
   To change the connection,
   1.1 Goto Application Resources panel and expand Connections | Database.
   1.2 Right click the HR connection and choose properties. In the Edit Database Connection dialog change the settings to point to your local database
2. To test application module, Right click HRServiceAppModule and choose Run

How to run the Web UI?
-------------------------
1. Select the desired JSF page in ViewController project, right click and Run
2. Select the desired task flow in WEB-INF folder, in ViewController project and Run