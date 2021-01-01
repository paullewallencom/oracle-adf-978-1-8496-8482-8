package com.packtpub.adfguide.ch11.view.general;

import java.sql.SQLIntegrityConstraintViolationException;

import oracle.adf.model.BindingContext;
import oracle.adf.model.RegionBinding;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCErrorHandlerImpl;
import oracle.adf.model.binding.DCErrorMessage;

import oracle.jbo.DMLConstraintException;

public class CustomDCErrorHandlerImpl extends DCErrorHandlerImpl {
    public CustomDCErrorHandlerImpl(){
        super(false);
    }
    public CustomDCErrorHandlerImpl(boolean b) {
        super(b);
    }

    /**
     * If an exception is a RowValException or a TxnValException
     * and they have nested exceptions, then do not display
     * it.
     */
    @Override
    protected boolean skipException(Exception ex) {

        if (ex instanceof DMLConstraintException) {
            return false;
        } else if (ex instanceof SQLIntegrityConstraintViolationException) {
            return true;
        }
        return super.skipException(ex);
    }

    /**
     * Returns the exception message. In case of JboWarning or JboException, returns
     * the message without product codes prefixed to the message.
     */
    public String getDisplayMessage(BindingContext ctx, Exception th) {
        return super.getDisplayMessage(ctx, th);
    }

    /**
     * This method simply throws the exception 'ex' as a JboException (by creating
     * a new JboException if required).
     */
    public void reportException(DCBindingContainer formBnd, Exception ex) {
        super.reportException(formBnd, ex);
    }
}
