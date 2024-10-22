package com.packtpub.adfguide.ch5.model.service.client;

import com.packtpub.adfguide.ch5.model.service.common.HRServiceAppModule;

import oracle.jbo.client.remote.ApplicationModuleImpl;
import oracle.jbo.domain.ClobDomain;
import oracle.jbo.domain.generic.GenericClob;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Fri Nov 04 17:16:25 IST 2011
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class HRServiceAppModuleClient extends ApplicationModuleImpl implements HRServiceAppModule {
    /**
     * This is the default constructor (do not remove).
     */
    public HRServiceAppModuleClient() {
    }


    public void buildDynamicDeptViewCompAndAddtoAM() {
        Object _ret = this.riInvokeExportedMethod(this,"buildDynamicDeptViewCompAndAddtoAM",null,null);
        return;
    }

    public void createCompositeDeptEmpVO() {
        Object _ret = this.riInvokeExportedMethod(this,"createCompositeDeptEmpVO",null,null);
        return;
    }

    public void executeDepermentVO() {
        Object _ret = this.riInvokeExportedMethod(this,"executeDepermentVO",null,null);
        return;
    }

    public void findDepartmentsForDepartmnetNames(String[] deptNamesArray) {
        Object _ret =
            this.riInvokeExportedMethod(this,"findDepartmentsForDepartmnetNames",new String [] {"[Ljava.lang.String;"},new Object[] {deptNamesArray});
        return;
    }

    public void findDepartmentsForDepartmnetNamesUsingVC(String[] deptNamesArray) {
        Object _ret =
            this.riInvokeExportedMethod(this,"findDepartmentsForDepartmnetNamesUsingVC",new String [] {"[Ljava.lang.String;"},new Object[] {deptNamesArray});
        return;
    }

    public void saveUploadedFile(ClobDomain content, String filename) {
        Object _ret =
            this.riInvokeExportedMethod(this,"saveUploadedFile",new String [] {"oracle.jbo.domain.ClobDomain","java.lang.String"},new Object[] {content, filename});
        return;
    }
}
