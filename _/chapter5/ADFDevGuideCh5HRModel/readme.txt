Notes
-------
Please go through the instructions before you run the sample.
Extract the zip file to your local file system.
Open ADFDevGuideCh5HRModel workspace in JDeveloper 11.1.2.2.0 or higher

This Sample Contains the Following Items:
----------------------------------------
-HR Model Project
   -Exercising API Usages/Features
    1.  om.packtpub.adfguide.ch5.model.service.CRUDXMLTestClient:
    This class conatins commonly used APIs for reading and writing XML
    2.  com.packtpub.adfguide.ch5.model.entity.FileStorageEO and com.packtpub.adfguide.ch5.model.view.FileStorageVO :
    These  contain sample for ClobDomain
	3. com.packtpub.adfguide.ch5.model.entity.DepartmentProgrammaticEO 
	This implemesnts programmatic entity object using stored proc.
    4.  com.packtpub.adfguide.ch5.model.view.RegionalOfficeVO
	This class contain Sample for dependent LOV
	5. and com.packtpub.adfguide.ch5.model.view.DepartmentProgrammaticVO
	This implemesnts programmatic view object using stored proc.
	6. com.packtpub.adfguide.ch5.model.view.DepartmentVOImpl
	This conatins programmatic samples for using Array type, overriding prepareRowSetForQuery, getViewCriteria() etc.
    7. com.packtpub.adfguide.ch5.model.service.HRServiceAppModuleImpl
    This class has following method, each demonstrating specific features:
	   - createCompositeDeptEmpVO() :  Sample for building composite view object
	   - saveUploadedFile() : ClobDomain sample
	   - findDepartmentsForDepartmnetNames() : Search using Array
	   - findDepartmentsForDepartmnetNamesUsingVC(): VC using Array
	   - buildDynamicDeptViewCompAndAddtoAM() : Dynamic EO/VO creation
	
-View Controller Project
   - Exercising Features
   1. clobDomainExample.jsf - ClobDomain Sample 
   2. compositeVOExample.jsf - Composite View Object
   3. programmaticVO.jsf -  Programmatic view object
   4. vcWithArrayExample.jsf - ViewCriteria With Array type

To run the sample please follow the steps listed below:
-------------------------------------------------------
The sample ADFDevGuideCh5HRModel uses HR schema as database.
1. Change the database connection setting to reflect your local database settings.
   To change the connection,
   1.1 Goto Application Resources panel and expand Connections | Database.
   1.2 Right click the HR connection and choose properties. In the Edit Database Connection dialog change the settings to point to your local database
2  This sample uses additional tables(apart from default table comes with HR schema). So Run all the scripts from <ADFDevGuideCh5HRModel>/script folder in your HR schema
3. To test application module, Right click HRServiceAppModule and choose Run

To run the web UI
-------------------------
1. Select the JSF file in the view controller , right click and Run




 
 

