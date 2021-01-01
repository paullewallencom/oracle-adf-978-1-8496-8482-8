package com.packtpub.adfguide.ch8.model.view;

import oracle.jbo.AttributeHints;
import oracle.jbo.LocaleContext;
import oracle.jbo.ViewCriteriaItem;
import oracle.jbo.server.RowAttrHintsImpl;

public class CustomCriteriaAttrHints extends RowAttrHintsImpl {
    ViewCriteriaItem vcItem;

    public CustomCriteriaAttrHints(ViewCriteriaItem vci) {
        super();
        vcItem = vci;
    }

    @Override
    protected AttributeHints getFormatAttributeHintsInternal(LocaleContext locale) {
        return vcItem.getAttributeDef().getUIHelper();
    }

    @Override
    protected AttributeHints getAttributeHintsInternal(String hintName, LocaleContext locale) {
        return vcItem.getAttributeDef().getUIHelper();
    }

    @Override
    public String getLocaleName(LocaleContext locale, String sName) {
        return vcItem.getAttributeDef().getUIHelper().getLocaleName(locale, sName);
    }

    @Override
    public String[][] getCompOpers(LocaleContext locale) {
        return vcItem.getAttributeDef().getUIHelper().getCompOpers(locale);
    }
    @Override
    public String getFormat(LocaleContext locale) {
        return "yyyy-MM-dd";
    }
}
