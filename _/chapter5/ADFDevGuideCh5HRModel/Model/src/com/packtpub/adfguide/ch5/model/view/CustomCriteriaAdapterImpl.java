package com.packtpub.adfguide.ch5.model.view;

import oracle.jbo.CriteriaAdapter;
import oracle.jbo.ViewCriteria;
import oracle.jbo.server.CriteriaAdapterImpl;

public class CustomCriteriaAdapterImpl extends CriteriaAdapterImpl implements CriteriaAdapter {
    public CustomCriteriaAdapterImpl() {
        super();
    }

    @Override
    public String getCriteriaClause(ViewCriteria criteria) {
        String clause =super.getCriteriaClause(criteria);
        return clause;
    }
}
