package com.packtpub.adfguide.ch7.model.service.common;

import java.util.ArrayList;

import oracle.jbo.ApplicationModule;
import oracle.jbo.Row;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Fri Dec 16 13:51:37 IST 2011
// ---------------------------------------------------------------------
public interface HRServiceAppModule extends ApplicationModule {
    Row updateDepartmentDeatils(Row departmentRow);

    java.util.List findEmployeeNamesByCity(String city);

    String findEmployeeNameById(Integer id);
}
