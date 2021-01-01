package com.packtpub.adfguide.ch8.model.view;

import oracle.jbo.LocaleContext;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.ViewRowAttrHintsImpl;
import oracle.jbo.server.ViewRowImpl;

public class CustomRowAAttrHintsImpl extends ViewRowAttrHintsImpl {

    public CustomRowAAttrHintsImpl(AttributeDefImpl attr, ViewRowImpl viewRow) {
        super(attr, viewRow);
    }

    @Override
    public String getHint(LocaleContext locale, String sHintName) {
        //If attribute is ManagerId, execute custom hint
        if (getViewAttributeDef().getName().equals("ManagerId")) {
            if (ViewRowAttrHintsImpl.HINT_NAME_DISPLAY_HINT.
               equals(sHintName)) {
                if (isNormalUser())
                    //For normal user return 'Hide' 
                    //else return 'Display'
                    return ViewRowAttrHintsImpl.
                        ATTRIBUTE_DISPLAY_HINT_HIDE;
                else
                    return ViewRowAttrHintsImpl.
                        ATTRIBUTE_DISPLAY_HINT_DISPLAY;
            }
        }
        return super.getHint(locale, sHintName);
    }

    private boolean isNormalUser() {
        return false;
    }

}
