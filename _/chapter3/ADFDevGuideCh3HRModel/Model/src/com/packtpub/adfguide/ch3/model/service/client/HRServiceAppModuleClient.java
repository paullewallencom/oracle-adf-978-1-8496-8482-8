package com.packtpub.adfguide.ch3.model.service.client;

import com.packtpub.adfguide.ch3.model.service.common.HRServiceAppModule;

import oracle.jbo.client.remote.ApplicationModuleImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Thu Sep 29 11:03:21 IST 2011
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class HRServiceAppModuleClient extends ApplicationModuleImpl implements HRServiceAppModule {
    /**
     * This is the default constructor (do not remove).
     */
    public HRServiceAppModuleClient() {
    }

    public Integer createEmployee() {
        Object _ret = this.riInvokeExportedMethod(this,"createEmployee",null,null);
        return (Integer)_ret;
    }


    public void commit() {
        Object _ret = this.riInvokeExportedMethod(this,"commit",null,null);
        return;
    }

    public void findDepeartmentAndEmployees(Integer deptId) {
        Object _ret =
            this.riInvokeExportedMethod(this,"findDepeartmentAndEmployees",new String [] {"java.lang.Integer"},new Object[] {deptId});
        return;
    }

    public void test() {
        Object _ret = this.riInvokeExportedMethod(this,"test",null,null);
        return;
    }
}