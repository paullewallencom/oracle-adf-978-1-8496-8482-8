package com.packtpub.adfguide.ch8.model.service.common;

import oracle.jbo.ApplicationModule;
import oracle.jbo.Key;
import oracle.jbo.RowIterator;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Sat Jan 14 09:05:30 IST 2012
// ---------------------------------------------------------------------
public interface HRServiceAppModule extends ApplicationModule {


    void reviseEmployeeSalary(Integer employeeId);

    void createChildren(RowIterator ri, Key selectedNodeKey);

    void deleteChildren(RowIterator ri, Key selectedNodeKey);

    void initSessionWithUserLoc(Integer locationId);
}