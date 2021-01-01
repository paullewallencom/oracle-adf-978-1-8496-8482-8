package com.packtpub.adfguide.ch6.model.nondb.generic;

import java.util.Hashtable;
import java.util.Map;

import oracle.adf.share.ADFContext;

import oracle.jbo.client.Configuration;
import oracle.jbo.common.ampool.EnvInfoProvider;

public class CustomEnvInfoProvider implements EnvInfoProvider {
    public CustomEnvInfoProvider() {
        super();
    }

    /**
     * This method gets engaged when invoked by the ApplicationPool to acquire
     * dynamic application context before the ApplicationModule lifecycle event
     * sarts
     */
    public Object getInfo(String infoType, Object env) {

        return null;
    }

    public int getNumOfRetries() {
        return 0;
    }

    @Deprecated
    public void modifyInitialContext(Object initialContext) {
    }
}

