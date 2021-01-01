package com.packtpub.adfguide.ch3.model.service;

import oracle.jbo.ApplicationModule;
import oracle.jbo.ViewObject;
import oracle.jbo.client.Configuration;

public class TestClient {
    public TestClient() {
        super();
    }

    public static void main(String[] args) {
        String amDef = "com.packtpub.adfguide.ch3.model.service.HRServiceAppModule";
        String config = "HRServiceAppModuleLocal";
        //Look up the application module instance
        HRServiceAppModuleImpl applicationModule =
            (HRServiceAppModuleImpl)Configuration.createRootApplicationModule(amDef, config);
        //Test methods
        applicationModule.test();
    }
}
