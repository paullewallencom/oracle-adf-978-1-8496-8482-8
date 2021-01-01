package com.packtpub.adfguide.ch9.view.managed;

import javax.faces.component.UIComponent;

import oracle.adf.view.rich.component.rich.input.RichInputText;

import oracle.adf.view.rich.context.AdfFacesContext;

import org.apache.myfaces.trinidad.context.RequestContext;
import org.apache.myfaces.trinidad.event.ReturnEvent;

public class TaskFlowLOVBean {


    public TaskFlowLOVBean() {
    }

    public void dialogReturnHandler(ReturnEvent returnEvent) {
        System.out.println(returnEvent.getReturnParameters() + "-" + returnEvent.getReturnValue());
        System.out.println(AdfFacesContext.getCurrentInstance().getPageFlowScope().get("selectedLoc"));
        AdfFacesContext.getCurrentInstance().getPageFlowScope().put("selectedLoc", returnEvent.getReturnValue());
        UIComponent comp = returnEvent.getComponent().findComponent("it4");
        RequestContext.getCurrentInstance().addPartialTarget(comp);
    }

  
}
