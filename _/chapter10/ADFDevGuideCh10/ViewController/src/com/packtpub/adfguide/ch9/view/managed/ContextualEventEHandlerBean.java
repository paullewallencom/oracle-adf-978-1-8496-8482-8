package com.packtpub.adfguide.ch9.view.managed;

import oracle.adf.model.binding.DCBindingContainerCurrencyChangeEvent;
import oracle.adf.model.binding.DCBindingContainerValueChangeEvent;

import oracle.jbo.Row;

public class ContextualEventEHandlerBean {
    private String deptName;

    public ContextualEventEHandlerBean() {
        System.out.println("-----ContextualEventEHandlerBean----------");
    }

    public void deptNameChanged(String deptName) {
        this.deptName = deptName;
        System.out.println("deptNameChanged-" + deptName);
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getDeptName() {
        return deptName;
    }

    public void implicitEventHandler(Object payLoadObj) {
        DCBindingContainerValueChangeEvent payload = (DCBindingContainerValueChangeEvent)payLoadObj;
        Object newValue = payload.getNewValue();
        //Get Row passed by client
        Row row = payload.getRow();
        //Business logic goes here

    }
}

