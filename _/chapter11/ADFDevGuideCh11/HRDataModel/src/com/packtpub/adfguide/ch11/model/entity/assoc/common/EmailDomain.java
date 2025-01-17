package com.packtpub.adfguide.ch11.model.entity.assoc.common;

import com.packtpub.adfguide.ch11.view.model.CustomErrorMessageBundle;

import java.io.Serializable;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import oracle.jbo.JboException;
import oracle.jbo.Transaction;
import oracle.jbo.domain.DataCreationException;
import oracle.jbo.domain.DomainInterface;
import oracle.jbo.domain.DomainOwnerInterface;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Fri Mar 23 22:08:12 IST 2012
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class EmailDomain implements DomainInterface, Serializable {
    public EmailDomain(String val) {
        mData = new String(val);
        validate();
    }
    private String mData;

    protected EmailDomain() {
        mData = "";
    }

    public Object getData() {
        return mData;
    }

    /**
     * <b>Internal:</b> <em>Applications should not use this method.</em>
     */
    public void setContext(DomainOwnerInterface owner, Transaction trans, Object obj) {
    }

    /**
     * Implements domain validation logic and throws a JboException on error.
     */
    protected void validate() {
        Pattern emailPattern =
            Pattern.compile("^[a-zA-Z0-9_]*$"); //^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}$");
        Matcher matcher = emailPattern.matcher(getData().toString());
        System.out.println(getData().toString() + " - " + matcher.matches());
        if (!matcher.matches()) {
            throw new DataCreationException(CustomErrorMessageBundle.class, CustomErrorMessageBundle.INVALID_EMAIL,
                                            null, null);
        }

    }

    public String toString() {
        if (mData != null) {
            return mData.toString();
        }
        return "<null>";
    }

    public boolean equals(Object obj) {
        if (obj instanceof DomainInterface) {
            if (mData != null) {
                return mData.equals(((DomainInterface)obj).getData());
            }
            return ((DomainInterface)obj).getData() == null;
        }
        return false;
    }
}
