package com.packtpub.adfguide.ch11.model.service;

import com.packtpub.adfguide.ch11.model.service.common.HRServiceAppModule;


import com.packtpub.adfguide.ch11.model.view.DepartmentVORowImpl;

import java.util.ArrayList;

import java.util.Locale;
import java.util.ResourceBundle;

import oracle.javatools.resourcebundle.BundleFactory;

import oracle.jbo.AttrSetValException;
import oracle.jbo.AttrValException;
import oracle.jbo.CSMessageBundle;
import oracle.jbo.JboException;
import oracle.jbo.JboWarning;
import oracle.jbo.Row;
import oracle.jbo.RowIterator;
import oracle.jbo.RowSet;
import oracle.jbo.RowValException;
import oracle.jbo.common.JboExceptionHelper;
import oracle.jbo.server.ApplicationModuleImpl;
import oracle.jbo.server.Entity;
import oracle.jbo.server.ViewLinkImpl;
import oracle.jbo.server.ViewObjectImpl;
import oracle.jbo.server.ViewRowImpl;
import oracle.jbo.TxnValException;
import oracle.jbo.ValidationException;
import oracle.jbo.common.PropertiesBundleDef;
import oracle.jbo.common.ResourceBundleDef;
import oracle.jbo.common.StringManager;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Wed Mar 14 18:06:59 IST 2012
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class HRServiceAppModuleImpl extends ApplicationModuleImpl implements HRServiceAppModule {
    /**
     * This is the default constructor (do not remove).
     */
    public HRServiceAppModuleImpl() {
    }

    /**
     * Container's getter for Departments.
     * @return Departments
     */
    public ViewObjectImpl getDepartments() {

        return (ViewObjectImpl)findViewObject("Departments");
    }

    /**
     * Container's getter for EmployeesForDepartment.
     * @return EmployeesForDepartment
     */
    public ViewObjectImpl getEmployeesForDepartment() {
        return (ViewObjectImpl)findViewObject("EmployeesForDepartment");
    }

    /**
     * Container's getter for EmpDeptFkLink1.
     * @return EmpDeptFkLink1
     */
    public ViewLinkImpl getEmpDeptFkLink1() {
        return (ViewLinkImpl)findViewLink("EmpDeptFkLink1");
    }

    /**
     * Creates RowValException
     * @param messageBundleKey
     * @param e
     * @param errorMessageParams
     * @return
     */
    private RowValException newRowValException(String messageBundleKey, Entity e, Object[] errorMessageParams) {
        RowValException rowVal =
            new RowValException(getResourceBundleDef(), messageBundleKey, e.getStructureDef().getFullName(),
                                e.getKey(), null, null);
        rowVal.setErrorParameters(errorMessageParams);
        return rowVal;
    }

    private RowValException newRowValException(String messageBundleKey, Entity e) {
        return new RowValException(getResourceBundleDef(), messageBundleKey, e.getStructureDef().getFullName(),
                                   e.getKey(), null, null);
    }

    /**
     * A method illustarting APIs for bundling mulitple RowValException
     * exceptions using ValidationException class
     * @param employeeRow
     */
    public void validateEmployeeAndDepartment(ViewRowImpl deptRow, ViewRowImpl employeeRow) {

        Entity employeeEO = employeeRow.getEntity(0);

        ArrayList<RowValException> exceptions = new ArrayList<RowValException>();
        //Validate Email in EmployeeEO
        if (!isValidEmail((String)employeeRow.getAttribute("Email")))
            exceptions.add(newRowValException("ERROR_MESSAGE_INVALID_EMAIL", employeeEO));
        //Validate DepartmentName in DepartmentEO
        Entity deptEO = deptRow.getEntity(0);
        if (!isValidDept((String)deptRow.getAttribute("DepartmentName")))
            exceptions.add(newRowValException("ERROR_MESSAGE_DEPTNAME_INVALID", deptEO, new Object[] { "testing" }));

        //Bundle all exceptions and throw it to the caller
        if (exceptions.size() > 0) {
            ValidationException val =
                new ValidationException(CSMessageBundle.class, CSMessageBundle.EXC_VAL_VR_VALIDATE_FAILED, null);
            val.setExceptions((Exception[])exceptions.toArray(new Exception[exceptions.size()]));
            throw val;
        }
    }

    private boolean isValidEmail(String email) {
        return false;
    }

    private boolean isValidPhone(String phone) {
        return false;
    }

    private boolean isValidFax(String phone) {
        return false;
    }

    private boolean isValidDept(String phone) {
        return false;
    }

    public void doSomethingAndThrowBundleOfWarnings() {

        JboException ex = new JboException("Warn");
        ex.setSeverity(JboExceptionHelper.SEVERITY_WARNING);
        throw ex;
    }

    /**
     * A method illustarting API  for bundling mulitple RowValException
     */
    public void throwRowValExceptionProgrammatically() {
        Entity e = null;
        ArrayList<RowValException> exceptions = new ArrayList<RowValException>();

        Row r = getDepartments().first();
        e = ((ViewRowImpl)r).getEntity(0);

        exceptions.add(newRowValException("ERROR_MESSAGE_001", e));
        exceptions.add(newRowValException("ERROR_MESSAGE_002", e));
        exceptions.add(newRowValException("ERROR_MESSAGE_003", e));
        r = getEmployees().first();
        e = ((ViewRowImpl)r).getEntity(0);
        exceptions.add(newRowValException("ERROR_MESSAGE_004", e, new Object[] { "testing" }));

        System.out.println(exceptions.size());
        ValidationException val =
            new ValidationException(CSMessageBundle.class, CSMessageBundle.EXC_VAL_VR_VALIDATE_FAILED, null);
        val.setExceptions((Exception[])exceptions.toArray(new Exception[exceptions.size()]));
        throw val;
    }

    /**
     * A method illustarting APIs for throwing single AttrValException
     */
    public void throwAttrValExceptionProgrammatically() {

       final Row r = getDepartments().first();
        Entity e = ((ViewRowImpl)r).getEntity(0);
        PropertiesBundleDef propBundleDef = new PropertiesBundleDef(this.getApplicationModuleDef());
        propBundleDef.setPropertiesFile("com.packtpub.adfguide.ch11.model.HRDataModelBundle");
        AttrValException ave =
            new AttrValException(AttrValException.TYP_DEF_ENTITY_OBJECT, propBundleDef, "ERROR_MESSAGE_DEPTNAME_INVALID",
                                 e.getStructureDef().getFullName(), "DepartmentName") {
            public Object getAttrValue() {
                return r.getAttribute("DepartmentName");
            }

        };
        ave.setErrorParameters(new Object[] { r.getAttribute("DepartmentName") });
        throw ave;
    }

    /**
     * A method illustarting APIs for throwing mulitple  AttrSetValException
     * bundled in a AttrValException
     */
    public void throwAttrSetValExceptionProgrammatically() {
       
        final Row r = getDepartments().first();
        Entity e = ((ViewRowImpl)r).getEntity(0);
        ArrayList<AttrSetValException> exceptions = new ArrayList<AttrSetValException>();
        AttrSetValException ave1 =
            new AttrSetValException(AttrValException.TYP_DEF_ENTITY_OBJECT, this.getResourceBundleDef(),
                                    "ERROR_MESSAGE_DEPTNAME_INVALID", e.getStructureDef().getFullName(),
                                    "DepartmentName", r.getAttribute("DepartmentName"), null);


        AttrSetValException ave2 =
            new AttrSetValException(AttrValException.TYP_DEF_ENTITY_OBJECT, this.getResourceBundleDef(),
                                    "ERROR_MESSAGE_DEPTNAME_INVALID", e.getStructureDef().getFullName(),
                                    "DepartmentName", r.getAttribute("DepartmentName"), null);

        exceptions.add(ave1);
        exceptions.add(ave2);
        AttrValException ave =
            new AttrValException(CSMessageBundle.class, CSMessageBundle.EXC_VAL_VR_VALIDATE_FAILED, e.getStructureDef().getFullName(),
                                 "DepartmentName", r.getAttribute("DepartmentName"), exceptions, false);
        throw ave;
    }

    /**
     * Custom validate method illustrating the APIs for throwing
     * mulitple AttrValException
     */
    public void validateDepartmentName(Row deptRow) {

        Entity e = ((ViewRowImpl)deptRow).getEntity(0);
        ArrayList<AttrSetValException> exceptions = new ArrayList<AttrSetValException>();

        if (!isAlreadyExisting(deptRow)) {
            //Create AttrSetValException
            AttrSetValException asve =
                new AttrSetValException(AttrValException.TYP_DEF_ENTITY_OBJECT, this.getResourceBundleDef(),
                                        "ERROR_MESSAGE_DEPTNAME_DUPLICATE", e.getStructureDef().getFullName(),
                                        "DepartmentName", deptRow.getAttribute("DepartmentName"), null);
            asve.setErrorParameters(new Object[] { deptRow.getAttribute("DepartmentName") });
            exceptions.add(asve);
        }
        if (!isValidName(deptRow)) {
            //Create AttrSetValException
            AttrSetValException asve =
                new AttrSetValException(AttrValException.TYP_DEF_ENTITY_OBJECT, this.getResourceBundleDef(),
                                        "ERROR_MESSAGE_DEPTNAME_INVALID", e.getStructureDef().getFullName(),
                                        "DepartmentName", deptRow.getAttribute("DepartmentName"), null);
            asve.setErrorParameters(new Object[] { deptRow.getAttribute("DepartmentName") });
            exceptions.add(asve);
        }
        if (exceptions.size() > 0) {
            //Bundle AttrSetValException in AttrValException and throw to the caller
            AttrValException ave =
                new AttrValException(CSMessageBundle.class, CSMessageBundle.EXC_VAL_VR_VALIDATE_FAILED,
                                     e.getStructureDef().getFullName(), "DepartmentName",
                                     deptRow.getAttribute("DepartmentName"), exceptions, false);
            throw ave;
        }
    }

    private boolean isAlreadyExisting(Object dept) {
        return false;
    }

    private boolean isValidName(Object obj) {
        return false;
    }

    public void throwTxnValExceptionProgrammatically() {
        Row r = getDepartments().first();
        Entity e = ((ViewRowImpl)r).getEntity(0);
        ArrayList<RowValException> exceptions = new ArrayList<RowValException>();
        exceptions.add(newRowValException("ERROR_MESSAGE_001", e));
        exceptions.add(newRowValException("ERROR_MESSAGE_002", e));
        exceptions.add(newRowValException("ERROR_MESSAGE_003", e));

        RowValException rowValEx =
            new RowValException(CSMessageBundle.class, CSMessageBundle.EXC_VAL_VR_VALIDATE_FAILED,
                                e.getStructureDef().getFullName(), e.getKey(), exceptions);

        ArrayList<RowValException> rootExceptions = new ArrayList<RowValException>();
        rootExceptions.add(rowValEx);
        TxnValException txnValEx = new TxnValException(rootExceptions);
        throw txnValEx;

    }

    public void throwValidationExceptionsProgrammatically() {
        Row deptRow = getDepartments().first();
        ValidationException ve =
            new ValidationException(this.getResourceBundleDef(), "ERROR_MESSAGE_DEPTNAME_INVALID", new Object[] { deptRow.getAttribute("DepartmentName") });
        throw ve;

    }

    public void methodThrowingError() {
        System.out.println("methodThrowingError");
        throw new NullPointerException("test");
    }

    /**
     * Container's getter for EmployeeVO1.
     * @return EmployeeVO1
     */
    public ViewObjectImpl getEmployees() {
        return (ViewObjectImpl)findViewObject("Employees");
    }

    //In view object or entity object implementation class


    /**
     * Get the string from resource bundle
     * @param key
     * @return
     */
    public String getLocalizedValue(String key) {

        ResourceBundleDef resourceDef = this.getResourceBundleDef();
        Locale locale = this.getDBTransaction().getSession().getLocale();
        String retVal = StringManager.getLocalizedStringFromResourceDef(resourceDef, key, null, locale, null, false);
        return retVal;
    }

    public void validateDeptRow(Row deptRow) {

        if (!hasEmployeesExists(deptRow)) {
            System.out.println("False for " + deptRow.getAttribute(1));
            //getResourceBundleDef returns property resource bundle
            //mapped to the business component
            ResourceBundleDef resourceBundle = getResourceBundleDef();
            throw new ValidationException(resourceBundle, "ERROR_MESSAGE_DEPTNAME_INVALID",
                                          new Object[] { deptRow.getAttribute("DepartmentName") });
        } else
            System.out.println("True for " + deptRow.getAttribute(1));

    }

    private boolean hasEmployeesExists(Row dpetRow) {
        //Access empployee row set through view link accessor
        RowSet empRowSet = (RowSet)dpetRow.getAttribute(DepartmentVORowImpl.EMPLOYEEVO);
        empRowSet.reset();
        Row r = empRowSet.first();
        //Check whether first rows is null
        if (r != null)
            return true;
        else
            return false;
    }

}
