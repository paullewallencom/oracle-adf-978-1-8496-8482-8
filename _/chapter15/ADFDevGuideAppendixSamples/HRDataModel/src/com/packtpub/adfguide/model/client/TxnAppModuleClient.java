package com.packtpub.adfguide.model.client;

import com.packtpub.adfguide.model.common.TxnAppModule;

import oracle.jbo.client.remote.ApplicationModuleImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Wed Sep 05 14:47:52 IST 2012
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class TxnAppModuleClient extends ApplicationModuleImpl implements TxnAppModule {
    /**
     * This is the default constructor (do not remove).
     */
    public TxnAppModuleClient() {
    }

    public void updateEmployee() {
        Object _ret = this.riInvokeExportedMethod(this,"updateEmployee",null,null);
        return;
    }
}
