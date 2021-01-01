package com.packtpub.adfguide.ch14.model.view;

import com.packtpub.adfguide.ch14.model.service.SecurityEnabledViewCriteriaAdapter;

import oracle.jbo.CriteriaAdapter;
import oracle.jbo.server.ViewObjectImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Sat May 12 23:21:24 IST 2012
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class DepartmentVOImpl extends ViewObjectImpl {
    /**
     * This is the default constructor (do not remove).
     */
    public DepartmentVOImpl() {
    }

    /**
     * Return a custom CriteriaAdapter implementation to generate where clause
     * for ViewCriteria. The default implementation here returns null, and leave
     * it to the ViewCriteriaManager implementation class to determine which
     * CriteriaAdapter class to use.
     * Subclasses can override this method to provide a custom CriteriaAdapter
     * implementation.
     *
     * @return Custom CriteriaAdapter implementation if desired, or null.
     */
    @Override
    public CriteriaAdapter getCriteriaAdapter() {
        return new SecurityEnabledViewCriteriaAdapter();
    }
}