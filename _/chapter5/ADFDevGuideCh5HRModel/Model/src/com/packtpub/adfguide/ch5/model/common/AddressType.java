package com.packtpub.adfguide.ch5.model.common;

import java.lang.String;

import java.math.BigDecimal;
import java.math.BigInteger;

import java.sql.SQLException;

import oracle.jbo.JboException;
import oracle.jbo.StructureDef;
import oracle.jbo.domain.DatumFactory;
import oracle.jbo.domain.DomainAttributeDef;
import oracle.jbo.domain.DomainInterface;
import oracle.jbo.domain.DomainOwnerInterface;
import oracle.jbo.domain.DomainStructureDef;
import oracle.jbo.domain.Struct;

import oracle.sql.*;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Fri Nov 11 16:16:17 IST 2011
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class AddressType extends Struct {
    static ORADataFactory[] mCustDatFac = null;
    static int[] mSQLTypes = null;
    static DomainStructureDef mStructureDef = null;
    static ORADataFactory fac;

    public AddressType(Datum value) throws SQLException {
        super(value);
    }

    public AddressType() throws SQLException {
    }

    public static ORADataFactory getORADataFactory() {
        if (fac == null) {
            class facClass implements ORADataFactory {
                public ORAData create(Datum d, int sql_type_code) throws SQLException {
                    if (d != null) {
                        return new AddressType(d);
                    }
                    return null;
                }
            }
            fac = new facClass();
        }
        return fac;
    }

    public int[] getAttrSQLTypes() {
        if (mSQLTypes == null) {
            mSQLTypes = buildAttrSQLTypes();
        }
        return mSQLTypes;
    }

    public StructureDef getStructureDef() {
        return mStructureDef;
    }

    public String getColumnType() {
        return "ADDRESS_DETAIL";
    }

    public String getCity() {
        return (String) getAttribute(0);
    }

    public void setCity(String value) {
        setAttribute(0, value);
    }

    public String getCountry() {
        return (String) getAttribute(1);
    }

    public void setCountry(String value) {
        setAttribute(1, value);
    }

    public void initStructureDef() {
        DomainAttributeDef[] attrs = new DomainAttributeDef[2];
        if (mStructureDef == null) {
            attrs[0] = new DomainAttributeDef("City", "CITY", 0, String.class, 12, "VARCHAR", -127, 100, false);
            attrs[1] = new DomainAttributeDef("Country", "COUNTRY", 1, String.class, 12, "VARCHAR", -127, 100, false);
            mStructureDef = new DomainStructureDef(attrs);
        }
    }

    public ORADataFactory[] getAttrORADataFactories() {
        if (mCustDatFac == null) {
            mCustDatFac = new ORADataFactory[2];
            mCustDatFac[0] = null;
            mCustDatFac[1] = null;
        }
        return mCustDatFac;
    }
}
