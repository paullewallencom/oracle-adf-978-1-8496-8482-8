Note:
------
Please go through the instructions before you run the sample.

How to use this sample?
----------------------------------------------
Extract the zip file to your local file system.
Open ADFDevGuideCh10 workspace in JDeveloper 11.1.2.2.0 or higher

Workspace contains the following:

-HRDataModel Project
   -  A basic ADF model project holding Department/Employee entity and view objects and an HRServiceAppModule
 
-ViewController Project
    - <ADFDevGuideCh10>ViewController\public_html\contextualevent\ceMain.jsf:
        This page demonstrates the use of contextual even to pass modified depratmnet name from one region to another
    - <ADFDevGuideCh10>ViewController\public_html\dynamic\cdynamicTaskFlow.jsf:
        This page demonstrates the dynamic task flow
    - <ADFDevGuideCh10>ViewController\public_html\mulittaskflow\mulitTaskFlow.jsf:    
        This page demonstrates the multi task flow binding   
    - <ADFDevGuideCh10>ViewController\public_html\taskflowreturn\deptUsingTaskflowLOV.jsf:
        This page demonstrates how to use task flow with return values for building LOV
    - <ADFDevGuideCh10>ViewController\public_html\train\trainNavigation.jsf:
        This page demonstrates how to invoke activity between train stops
  
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