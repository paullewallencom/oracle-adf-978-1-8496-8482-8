Note:
------
Please go through the instructions before you run the sample.

How to use this sample?
----------------------------------------------
Extract the zip file to your local file system.
Open ADFDevGuideAppendixSamples workspace in JDeveloper 11.1.2.2.0 or higher

Workspace contains the following:

-HRDataModel Project
   -  A basic model project cotaining employee/department entity and view objects and an application module
 
-ViewController Project
    - dynamicUIMain.jsf: This page demonstrates the dynamic UI built using dynamic model.
        See WEB_INF\dynamicUI-task-flow-definition.xml to know the flow between method activity that build dynamic view object and web page that displays the dynamic VO
     - dynamicNestingofAM.jsf: This page demonstrates nesting of AM at runtime.
        See HRServiceAppModuleImpl::nestAMIfRequiredAndInvokeMethod() to learn the APIs
		To test the feature, run the page, click 'NestTxnAMIfRequiredAndInvokeMethod' and then click Commit (which is defined on  HRServiceAppModuleDataControl)
		As the TxnAppModule is nested under HRServiceAppModule, commit call on HRServiceAppModuleDC commits TxnAppModule as well.
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