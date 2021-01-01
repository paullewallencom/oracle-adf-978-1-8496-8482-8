Note:
------
Please go through the instructions before you run the sample.

How to use this sample?
----------------------------------------------
Extract the zip file to your local file system.
Open ADFDevGuideCh7 workspace in JDeveloper 11.1.2.2.0 or higher
Workspace contains the following:

-HRDataModel Project
   -  A basic ADF model project holding Department/Employee entity and view objects, and an application module 
- ServletViewController Project
    - This contains hand coded adfm.xml, DataBindings.cpx and page defnition XML file in order to use ADF binding API from servlet.
	- DemoServlet, A Servlet class
	- web.xml with minimum configuration required for using ADF binding APIs from servlet.  

How to run the sample?
-------------------------------------------------------
1. This uses  Uses HR schema. Change the database connection setting to reflect your local database settings.
   To change the connection,
   1.1 Goto Application Resources panel and expand Connections | Database.
   1.2 Right click the HR connection and choose properties. In the Edit Database Connection dialog change the settings to point to your local database
2. To test application module, Right click HRServiceAppModule and choose Run

How to run the Web UI?
-------------------------
1. Select DemoServlet in ServletViewController project, right click and Run