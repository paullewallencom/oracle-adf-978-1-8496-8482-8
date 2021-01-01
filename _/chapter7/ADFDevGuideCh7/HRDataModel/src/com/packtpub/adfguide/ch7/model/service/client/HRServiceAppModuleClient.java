package com.packtpub.adfguide.ch7.model.service.client;

import com.packtpub.adfguide.ch7.model.service.common.HRServiceAppModule;

import java.util.ArrayList;

import oracle.jbo.Row;
import oracle.jbo.client.remote.ApplicationModuleImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Fri Dec 16 13:51:37 IST 2011
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class HRServiceAppModuleClient extends ApplicationModuleImpl implements HRServiceAppModule {
    /**
     * This is the default constructor (do not remove).
     */
    public HRServiceAppModuleClient() {
    }


    public String findEmployeeNameById(Integer id) {
        Object _ret = this.riInvokeExportedMethod(this,"findEmployeeNameById",new String [] {"java.lang.Integer"},new Object[] {id});
        return (String)_ret;
    }

    public java.util.List findEmployeeNamesByCity(String city) {
        Object _ret = this.riInvokeExportedMethod(this,"findEmployeeNamesByCity",new String [] {"java.lang.String"},new Object[] {city});
        return (java.util.List)_ret;
    }

    public Row updateDepartmentDeatils(Row departmentRow) {
        Object _ret = this.riInvokeExportedMethod(this,"updateDepartmentDeatils",new String [] {"oracle.jbo.Row"},new Object[] {departmentRow});
        return (Row)_ret;
    }
}