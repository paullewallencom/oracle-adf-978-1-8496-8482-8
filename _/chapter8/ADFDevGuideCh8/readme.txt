Note:
------
Please go through the instructions before you run the sample.

How to use this sample?
----------------------------------------------
Extract the zip file to your local file system.
Open ADFDevGuideCh8 workspace in JDeveloper 11.1.2.2.0 or higher

Workspace contains the following:

-HRDataModel Project
   -  A basic ADF model project holding Department/Employee entity and view objects
   
-ViewController Project
    - panelGridLayoutSample.jsf    : This demonstrates the usage of af:panelGridLayout in designing a page
    - department.jsf : This demonstrates  tabular display for department rows and creation of new row
    - employee.jsf : This demonstrates employee form display with navigation buttons
    - list.jsf : This demonstrates select one choice
    - mulitSelect.jsf : This demonstrates multi select list box (Demonstrates the APIs to be used to access the selected items)
    - masterDetail.jsf : This demonstrates mast-detail page   
    - hvViewer.jsf : This demonstrates hierarchy viewer component
    - treeSearch.jsf : This demonstrates the tree search(Demonstrates the APIs to be used)
    - treeCRUD.jsf : This shows CRUD(create , read, update, delete) operation on a tree component(Demonstrates the APIs to be used)
    - targetDataSource.jsf : This demonstrates target data source feature (Two Iterator synchronization)
    - serachInterceptor.jsf : This demonstrates  the customization of search execution (Demonstrates the APIs to be used)
	- searchSourceView.jsf --(navigation to)-> searchView.jsf : 
	                        1. Run searchSourceView.jsf, click Department button, system will navigate to searchView.jsf
	                        2. The searchView.jsf will have now location id displayed with value passed from previous view(searchSourceView.jsf)
                 	        This demonstrates initialization of serach paremeter with client side value
    - searchView.jsf : Illustrates custom reset for query component (Demonstrates the APIs to be used)
  
   
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