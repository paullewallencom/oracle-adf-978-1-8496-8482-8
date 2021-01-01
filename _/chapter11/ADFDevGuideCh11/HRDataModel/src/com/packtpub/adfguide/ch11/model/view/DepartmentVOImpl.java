package com.packtpub.adfguide.ch11.model.view;

import java.util.Locale;

import oracle.jbo.common.ResourceBundleDef;
import oracle.jbo.common.StringManager;
import oracle.jbo.server.ViewObjectImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Tue Aug 21 20:51:17 IST 2012
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class DepartmentVOImpl extends ViewObjectImpl {
    /**
     * This is the default constructor (do not remove).
     */
    public DepartmentVOImpl() {
    }

    public String getLocalizedValue(String key) {

        ResourceBundleDef resourceDef = this.getResourceBundleDef();
        Locale locale = this.getDBTransaction().getSession().getLocale();
        String retVal = StringManager.getLocalizedStringFromResourceDef(resourceDef, key, null, locale, null, false);
        return retVal;
    }
}