package com.packtpub.adfguide.ch12.view;

import oracle.adf.model.BindingContext;
import oracle.adf.model.RegionBinding;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCErrorHandlerImpl;
import oracle.adf.model.binding.DCErrorMessage;

import oracle.jbo.JboException;
import oracle.jbo.JboWarning;

/**
 * Custom exception hanlder for EJB. This error handler class hides 
 * unwanted details present in the xception when reported to the user
 */
public class CustomExceptionHandler extends DCErrorHandlerImpl {
    public CustomExceptionHandler(boolean b) {
        super(b);
    }

    public CustomExceptionHandler() {
        super(true);
    }

    /**
     * This method preprocess exception before dsiplaying it.
     * @param bc
     * @param ex
     */
    @Override
    public void reportException(DCBindingContainer bc, Exception ex) {
        ex.printStackTrace();
        //Find the root cause of the exception 
        ex = (Exception)getRootCauseException(ex);
        //Following method Call invokes JboException::setAppendCodes(false) 
        //recursively on all child exceptions
        disableAppendCodes(ex);
        super.reportException(bc, ex);
    }


    /**
     * Specify appendCode flag for  JboException to false if this exception
     * should not prefix the error message
     * with Product and Message Ids.By default this flag is set to true.
     * @param ex
     */
    private void disableAppendCodes(Exception ex) {
        if (ex instanceof JboException) {
            JboException jboEx = (JboException)ex;
            //Set appendCode to false if this exception should not prefix 
            //the error message with Product and Message Ids.
            jboEx.setAppendCodes(false);
            Object[] detailExceptions = jboEx.getDetails();
            if ((detailExceptions != null) && (detailExceptions.length > 0)) {
                for (int z = 0, numEx = detailExceptions.length; z < numEx; z++) {
                    disableAppendCodes((Exception)detailExceptions[z]);
                }
            }
        }
    }

    /**
     * Get the root exception
     * @param ex
     * @return
     */
    public Throwable getRootCauseException(Throwable ex) {
        Throwable rtEx = null;
        if ((rtEx = ex.getCause()) == null) {
            return ex;
        } else {
            return getRootCauseException(rtEx);
        }

    }

}
