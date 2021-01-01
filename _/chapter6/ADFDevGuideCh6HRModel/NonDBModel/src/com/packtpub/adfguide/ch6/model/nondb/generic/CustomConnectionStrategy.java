package com.packtpub.adfguide.ch6.model.nondb.generic;

import java.util.Hashtable;

import oracle.jbo.ApplicationModule;
import oracle.jbo.client.Configuration;
import oracle.jbo.common.PropertyConstants;
import oracle.jbo.common.PropertyMetadata;
import oracle.jbo.common.ampool.DefaultConnectionStrategy;
import oracle.jbo.common.ampool.EnvInfoProvider;
import oracle.jbo.common.ampool.SessionCookie;

public class CustomConnectionStrategy extends DefaultConnectionStrategy {
    public CustomConnectionStrategy() {
        super();
    }

    public ApplicationModule createApplicationModule(Hashtable environment) {
        environment.put(Configuration.DB_REQUIRES_CONNECTION, Boolean.FALSE);
        environment.put(PropertyMetadata.ENV_DO_FAILOVER.pName, PropertyConstants.FALSE);
        return super.createApplicationModule(environment);
    }

    public ApplicationModule createApplicationModule(SessionCookie cookie, EnvInfoProvider envInfo) {
        return super.createApplicationModule(cookie, envInfo);
    }
}
