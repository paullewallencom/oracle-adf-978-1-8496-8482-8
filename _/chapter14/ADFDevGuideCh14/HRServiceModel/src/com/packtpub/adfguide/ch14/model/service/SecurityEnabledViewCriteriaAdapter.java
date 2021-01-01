package com.packtpub.adfguide.ch14.model.service;

import oracle.adf.share.ADFContext;
import oracle.adf.share.security.SecurityContext;

import oracle.jbo.CriteriaAdapter;
import oracle.jbo.ViewCriteria;
import oracle.jbo.server.CriteriaAdapterImpl;
import oracle.jbo.server.ViewDefImpl;
import oracle.jbo.server.ViewObjectImpl;


public class SecurityEnabledViewCriteriaAdapter extends CriteriaAdapterImpl implements CriteriaAdapter {

    private static String SECVCNAME = "SecurityEnabledEmptyVC_";

    public SecurityEnabledViewCriteriaAdapter() {
        super();
    }


    /**
     * Generate a security predicate for the view criteria(if conditions are met).
     * This example appends USER_NAME = '<surrent_username>' with the query
     * @param criteria a view criteria instance
     * @return a where clause fragment
     */
    public String getCriteriaClause(ViewCriteria criteria) {
        ViewObjectImpl vo = (ViewObjectImpl)criteria.getViewObject();
        if (isSecurityEnabled() && isSecureVC(criteria)) {
            String loggedInUser = ADFContext.getCurrent().getSecurityContext().getUserName();
            ViewDefImpl voDef = (ViewDefImpl)vo.getDef();

            String securityClause =
                voDef.getEntityUsages()[0].getEntityDef().getAliasName() + ".USER_NAME = '" + loggedInUser + "'";
            return securityClause;
        }
        return super.getCriteriaClause(criteria);
    }

    /**
     * Check if security is enabled for the application
     * @return
     */
    private boolean isSecurityEnabled() {
        SecurityContext secCtx = ADFContext.getCurrent().getSecurityContext();
        return secCtx.isAuthorizationEnabled();
    }

    /**
     * Check if the view criteris is meant for generating security predicates
     * @param vc
     * @return
     */
    public static boolean isSecureVC(ViewCriteria vc) {
        return ((vc == null) ? false : (vc.getName() == null ? false : vc.getName().equalsIgnoreCase(SECVCNAME)));
    }

}
