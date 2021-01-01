package com.packtpub.adfguide.ch4.model.entity;

import oracle.jbo.Key;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.EntityDefImpl;
import oracle.jbo.server.EntityImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Wed Oct 26 13:51:09 IST 2011
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class MarketingEmployeeGenericEOImpl extends EntityImpl {
    /**
     * This is the default constructor (do not remove).
     */
    public MarketingEmployeeGenericEOImpl() {
    }

    /**
     * @param employeeId key constituent

     * @return a Key object based on given key constituents.
     */
    public static Key createPrimaryKey(Integer employeeId) {
        return new Key(new Object[]{employeeId});
    }

    /**
     * @return the definition object for this instance class.
     */
    public static synchronized EntityDefImpl getDefinitionObject() {
        return EntityDefImpl.findDefObject("com.packtpub.adfguide.ch4.model.entity.MarketingEmployeeGenericEO");
    }


    public void processRow() {
        System.out.println("- MarketingEmployeeGenericEOImpl::processRow -");

    }

}