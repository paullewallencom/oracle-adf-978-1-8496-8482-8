package com.packtpub.adfguide.ch6.model.nondb.generic;

import oracle.jbo.common.ampool.ApplicationPoolImpl;

public class CustomApplicationPoolImpl extends ApplicationPoolImpl {
    public CustomApplicationPoolImpl() {
        super();
    }

    public boolean isSupportsPassivation() {
        return false;
    }
}
