package com.packtpub.adfguide.ch6.model.nondb;

import oracle.jbo.*;
import oracle.jbo.client.Configuration;
import oracle.jbo.domain.*;
import oracle.jbo.domain.Number;

public class Client {
    public Client() {
        super();
    }


    public static void main(String[] args) {
        String amDef = "com.packtpub.adfguide.ch6.model.nondb.NonDBAppModuleService";
        String config = "NonDBAppModuleService";
        ApplicationModule am = Configuration.createRootApplicationModule(amDef, config);
        ViewObject vo = am.findViewObject("StaticVO1");
        // Work with your appmodule and view object here
        Configuration.releaseRootApplicationModule(am, true);
    }
}
