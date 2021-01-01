package com.packtpub.adfguide.ch11.view.general;

import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;

import oracle.adf.view.rich.context.ExceptionHandler;

public class CustomExceptionHandler extends ExceptionHandler {
    public CustomExceptionHandler() {
        super();
        System.out.println(" -- CustomExceptionHandler -- ");
    }

    @Override
    public void handleException(FacesContext context, Throwable t, PhaseId id) throws Throwable {
        System.out.println(" -- handleException -- ");
    }
}
