package com.packtpub.adfguide.ch6.model.service.client;

import com.packtpub.adfguide.ch6.model.service.common.HRAppModule;

import oracle.jbo.client.remote.ApplicationModuleImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Thu Dec 01 14:28:38 IST 2011
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class HRAppModuleClient extends ApplicationModuleImpl implements HRAppModule {
    /**
     * This is the default constructor (do not remove).
     */
    public HRAppModuleClient() {
    }

    public void revisedSalaryForAllDepartments() {
        Object _ret = this.riInvokeExportedMethod(this,"revisedSalaryForAllDepartments",null,null);
        return;
    }

    public void test() {
        Object _ret = this.riInvokeExportedMethod(this,"test",null,null);
        return;
    }
}
