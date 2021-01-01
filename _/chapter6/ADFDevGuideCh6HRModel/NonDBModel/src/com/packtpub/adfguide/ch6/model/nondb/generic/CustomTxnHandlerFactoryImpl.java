package com.packtpub.adfguide.ch6.model.nondb.generic;

import oracle.jbo.server.DefaultTxnHandlerFactoryImpl;
import oracle.jbo.server.TransactionHandler;

public class CustomTxnHandlerFactoryImpl extends DefaultTxnHandlerFactoryImpl {
    public CustomTxnHandlerFactoryImpl() {
        super();
    }

    @Override
    public TransactionHandler createTransactionHandler() {
        return new CustomTxnHandlerImpl();
    }
}
