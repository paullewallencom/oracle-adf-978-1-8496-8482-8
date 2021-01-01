Note:
------
Please go through the instructions before you run the sample.

How to use this sample?
----------------------------------------------
Extract the zip file to your local file system.
Open ADFDevGuideCh11 workspace in JDeveloper 11.1.2.2.0 or higher

Workspace contains the following:

-HRDataModel Project
   -  A basic ADF model project holding Department/Employee entity and view objects
 
-ViewController Project
    - <ADFDevGuideCh11>ViewController\public_html\domain\emailDomainValidate.jsf:
        This page demonstrates the use of custom domain object. Email field in the UI is backed up by  EmailDomin type in EmaployeeEO.
        Also email field in the UI uses oracle.genericDomain as the converter
    - <ADFDevGuideCh11>ViewController\public_html\errorHandler\empEdit.jsf:
        This page demonstrates how a custom error handler can be used for displying more use meaningful message.
        To test this feature, edit email field with an existing email id copied from another row and click Commit, you will see nice message which is set by the CustomDCErrorHandlerImpl
    - <ADFDevGuideCh11>ViewController\public_html\validate\attributeValidate.jsf:   
        This page demonstrates how to programmatically build AttrValException
        To test this feature, click button "Validate DepartmentName Using AM Method"        
    - <ADFDevGuideCh11>ViewController\public_html\validate\emailClientValidate.jsf:
        This page demonstrates how to use custom validation on a input field. Email field uses custom EmailValidator.
        To test this feature, change email by entering some invalid string and click Test.
    - <ADFDevGuideCh11>ViewController\public_html\validate\modelValidation.jsf:
        This page demonstrates how to use validation defined in page defnition to validate UI. Email field validation is defined for email attribute binding
        To test this feature, change email by entering some invalid string and click Test.
     - <ADFDevGuideCh11>ViewController\public_html\validate\programmticallyBundlingErrors.jsf:
        This page demonstrates how to programmatically build validation exception in model layer.
        To test this feature, click each button and see the error message. Take a look at the  application module method wired to each button to see the implementation
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