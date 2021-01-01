package com.packtpub.adfguide.ch8.view;

import javax.el.ELContext;

import javax.el.ExpressionFactory;

import javax.el.MethodExpression;

import javax.faces.context.FacesContext;

import javax.faces.event.ActionEvent;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.share.ADFContext;
import oracle.adf.view.rich.component.rich.RichQuery;
import oracle.adf.view.rich.event.QueryEvent;
import oracle.adf.view.rich.model.QueryDescriptor;
import oracle.adf.view.rich.model.QueryModel;

import oracle.jbo.ViewCriteria;
import oracle.jbo.ViewCriteriaRow;
import oracle.jbo.ViewObject;
import oracle.jbo.uicli.binding.JUSearchBindingCustomizer;

public class SearchBean {
    private RichQuery deptQuery;

    public SearchBean() {

    }

    public void queryPerfromed(QueryEvent queryEvent) {
        DCBindingContainer bc = (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        DCBindingContainer searchBinding = (DCBindingContainer)bc.findExecutableBinding("DepartmentViewCriteriaQuery");
        String criteriaName = JUSearchBindingCustomizer.getCriteriaName(searchBinding);
        ViewCriteria vc = JUSearchBindingCustomizer.getViewCriteria(searchBinding, criteriaName);
        ViewCriteriaRow vcr1 = vc.createViewCriteriaRow();
        vcr1.setAttribute("DepartmentId","10");
        vc.addRow(vcr1);
        invokeQueryEventMethodExpression("#{bindings.DepartmentViewCriteriaQuery.processQuery}", queryEvent);

    }
    /**
     * Invoke Query EL
     * @param expression
     * @param queryEvent
     */
    private void invokeQueryEventMethodExpression(String expression, QueryEvent queryEvent) {

        FacesContext fctx = FacesContext.getCurrentInstance();
        ELContext elctx = fctx.getELContext();
        ExpressionFactory efactory = fctx.getApplication().getExpressionFactory();
        MethodExpression me =
            efactory.createMethodExpression(elctx, expression, Object.class, new Class[] { QueryEvent.class });
        me.invoke(elctx, new Object[] { queryEvent });

    }

    public void setDeptQuery(RichQuery deptQuery) {
        this.deptQuery = deptQuery;
    }

    public RichQuery getDeptQuery() {
        return deptQuery;
    }

    public void actionHandler(ActionEvent actionEvent) {
        // Add event code here...
        RichQuery deptQuery = getDeptQuery();
        QueryModel model = deptQuery.getModel();
        QueryDescriptor qd = deptQuery.getValue();
        model.reset(qd);
        deptQuery.refresh(FacesContext.getCurrentInstance());
    }
}
