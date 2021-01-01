package com.packtpub.adfguide.ch14.view;

import java.util.Map;

import oracle.adf.controller.ControllerContext;
import oracle.adf.controller.TaskFlowId;
import oracle.adf.controller.security.ActivitySecurity;
import oracle.adf.controller.security.TaskFlowPermission;
import oracle.adf.model.BindingContext;
import oracle.adf.model.DataControlFrame;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.share.ADFContext;
import oracle.adf.share.security.authorization.RegionPermission;
import oracle.adf.share.security.binding.BindingPermission;

import oracle.adf.view.rich.component.rich.data.RichTreeTable;


public class DeptBean {
    public DeptBean() {
    }

    public void commit() {
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
            //Report error through binding container
            ((DCBindingContainer)bindingContext.getCurrentBindingsEntry()).reportException(e);

        }
    }

    public String securityCheck() {
        // Add event code here...

        ControllerContext controllerContext = ControllerContext.getInstance();
        Map<String, ActivitySecurity> activitySecurityMap = controllerContext.getSecurity().getActivity();
        Map<String, ActivitySecurity> permissionSecurityMap = controllerContext.getSecurity().getPermission();
        TaskFlowId taskFlowId = TaskFlowId.parse("/WEB-INF/dept-task-flow-definition.xml#dept-ask-flow-definition");
        BindingPermission bindingPermission = controllerContext.getSecurity().getBindingPermission(taskFlowId);
        if (bindingPermission.hasPermission("view")) {
            System.out.println("Access Deteced1");
        }

        TaskFlowPermission taskFlowPermission =
            controllerContext.getSecurity().getPermission(taskFlowId, TaskFlowPermission.VIEW_ACTION);
        if (ADFContext.getCurrent().getSecurityContext().hasPermission(taskFlowPermission)) {
            System.out.println("Access Deteced2");
        }
        RegionPermission perm =
            new RegionPermission("com.packtpub.adfguide.ch14.view.pageDefs.deptPageDef", RegionPermission.VIEW_ACTION);
        if (ADFContext.getCurrent().getSecurityContext().hasPermission(perm)) {
        }
        return null;
    }
}
