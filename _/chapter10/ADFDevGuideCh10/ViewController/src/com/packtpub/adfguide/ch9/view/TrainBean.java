package com.packtpub.adfguide.ch9.view;

import java.util.Map;

import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.el.ValueExpression;

import javax.faces.application.Application;
import javax.faces.context.FacesContext;

import oracle.adf.controller.ControllerContext;
import oracle.adf.controller.TaskFlowContext;
import oracle.adf.controller.TaskFlowId;
import oracle.adf.controller.TaskFlowTrainModel;
import oracle.adf.controller.TaskFlowTrainStopModel;
import oracle.adf.controller.ViewPortContext;
import oracle.adf.controller.metadata.MetadataService;
import oracle.adf.controller.metadata.model.TaskFlowDefinition;
import oracle.adf.controller.metadata.model.TaskFlowInputParameter;

public class TrainBean {
    public TrainBean() {
    }
    /**
     *Action method 
     * @return
     */
    public String nextTrainStop() {
        String url=
        ControllerContext.getInstance().getLocalViewActivityURL("empView");
        System.out.println("URL-"+url);
        //Get cuurent stop
        TaskFlowTrainModel model =
            ControllerContext.getInstance().getCurrentViewPort().getTaskFlowContext().getTaskFlowTrainModel();
        TaskFlowTrainStopModel currentStop = model.getCurrentStop();
        //Next train stop
        TaskFlowTrainStopModel nextStop = model.getNextStop(currentStop);
        if (nextStop != null)
            return nextStop.getOutcome();
        else
            return currentStop.getOutcome();
    }

    public boolean isCurrentTab() {
        //Get cuurent stop
        TaskFlowTrainModel model =
            ControllerContext.getInstance().getCurrentViewPort().getTaskFlowContext().getTaskFlowTrainModel();
        TaskFlowTrainStopModel currentStop = model.getCurrentStop();
        //Next train stop
        TaskFlowTrainStopModel nextStop = model.getNextStop(currentStop);
        //Previous Train stop
        TaskFlowTrainStopModel prevtStop = model.getPreviousStop(currentStop);

        //Following code helps you to get current view activity in the task flow
        FacesContext fctx = FacesContext.getCurrentInstance();
        ELContext elctx = fctx.getELContext();
        Application app = fctx.getApplication();
        ExpressionFactory expressionFactory = app.getExpressionFactory();
        //trainNode is the name of the variable attribute defined in af:navigationPane
        ValueExpression ve = expressionFactory.createValueExpression(elctx, "#{trainNode}", Object.class);
        TaskFlowTrainStopModel renderedTrainNode = (TaskFlowTrainStopModel)ve.getValue(elctx);
        String renderedActivityId = renderedTrainNode.getLocalActivityId();
        //Check whether renderedActivityId is same as current stop
        if (renderedActivityId.equalsIgnoreCase(currentStop.getLocalActivityId())) {
            return true;
        }
        return false;
    }

    public void test() {
        String taskFlowId = "/WEB-INF/dynamic/emp-detail-task-flow-definition.xml#emp-detail-task-flow-definition";
        TaskFlowId tfId = TaskFlowId.parse(taskFlowId);
        TaskFlowDefinition taskFlowDef = MetadataService.getInstance().getTaskFlowDefinition(tfId);
        Map<String, TaskFlowInputParameter> inputParams = taskFlowDef.getInputParameters();

    }
}
