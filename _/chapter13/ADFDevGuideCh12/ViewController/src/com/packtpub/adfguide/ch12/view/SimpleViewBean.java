package com.packtpub.adfguide.ch12.view;

import javax.faces.event.ActionEvent;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCIteratorBinding;

import oracle.jbo.RowSetIterator;

public class SimpleViewBean {
    public SimpleViewBean() {
    }

    public void iterateOverRows(ActionEvent actionEvent) {
        // Add event code here...
        DCBindingContainer dcb = (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        DCIteratorBinding dcib = dcb.findIteratorBinding("departmentsFindAllIterator");

        RowSetIterator rowIter = dcib.getRowSetIterator();
        rowIter.reset();
        System.out.println("-" + rowIter.hasNext());
        while (rowIter.hasNext()) {
            System.out.println("-" + rowIter.next().getAttribute(1));
        }
    }
}
