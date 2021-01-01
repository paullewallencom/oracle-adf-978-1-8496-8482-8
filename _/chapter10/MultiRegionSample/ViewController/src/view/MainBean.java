package view;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;

import java.util.Map;

import javax.faces.event.ActionEvent;

import oracle.adf.controller.TaskFlowContext;
import oracle.adf.controller.TaskFlowId;
import oracle.adf.controller.binding.TaskFlowBindingAttributes;

public class MainBean {
    private List<TaskFlowBindingAttributes> taskFlowBindings = new ArrayList<TaskFlowBindingAttributes>();
    private Map<String, Object> parameterMap = new HashMap<String, Object>();
    private int id = 1;

    /**
     * Taskflow info which needs to be added at run time
     * */
    private DynamicTaskFlowContext[] taskflowContexts =
    { new DynamicTaskFlowContext("/WEB-INF/dept-task-flow-definition.xml", "dept-task-flow-definition", null),
      new DynamicTaskFlowContext("/WEB-INF/emp-task-flow-definition.xml", "emp-task-flow-definition",
                                 "#{pageFlowScope.MainBean.parameterMap}") };

    public MainBean() {

    }


    public void displayTaskflows(ActionEvent actionEvent) {
        /**
         * Build taskflow bindings at runtime         *
         */

        for (DynamicTaskFlowContext contxt : taskflowContexts) {
            TaskFlowBindingAttributes taskFlowBindingAttributes = new TaskFlowBindingAttributes();
            taskFlowBindingAttributes.setId("region" + (id++));
            taskFlowBindingAttributes.setTaskFlowId(contxt.getTaskFlowId());
            if (contxt.getParamMap() != null) {
                initPramaMap(contxt.getTaskFlowId());
            }
            taskFlowBindingAttributes.setParametersMap(contxt.getParamMap());
            taskFlowBindings.add(taskFlowBindingAttributes);
            System.out.println("Added " + contxt.getTaskFlowId() + " loop:" + id);
        }
    }

    private void initPramaMap(TaskFlowId tfId) {
        parameterMap.put("DepartmentId", new oracle.jbo.domain.Number(80));
    }

    /**
     * Pramaeters used in dynamically added taskflow.
     *  EL #{pageFlowScope.MainBean.parameterMap} refers this map
     *  Value is hardcoded in this sample
     *
     * @return
     */
    public Map getParameterMap() {

        return parameterMap;
    }

    public void setTaskFlowBindings(List<TaskFlowBindingAttributes> taskFlowBindings) {
        this.taskFlowBindings = taskFlowBindings;
    }

    public List<TaskFlowBindingAttributes> getTaskFlowBindings() {
        System.out.println("taskFlowBindings size:" + taskFlowBindings.size());
        return taskFlowBindings;
    }

    /**
     * A data structure  to hold dynamically added task flow meta data
     */
    class DynamicTaskFlowContext {
        TaskFlowId taskFlowId;
        String documentName;
        String localTaskFlowId;
        String paramMap;

        public DynamicTaskFlowContext(String documentName, String localTaskFlowId, String paramMap) {
            super();
            this.documentName = documentName;
            this.localTaskFlowId = localTaskFlowId;
            taskFlowId = new TaskFlowId(documentName, localTaskFlowId);
            this.paramMap = paramMap;
        }

        public TaskFlowId getTaskFlowId() {
            return taskFlowId;
        }

        public String getParamMap() {
            return paramMap;
        }
    }
}
