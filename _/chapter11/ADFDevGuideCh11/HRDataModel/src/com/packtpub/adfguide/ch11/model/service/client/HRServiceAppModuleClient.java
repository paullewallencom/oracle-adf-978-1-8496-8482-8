package com.packtpub.adfguide.ch11.model.service.client;

import com.packtpub.adfguide.ch11.model.service.common.HRServiceAppModule;

import oracle.jbo.Row;
import oracle.jbo.client.remote.ApplicationModuleImpl;
import oracle.jbo.common.PropertiesBundleDef;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Wed Mar 14 18:20:15 IST 2012
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class HRServiceAppModuleClient extends ApplicationModuleImpl implements HRServiceAppModule {
    /**
     * This is the default constructor (do not remove).
     */
    public HRServiceAppModuleClient() {
    }


    public void methodThrowingError() {
        Object _ret = this.riInvokeExportedMethod(this,"methodThrowingError",null,null);
        return;
    }

    public void throwAttrSetValExceptionProgrammatically() {
        Object _ret = this.riInvokeExportedMethod(this,"throwAttrSetValExceptionProgrammatically",null,null);
        return;
    }

    public void throwAttrValExceptionProgrammatically() {
        Object _ret = this.riInvokeExportedMethod(this,"throwAttrValExceptionProgrammatically",null,null);
        return;
    }

    public void throwRowValExceptionProgrammatically() {
        Object _ret = this.riInvokeExportedMethod(this,"throwRowValExceptionProgrammatically",null,null);
        return;
    }

    public void throwTxnValExceptionProgrammatically() {
        Object _ret = this.riInvokeExportedMethod(this,"throwTxnValExceptionProgrammatically",null,null);
        return;
    }

    public void throwValidationExceptionsProgrammatically() {
        Object _ret = this.riInvokeExportedMethod(this,"throwValidationExceptionsProgrammatically",null,null);
        return;
    }

    public void validateDepartmentName(Row deptRow) {
        Object _ret = this.riInvokeExportedMethod(this,"validateDepartmentName",new String [] {"oracle.jbo.Row"},new Object[] {deptRow});
        return;
    }
}