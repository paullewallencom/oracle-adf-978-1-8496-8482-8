package com.packtpub.adfguide.ch11.view.view;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.faces.validator.ValidatorException;

import oracle.adf.view.rich.component.rich.input.RichInputText;

public class ValidateBean {
    private RichInputText deptName;
    private String email;

    public ValidateBean() {

    }

    public void validateDepartmentName(FacesContext facesContext, UIComponent uIComponent, Object object) {
        // Add event code here..
        if (!validateDeptUsingCompanyRules(object)) {
            FacesMessage message =
                new FacesMessage(FacesMessage.SEVERITY_ERROR, null, "Department Name is not as per org. standrad");
            //FacesContext.getCurrentInstance().addMessage(getDeptName().getClientId(), message);
            throw new ValidatorException(message);
        }
    }

    private boolean validateDeptUsingCompanyRules(Object object) {
        return true;
    }

    public void actionListenerErrorCheck(ActionEvent actionEvent) {
        // Add event code here...
        System.out.println("actionListenerErrorCheck");
        //throw new NullPointerException("Test");

    }

    public String actionErrorCheck() {
        // Add event code here...
        return "errorCheck";
    }

    public void setDeptName(RichInputText deptName) {
        this.deptName = deptName;
    }

    public RichInputText getDeptName() {
        return deptName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void deptChanged(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        System.out.println("deptChanged - " + valueChangeEvent.getNewValue());
    }
}
