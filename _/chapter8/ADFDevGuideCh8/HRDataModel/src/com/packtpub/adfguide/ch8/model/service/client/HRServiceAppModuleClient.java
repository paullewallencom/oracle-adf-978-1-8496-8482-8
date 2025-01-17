package com.packtpub.adfguide.ch8.model.service.client;

import com.packtpub.adfguide.ch8.model.service.common.HRServiceAppModule;

import oracle.jbo.Key;
import oracle.jbo.RowIterator;
import oracle.jbo.client.remote.ApplicationModuleImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Sat Jan 14 09:05:30 IST 2012
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class HRServiceAppModuleClient extends ApplicationModuleImpl implements HRServiceAppModule {
    /**
     * This is the default constructor (do not remove).
     */
    public HRServiceAppModuleClient() {
    }


    public void createChildren(RowIterator ri, Key selectedNodeKey) {
        Object _ret =
            this.riInvokeExportedMethod(this,"createChildren",new String [] {"oracle.jbo.RowIterator","oracle.jbo.Key"},new Object[] {ri, selectedNodeKey});
        return;
    }

    public void deleteChildren(RowIterator ri, Key selectedNodeKey) {
        Object _ret =
            this.riInvokeExportedMethod(this,"deleteChildren",new String [] {"oracle.jbo.RowIterator","oracle.jbo.Key"},new Object[] {ri, selectedNodeKey});
        return;
    }

    public void initSessionWithUserLoc(Integer locationId) {
        Object _ret = this.riInvokeExportedMethod(this,"initSessionWithUserLoc",new String [] {"java.lang.Integer"},new Object[] {locationId});
        return;
    }

    public void reviseEmployeeSalary(Integer employeeId) {
        Object _ret = this.riInvokeExportedMethod(this,"reviseEmployeeSalary",new String [] {"java.lang.Integer"},new Object[] {employeeId});
        return;
    }
}
