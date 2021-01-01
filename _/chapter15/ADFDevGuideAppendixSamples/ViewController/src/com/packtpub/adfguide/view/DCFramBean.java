package com.packtpub.adfguide.view;

import javax.faces.event.ActionEvent;

import oracle.adf.model.BindingContext;
import oracle.adf.model.DataControlFrame;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.dcframe.TransactionProperties;

public class DCFramBean {
    public DCFramBean() {
    }

    public void start() {
        BindingContext context = BindingContext.getCurrent();
        String dataControlFrameName = context.getCurrentDataControlFrame();
        DataControlFrame dcFrame = context.findDataControlFrame(dataControlFrameName);
        dcFrame.beginTransaction(new TransactionProperties());
    }

    public void save(ActionEvent actionEvent) {
        //Get the binding context
        BindingContext bindingContext = BindingContext.getCurrent();
        //Gets the name of current(root) DataControlFrame
        String currentFrame = bindingContext.getCurrentDataControlFrame();
        //Finds DataControlFrame instance
        DataControlFrame dcFrame = bindingContext.findDataControlFrame(currentFrame);
        try {
            // Commit the trensaction
            dcFrame.commit();
            // Open a new transaction allowing user to continue
            // editing data
            dcFrame.beginTransaction(null);
        } catch (Exception e) {
            e.printStackTrace();
            //Report error through binding container
            ((DCBindingContainer)bindingContext.getCurrentBindingsEntry()).reportException(e);
        }
        System.out.println("Save Clicked");
    }

    public void start(ActionEvent actionEvent) {
        // Add event code here...
    }
}
