package com.packtpub.adfguide.ch6.model.service;

import oracle.jbo.Row;
import oracle.jbo.ViewObject;
import oracle.jbo.client.Configuration;

public class TestClient {
    public TestClient() {
        super();
    }
    public static void main(String[] args) {
        String        amDef = "com.packtpub.adfguide.ch6.model.service.HRAppModule";
        String        config = "HRAppModuleLocal";
        HRAppModuleImpl am = (HRAppModuleImpl) Configuration.createRootApplicationModule(amDef,config);
        am.createMasterChildViewObjects();
        ViewObject deptVO = am.findViewObject("DynamicDepartments");
        ViewObject empVO = am.findViewObject("DynamicEmployees");
        while (deptVO.hasNext()) {
            Row deptRow = deptVO.next();
            System.out.println(deptRow.getAttribute("DepartmentName"));
            while (empVO.hasNext()) {
                Row empRow = empVO.next();
                System.out.println("--| "+empRow.getAttribute("FirstName"));
            }
        }
        Configuration.releaseRootApplicationModule(am,true);
    }
}
