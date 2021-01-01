package com.packtpub.adfguide.model;

import com.packtpub.adfguide.model.common.TxnAppModule;

import oracle.jbo.Row;
import oracle.jbo.server.ApplicationModuleImpl;
import oracle.jbo.server.ViewObjectImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Tue Sep 04 15:34:01 IST 2012
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class TxnAppModuleImpl extends ApplicationModuleImpl implements TxnAppModule {
    /**
     * This is the default constructor (do not remove).
     */
    public TxnAppModuleImpl() {
    }

    /**
     * Container's getter for Employees.
     * @return Employees
     */
    public ViewObjectImpl getEmployees() {
        return (ViewObjectImpl)findViewObject("Employees");
    }

    /**
     * Container's getter for EmployeeUpdatableVO1.
     * @return EmployeeUpdatableVO1
     */
    public ViewObjectImpl getEmployeeUpdatableVO1() {
        return (ViewObjectImpl)findViewObject("EmployeeUpdatableVO1");
    }

    public void updateEmployee() {
        getEmployeeUpdatableVO1().executeQuery();
        Row row = getEmployeeUpdatableVO1().first();
        row.setAttribute("FirstName", row.getAttribute("FirstName") + "Modified");
    }
}