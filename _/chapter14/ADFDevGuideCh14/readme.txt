How to use this sample?
----------------------------------------------
Extract the zip file to your local file system.
Open ADFDevGuideCh14 workspace in JDeveloper 11.1.2.2.0 or higher

Workspace contains the following:

-HRDataModelEJB Project
    - A basic ADF model project holding Department/Employee entity and view objects
    - com.packtpub.adfguide.ch14.model.service.SecurityEnabledViewCriteriaAdapter: this class provides custom CriteriaAdapterImpl 
	     for adding security predicate for VO's with  view criteria usage 'SecurityEnabledEmptyVC_' 
    - updateDeparmentDetails() in HRServiceAppModuleImpl illusrtaes the use of MethodPermission
-ViewController Project
    - dept.jsf - af:commandButton with id="cb6" uses EL for MethodPermission
	       
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
This is security enabled application, use superuser/superuser1 as username/password