Note:
------
Please go through the instructions before you run the sample.

How to use this sample?
----------------------------------------------
Extract the zip file to your local file system.
Open ADFDevGuideCh12 workspace in JDeveloper 11.1.2.2.0 or higher

Workspace contains the following:

-HRDataModelEJB Project
   -  A basic EJB  model project holding Department/Employee JPA entities and HRServiceSessionEJBBean session bean
 
-ViewController Project
    - <ADFDevGuideCh12>ViewController\public_html\crud\crud.jsf:
        This page demonstrates the basic Create, Read, Update  functionality for an EJB Model.
     - <ADFDevGuideCh12>ViewController\public_html\masterchild\masterchild.jsf:
        This page demonstrates master child synchronization on UI built using EJB Model.
     - <ADFDevGuideCh12>ViewController\public_html\tree\tree.jsf:   
        This page demonstrates tree UI built using EJB Model
       
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