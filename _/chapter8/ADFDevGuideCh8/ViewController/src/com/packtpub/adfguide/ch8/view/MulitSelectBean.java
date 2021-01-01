package com.packtpub.adfguide.ch8.view;

import oracle.adf.model.BindingContext;

import oracle.adf.model.binding.DCBindingContainer;

import oracle.adf.share.ADFContext;

import oracle.binding.BindingContainer;

import oracle.jbo.Row;
import oracle.jbo.uicli.binding.JUCtrlListBinding;

public class MulitSelectBean {
    public MulitSelectBean() {
    }

    public String findActionHandler() {

        BindingContext bctx = BindingContext.getCurrent();
        BindingContainer bc = bctx.getCurrentBindingsEntry();
        JUCtrlListBinding departsments = (JUCtrlListBinding)bc.get("Departments");
        int[] selectedIndices = departsments.getSelectedIndices();
        for (int indx : selectedIndices) {
            Row row = departsments.getRowAtRangeIndex(indx);
            System.out.println("Selected "+row.getAttribute(0));
            //Work with row
        }
        return null;
    }
}
