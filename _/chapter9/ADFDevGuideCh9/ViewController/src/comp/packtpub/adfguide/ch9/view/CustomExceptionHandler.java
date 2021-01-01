package comp.packtpub.adfguide.ch9.view;


import java.io.IOException;

import java.util.Iterator;

import java.util.Map;

import javax.faces.FacesException;
import javax.faces.application.NavigationHandler;
import javax.faces.application.ViewExpiredException;
import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExceptionHandlerWrapper;
import javax.faces.context.FacesContext;
import javax.faces.event.ExceptionQueuedEvent;
import javax.faces.event.ExceptionQueuedEventContext;

public class CustomExceptionHandler extends ExceptionHandlerWrapper {
    public CustomExceptionHandler() {
        super();
    }
    private ExceptionHandler wrapped;

    public CustomExceptionHandler(ExceptionHandler wrapped) {
        this.wrapped = wrapped;
    }

    @Override
    public ExceptionHandler getWrapped() {
        return this.wrapped;
    }

    @Override
    public void handle() throws FacesException {
        //Iterate over all unhandeled exceptions
        Iterator i = getUnhandledExceptionQueuedEvents().iterator();
        while (i.hasNext()) {
            ExceptionQueuedEvent event = (ExceptionQueuedEvent)i.next();
            ExceptionQueuedEventContext context = (ExceptionQueuedEventContext)event.getSource();

            Throwable t = context.getException().getCause();

            if (t instanceof CustomViewExcpetion) {

                FacesContext fc = FacesContext.getCurrentInstance();
                Map<String, Object> requestMap = fc.getExternalContext().getRequestMap();
                try {
                    System.out.println(" -- Implicit Handler  -- ");
                    NavigationHandler nav = fc.getApplication().getNavigationHandler();
                    nav.handleNavigation(fc, null, "customErrPage");
                    fc.renderResponse();
                } finally {
                    i.remove();
                }
            }
        }

        getWrapped().handle();
    }
}
