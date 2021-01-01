package com.packtpub.adfguide.ch9.view.managed;

import java.util.HashMap;
import java.util.Map;

import javax.faces.event.ValueChangeEvent;

import oracle.adf.controller.TaskFlowId;


import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCParameter;
import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.binding.AttributeBinding;
import oracle.binding.BindingContainer;

import oracle.jbo.uicli.binding.JUCtrlActionBinding;
import oracle.jbo.uicli.binding.JUCtrlListBinding;

public class DynamicTaskFlowBean {
    private final String EMP_SUMMARY_TF =
        "/WEB-INF/dynamic/emp-summary-task-flow-definition.xml#emp-summary-task-flow-definition";
    private final String EMP_DETAIL_TF =
        "/WEB-INF/dynamic/emp-detail-task-flow-definition.xml#emp-detail-task-flow-definition";
    private Map<String, Object> parameterMap = new HashMap<String, Object>();
    private boolean deptChanged = false;

    public DynamicTaskFlowBean() {
        super();
    }

    public TaskFlowId getDynamicTaskFlowId() {
        if ("summary".equals(AdfFacesContext.getCurrentInstance().getPageFlowScope().get("EmpViewHint"))) {

            return TaskFlowId.parse(EMP_SUMMARY_TF);
        } else {
            return TaskFlowId.parse(EMP_DETAIL_TF);
        }
    }

    public void displayParameters() {
        DCBindingContainer pageBindingContainer =
            (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        // Get parent page's iterator binding
        //DCBindingContainer taskFloBinding = (DCTaskFlowBinding)pageBindingContainer.getRegionContainer();
        // DCParameter parm = (DCParameter)taskFloBinding.getParametersMap();
    }

    /**
     *Pramaeters used in the dynamically added taskflow.
     */
    public Map getParameterMap() {
        parameterMap.clear();
        String tfName = getDynamicTaskFlowId().getFullyQualifiedName();
        BindingContainer bindings = getBindingContainer();
        if (EMP_DETAIL_TF.equals(tfName)) {
            // Read attribute binding
            AttributeBinding deptAttrib = (AttributeBinding)bindings.getControlBinding("DepartmentId");
            AttributeBinding empAttrib = (AttributeBinding)bindings.getControlBinding("EmployeeId");
            parameterMap.put("departmentId", deptAttrib.getInputValue());
            // parameterMap.put("EmployeeId", empAttrib.getInputValue());
        } else if (EMP_SUMMARY_TF.equals(tfName)) {
            AttributeBinding deptAttrib = (AttributeBinding)bindings.getControlBinding("DepartmentId");
            parameterMap.put("departmentId", deptAttrib.getInputValue());
        }
        System.out.println("Param -" + parameterMap);
        return parameterMap;
    }

    public BindingContainer getBindingContainer() {
        return BindingContext.getCurrent().getCurrentBindingsEntry();
    }

    public void empViewChanged(ValueChangeEvent valueChangeEvent) {
        boolean isSelected = ((Boolean)valueChangeEvent.getNewValue()).booleanValue();
        if (isSelected) {
            AdfFacesContext.getCurrentInstance().getPageFlowScope().put("EmpViewHint", "summary");
        } else {
            AdfFacesContext.getCurrentInstance().getPageFlowScope().put("EmpViewHint", "detail");
        }
    }


    public void setDeptChanged(boolean deptChanged) {
        this.deptChanged = deptChanged;
    }

    public boolean isDeptChanged() {
        boolean tmp = deptChanged;
        deptChanged = !deptChanged;
        return tmp;
        //return deptChanged;
    }

    public void initializer() {
        System.out.println("--initializer--");
    }

    public void finalizer() {
        System.out.println("--finalizer--");
    }

    public void dispathProgrammatically() {
        Object payLoad = null;
        DCBindingContainer bc = (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        JUCtrlActionBinding actionBnd = (JUCtrlActionBinding)bc.getControlBinding("producerMethod");
        ((DCBindingContainer)bc).getEventDispatcher().queueEvent(actionBnd.getEventProducer(), payLoad);
        ((DCBindingContainer)bc).getEventDispatcher().processContextualEvents();
    }
}
