package com.packtpub.adfguide.ch6.model.service;


import com.packtpub.adfguide.ch6.model.service.common.HRAppModule;
import com.packtpub.adfguide.ch6.model.views.DepartmentVOImpl;

import java.math.BigDecimal;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Types;

import java.util.Hashtable;

import oracle.jbo.ApplicationModule;
import oracle.jbo.AttributeDef;
import oracle.jbo.JboException;
import oracle.jbo.ViewLink;
import oracle.jbo.ViewObject;
import oracle.jbo.domain.Number;
import oracle.jbo.server.ApplicationModuleImpl;
import oracle.jbo.server.SQLBuilder;
import oracle.jbo.server.ViewDefImpl;
import oracle.jbo.server.ViewObjectImpl;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Mon Nov 28 16:37:58 IST 2011
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class HRAppModuleImpl extends ApplicationModuleImpl implements HRAppModule {
    private Integer regionId = 10;

    /**
     * This is the default constructor (do not remove).
     */
    public HRAppModuleImpl() {
    }

    /**
     * Container's getter for Departments.
     * @return Departments
     */
    public ViewObjectImpl getDepartments() {

        return (ViewObjectImpl)findViewObject("Departments");
    }
    public static String USER_REGION = "USER_REGION";

    /**
     * Overridden framework method to passivate user data
     * in XML format by appending to the parent node
     */
    @Override
    public void passivateState(Document doc, Element parent) {
        //This code snippet stores the data in USERDATA node
        Element nodeUserData = doc.createElement("USERDATA");
        nodeUserData.setAttribute("KEY", USER_REGION);
        nodeUserData.setAttribute("VALUE", getRegionId().toString());
        parent.appendChild(nodeUserData);
        super.passivateState(doc, parent);
    }

    /**
     * Overridden framework method to activate  user data from
     * XML snapshot, stored during passivation
     */
    @Override
    public void activateState(Element parent) {
        //This code snippet reads the data stored in USERDATA node
        if (parent != null) {
            NodeList nl = parent.getElementsByTagName("USERDATA");
            for (int i = 0; i < nl.getLength(); i++) {

                Element e = (Element)nl.item(i);
                String key = e.getAttribute("KEY");
                String value = e.getAttribute("VALUE");
                setRegionId(new Integer(value));
                break;
            }
        }
        super.activateState(parent);
    }


    private Integer getRegionId() {
        return regionId;
    }

    private void setRegionId(Integer regionId) {
        System.out.println("RegionId---" + regionId);
        this.regionId = regionId;
    }


    public void test() {
        try {
            findDepartmentById(new Integer(40));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void revisedSalaryForAllDepartments() {

    }

    /**
     * Find department details using department id.This method uses CallableStatement
     * for executing strored procedure.
     * @param departmentId
     */
    public void findDepartmentById(Integer departmentId) throws SQLException {
        String stmt = "call departments_api.select_department(?,?,?,?)";
        // Create a CallableStatement for invoking stored procedure
        CallableStatement cs = getDBTransaction().createCallableStatement(stmt, 0);
        try {
            // Register the OUT parameters and types
            cs.registerOutParameter(2, Types.VARCHAR);
            cs.registerOutParameter(3, Types.NUMERIC);
            cs.registerOutParameter(4, Types.NUMERIC);
            //Register IN parameter
            cs.setObject(1, departmentId);
            // Execute the statement
            cs.executeQuery();
            // Retrieve the column values
            String deptName = cs.getString(2);
            BigDecimal managerId = cs.getBigDecimal(3);
            BigDecimal locId = cs.getBigDecimal(4);
            System.out.println("deptName -" + deptName);
            // Add your code here for further processing
        } finally {
            if (cs != null) {
                //Closing the statement
                cs.close();
            }
        }
    }

    public void activateStateForUndo(String id) {
        System.out.println("activateStateForUndo - " + id);
        super.activateStateForUndo(id, ACTIVATE_UNDO_FLAG);
    }


    public String passivateStateForUndo(String id) {
        System.out.println("passivateStateForUndo - " + id);
        String savePoint = super.passivateStateForUndo(id, null, PASSIVATE_UNDO_FLAG);
        return savePoint;
    }

    /**
     * Finds employee id using email id. This method uses PreparedStatement for executing
     * SQL
     * @param email
     * @return
     * @throws SQLException
     */
    public Long findEmployeeIdByEmail(String email) throws SQLException {
        Long empId = null;
        ResultSet rs = null;
        PreparedStatement stmnt = null;
        try {
            int noRowsPrefetch = 1;
            String query = "SELECT Emp.EMPLOYEE_ID FROM EMPLOYEES Emp WHERE  Emp.EMAIL = ?";
            //Create a PreparedStatement for  SQL call
            stmnt = getDBTransaction().createPreparedStatement(query, noRowsPrefetch);
            //Set the inpute parameter
            stmnt.setObject(1, email);
            rs = stmnt.executeQuery();
            if (rs.next()) {
                empId = rs.getLong(1);
            }
        } finally {
            //Close the result set
            if (rs != null) {
                rs.close();
            }
            //Close the statement
            if (stmnt != null) {
                stmnt.close();
            }
        }
        return empId;
    }

    /**
     * Commit the transaction
     */
    public void commitTransaction() {

        getDBTransaction().commit();
    }

    /**
     * Rollback the transaction
     */
    public void rollbackTransaction() {
        getDBTransaction().rollback();
    }


    public void createMasterChildViewObjects() {
        // Create a new "model.views.DynamicDeptVO" view definition
        ViewDefImpl deptViewDef = new ViewDefImpl("model.views.DynamicDeptVO");
        // Define the names and types of the view attributes
        deptViewDef.addViewAttribute("DepartmentId", "DEPARTMENT_ID", Integer.class);
        deptViewDef.addViewAttribute("DepartmentName", "DEPARTMENT_NAME", String.class);
        // Define the SQL query that this view object will perform
        deptViewDef.setQuery("SELECT Dept.DEPARTMENT_ID, Dept.DEPARTMENT_NAME FROM DEPARTMENTS Dept");
        deptViewDef.setFullSql(true);
        deptViewDef.setBindingStyle(SQLBuilder.BINDING_STYLE_ORACLE_NAME);
        deptViewDef.resolveDefObject();
        deptViewDef.registerDefObject();
        // Create an instance of the new view definition named "Departments"
        ViewObject deptView = createViewObject("DynamicDepartments", deptViewDef);
        // Create a new "model.views.DynamicEmpVO" view definition
        ViewDefImpl empViewDef = new ViewDefImpl("model.views.DynamicEmpVO");
        // Define the names and types of the view attributes
        empViewDef.addViewAttribute("EmployeeId", "EMPLOYEE_ID", Integer.class);
        empViewDef.addViewAttribute("FirstName", "FIRST_NAME", String.class);
        empViewDef.addViewAttribute("LastName", "LAST_NAME", String.class);
        empViewDef.addViewAttribute("DepartmentId", "DEPARTMENT_ID", Integer.class);
        // Define the SQL query that this view object will perform
        empViewDef.setQuery("SELECT Emp.EMPLOYEE_ID,  Emp.FIRST_NAME, Emp.LAST_NAME, Emp.DEPARTMENT_ID FROM EMPLOYEES Emp");
        empViewDef.setFullSql(true);
        empViewDef.setBindingStyle(SQLBuilder.BINDING_STYLE_ORACLE_NAME);
        empViewDef.resolveDefObject();
        empViewDef.registerDefObject();
        // Create an instance of the new view definition named "Departments"
        ViewObject empView = createViewObject("DynamicEmployees", empViewDef);
        // Create a view link between these two new view instances
        ViewLink empsInDepartment =
            createViewLinkBetweenViewObjects("DynamicDeptEmpViewLink", "EmployeesInDepartment", deptView,
                                             new AttributeDef[] { deptView.findAttributeDef("DepartmentId") }, empView,
                                             new AttributeDef[] { empView.findAttributeDef("DepartmentId") },
                                             "DEPARTMENT_ID = :Bind_DepartmentId");
    }

    private void findRootAM() {
        ApplicationModule rootAM = this.getRootApplicationModule();
    }

 
}
