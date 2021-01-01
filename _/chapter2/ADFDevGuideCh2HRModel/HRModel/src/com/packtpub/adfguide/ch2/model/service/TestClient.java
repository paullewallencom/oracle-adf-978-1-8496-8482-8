package com.packtpub.adfguide.ch2.model.service;

import oracle.jbo.*;
import oracle.jbo.client.Configuration;
import oracle.jbo.domain.*;
import oracle.jbo.domain.Number;

public class TestClient {
    public TestClient() {
        super();
    }

    public static void main(String[] args) {
        String amDef = "com.packtpub.adfguide.ch2.model.service.HRServiceAppModule";
        String config = "HRServiceAppModuleLocal";
        //Look up the application module instance
        ApplicationModule applicationModule = Configuration.createRootApplicationModule(amDef, config);
        //Get the view object from AM
        ViewObject vo = applicationModule.findViewObject("Departments");
        //execute query
        vo.executeQuery();
        //iterate over rows
        while (vo.hasNext()) {
            Row row = vo.next();
            printRow(vo, row);
        }
        //Move to first record
        Row row = vo.first();
        //modify attributes value
        row.setAttribute("DepartmentName", "HR Services");
        //Commit Transaction
        applicationModule.getTransaction().commit();
        //Release AM
        Configuration.releaseRootApplicationModule(applicationModule, true);
    }

    private static void printRow(ViewObject vo, Row r) {
        String viewObjName = vo.getName();
        System.out.println("Printing attribute for a row in VO '" + viewObjName + "'");
        StructureDef def = r.getStructureDef();
        StringBuilder sb = new StringBuilder();
        int numAttrs = def.getAttributeCount();
        AttributeDef[] attrDefs = def.getAttributeDefs();
        for (int z = 0; z < numAttrs; z++) {
            Object value = r.getAttribute(z);
            sb.append(z > 0 ? " " : "").append(attrDefs[z].getName()).append("=").append(value == null ? "<null>" :
                                                                                         value).append(z <
                                                                                                       numAttrs - 1 ?
                                                                                                       "\n" : "");
        }
        System.out.println(sb.toString());
    }
}
