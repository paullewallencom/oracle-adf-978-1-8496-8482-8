package com.packtpub.adfguide.ch12.view;

import javax.faces.event.ActionEvent;

import javax.faces.event.ActionEvent;

import oracle.adf.model.BindingContext;

import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCIteratorBinding;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

public class CRUDBean {
    public CRUDBean() {
    }

    public BindingContainer getBindings() {
        return BindingContext.getCurrent().getCurrentBindingsEntry();
    }

    public void removeDept(ActionEvent actionEvent) {
        DCBindingContainer bindings = (DCBindingContainer)getBindings();
        OperationBinding operationBinding1 = bindings.getOperationBinding("Delete");
        operationBinding1.execute();
        if (operationBinding1.getErrors().isEmpty()) {
            OperationBinding operationBinding2 = bindings.getOperationBinding("removeDepartments");
            operationBinding2.execute();
        }


    }

    public void newDept(ActionEvent actionEvent) {
        DCBindingContainer bindings = (DCBindingContainer)getBindings();
        OperationBinding operationBinding1 = bindings.getOperationBinding("Create");
        operationBinding1.execute();
        if (operationBinding1.getErrors().isEmpty()) {
            OperationBinding operationBinding2 = bindings.getOperationBinding("persistDepartments");
            operationBinding2.execute();
        }


    }
}
