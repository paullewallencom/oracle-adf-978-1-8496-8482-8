package com.packtpub.adfguide.ch9.view.managed;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import java.util.Map;

import javax.faces.event.ActionEvent;

import oracle.adf.controller.TaskFlowId;
import oracle.adf.controller.binding.TaskFlowBindingAttributes;

public class MultiTaskflowBean {
    private Map<String, Object> parameterMap = new HashMap<String, Object>();
    private List<TaskFlowBindingAttributes> taskFlowBindings = new ArrayList<TaskFlowBindingAttributes>();

    public MultiTaskflowBean() {

    }

    /**
     * This constructs TaskFlowBindingAttributes list dynamically
     */
    public void buidTaskflowBindings() {

        //Define TaskFlowBindingAttributes that holdsdept-task-flow-definition
        TaskFlowBindingAttributes tfBindingAttrib1 = new TaskFlowBindingAttributes();
        //Set identifier for the binding
        tfBindingAttrib1.setId("region1");
        //Set task flow id
        tfBindingAttrib1.setTaskFlowId(new TaskFlowId("/WEB-INF/multitaskflow/dept-task-flow-definition.xml",
                                                      "dept-task-flow-definition"));
        taskFlowBindings.add(tfBindingAttrib1);

        //Define TaskFlowBindingAttributes that holds emp-task-flow-definitionn
        TaskFlowBindingAttributes tfBindingAttrib2 = new TaskFlowBindingAttributes();
        tfBindingAttrib2.setId("region2");
        tfBindingAttrib2.setTaskFlowId(new TaskFlowId("/WEB-INF/multitaskflow/emp-task-flow-definition.xml",
                                                      "emp-task-flow-definition"));
        intializeTaksFlowPramaMap();
        //Pass parameters to task flow
        tfBindingAttrib2.setParametersMap("#{pageFlowScope.MultiTaskflowBean.parameterMap}");
        taskFlowBindings.add(tfBindingAttrib2);
    }


    public void intializeTaksFlowPramaMap() {
        parameterMap.clear();
        parameterMap.put("DepartmentId", new Integer(80));
    }

    /**
     *  Pramaeters used in dynamically added taskflow.
     *  EL #{pageFlowScope.MainBean.parameterMap} refers this map
     *  DepartmentId is hardcoded in this sample
     */
    public Map getParameterMap() {

        return parameterMap;
    }

    public void addTaskFlows(ActionEvent actionEvent) {
        // Add event code here...
        buidTaskflowBindings();
    }

    public void setParameterMap(Map<String, Object> parameterMap) {
        this.parameterMap = parameterMap;
    }

    public void setTaskFlowBindings(List<TaskFlowBindingAttributes> taskFlowBindings) {
        this.taskFlowBindings = taskFlowBindings;
    }

    public List<TaskFlowBindingAttributes> getTaskFlowBindings() {
        System.out.println("getTaskFlowBindings - I'm called");
        return taskFlowBindings;
    }
}
