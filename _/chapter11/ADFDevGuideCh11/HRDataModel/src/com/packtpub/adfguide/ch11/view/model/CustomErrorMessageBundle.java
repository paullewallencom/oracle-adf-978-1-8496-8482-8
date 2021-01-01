package com.packtpub.adfguide.ch11.view.model;

import java.util.ListResourceBundle;

public class CustomErrorMessageBundle extends ListResourceBundle {
    public static final String INVALID_EMAIL = "INVALID_EMAIL";
    //EMP_EMAIL_UK is the Unique Key constraint defined on EMPLOYEE table
    private static final Object[][] messageKeyValues =
        new String[][] { { "EMP_EMAIL_UK", "Please check the Email field, " + "this is in use" },
                         { INVALID_EMAIL, "Invalid Email" } };

    /**Return String Identifiers and corresponding Messages in a
     * two-dimensional array.
     */
    protected Object[][] getContents() {
        return messageKeyValues;
    }
    public CustomErrorMessageBundle(){
        System.out.println();
    }

    /**
     * Determines whether the given <code>key</code> is contained in
     * this <code>ResourceBundle</code> or its parent bundles.
     *
     * @param key
     *        the resource <code>key</code>
     * @return <code>true</code> if the given <code>key</code> is
     *        contained in this <code>ResourceBundle</code> or its
     *        parent bundles; <code>false</code> otherwise.
     * @exception NullPointerException
     *         if <code>key</code> is <code>null</code>
     * @since 1.6
     */
    public boolean containsKey(String key) {
        return super.containsKey(key);
    }
}
