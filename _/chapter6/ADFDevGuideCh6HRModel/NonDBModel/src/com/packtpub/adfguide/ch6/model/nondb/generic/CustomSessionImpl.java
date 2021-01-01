package com.packtpub.adfguide.ch6.model.nondb.generic;

import oracle.jbo.server.SessionImpl;
import oracle.jbo.server.TransactionHandlerFactory;

public class CustomSessionImpl extends SessionImpl {
    public CustomSessionImpl() {
        super();
    }
    private TransactionHandlerFactory mTxnHandlerFactory =
        new CustomTxnHandlerFactoryImpl();

    @Override
    public TransactionHandlerFactory getTransactionHandlerFactory() {
        return mTxnHandlerFactory;
    }
}
