package com.packtpub.adfguide.ch14.model.entity;

import oracle.adf.share.ADFContext;
import oracle.adf.share.security.SecurityContext;
import oracle.adf.share.security.authorization.PrivilegeHolder;
import oracle.adf.share.security.binding.BindingPermissionDef;

import oracle.jbo.CreateRowPrivilegeException;
import oracle.jbo.DataSecurityProvider;
import oracle.jbo.Key;
import oracle.jbo.RowIterator;
import oracle.jbo.StructureDef;
import oracle.jbo.common.WeakHashtable;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.DBTransactionImpl;
import oracle.jbo.server.DataSecurityUtil;
import oracle.jbo.server.EntityCache;
import oracle.jbo.server.EntityDefImpl;
import oracle.jbo.server.EntityImpl;
import oracle.jbo.server.security.DataSecurityProviderManager;
import oracle.jbo.server.security.PermissionHelper;

import oracle.security.jps.ResourcePermission;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Thu May 10 22:06:56 IST 2012
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class DepartmentEOImpl extends EntityImpl {
    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. Do not modify.
     */
    public enum AttributesEnum {
        DepartmentId {
            public Object get(DepartmentEOImpl obj) {
                return obj.getDepartmentId();
            }

            public void put(DepartmentEOImpl obj, Object value) {
                obj.setDepartmentId((Integer)value);
            }
        },
        DepartmentName {
            public Object get(DepartmentEOImpl obj) {
                return obj.getDepartmentName();
            }

            public void put(DepartmentEOImpl obj, Object value) {
                obj.setDepartmentName((String)value);
            }
        },
        ManagerId {
            public Object get(DepartmentEOImpl obj) {
                return obj.getManagerId();
            }

            public void put(DepartmentEOImpl obj, Object value) {
                obj.setManagerId((Integer)value);
            }
        },
        LocationId {
            public Object get(DepartmentEOImpl obj) {
                return obj.getLocationId();
            }

            public void put(DepartmentEOImpl obj, Object value) {
                obj.setLocationId((Integer)value);
            }
        },
        EmployeeEO {
            public Object get(DepartmentEOImpl obj) {
                return obj.getEmployeeEO();
            }

            public void put(DepartmentEOImpl obj, Object value) {
                obj.setEmployeeEO((EntityImpl)value);
            }
        },
        EmployeeEO1 {
            public Object get(DepartmentEOImpl obj) {
                return obj.getEmployeeEO1();
            }

            public void put(DepartmentEOImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        };
        private static AttributesEnum[] vals = null;
        private static int firstIndex = 0;

        public abstract Object get(DepartmentEOImpl object);

        public abstract void put(DepartmentEOImpl object, Object value);

        public int index() {
            return AttributesEnum.firstIndex() + ordinal();
        }

        public static int firstIndex() {
            return firstIndex;
        }

        public static int count() {
            return AttributesEnum.firstIndex() + AttributesEnum.staticValues().length;
        }

        public static AttributesEnum[] staticValues() {
            if (vals == null) {
                vals = AttributesEnum.values();
            }
            return vals;
        }
    }
    public static final int DEPARTMENTID = AttributesEnum.DepartmentId.index();
    public static final int DEPARTMENTNAME = AttributesEnum.DepartmentName.index();
    public static final int MANAGERID = AttributesEnum.ManagerId.index();
    public static final int LOCATIONID = AttributesEnum.LocationId.index();
    public static final int EMPLOYEEEO = AttributesEnum.EmployeeEO.index();
    public static final int EMPLOYEEEO1 = AttributesEnum.EmployeeEO1.index();

    DataSecurityProviderManager _mDataSecurityMgr = null;

    /**
     * This is the default constructor (do not remove).
     */
    public DepartmentEOImpl() {
    }

    /**
     * Gets the attribute value for DepartmentId, using the alias name DepartmentId.
     * @return the value of DepartmentId
     */
    public Integer getDepartmentId() {
        return (Integer)getAttributeInternal(DEPARTMENTID);
    }

    /**
     * Sets <code>value</code> as the attribute value for DepartmentId.
     * @param value value to set the DepartmentId
     */
    public void setDepartmentId(Integer value) {
        setAttributeInternal(DEPARTMENTID, value);
    }

    /**
     * Gets the attribute value for DepartmentName, using the alias name DepartmentName.
     * @return the value of DepartmentName
     */
    public String getDepartmentName() {
        return (String)getAttributeInternal(DEPARTMENTNAME);
    }

    /**
     * Sets <code>value</code> as the attribute value for DepartmentName.
     * @param value value to set the DepartmentName
     */
    public void setDepartmentName(String value) {
        setAttributeInternal(DEPARTMENTNAME, value);
    }

    /**
     * Gets the attribute value for ManagerId, using the alias name ManagerId.
     * @return the value of ManagerId
     */
    public Integer getManagerId() {
        return (Integer)getAttributeInternal(MANAGERID);
    }

    /**
     * Sets <code>value</code> as the attribute value for ManagerId.
     * @param value value to set the ManagerId
     */
    public void setManagerId(Integer value) {
        setAttributeInternal(MANAGERID, value);
    }

    /**
     * Gets the attribute value for LocationId, using the alias name LocationId.
     * @return the value of LocationId
     */
    public Integer getLocationId() {
        return (Integer)getAttributeInternal(LOCATIONID);
    }

    /**
     * Sets <code>value</code> as the attribute value for LocationId.
     * @param value value to set the LocationId
     */
    public void setLocationId(Integer value) {
        setAttributeInternal(LOCATIONID, value);
    }

    /**
     * getAttrInvokeAccessor: generated method. Do not modify.
     * @param index the index identifying the attribute
     * @param attrDef the attribute

     * @return the attribute value
     * @throws Exception
     */
    protected Object getAttrInvokeAccessor(int index, AttributeDefImpl attrDef) throws Exception {
        if ((index >= AttributesEnum.firstIndex()) && (index < AttributesEnum.count())) {
            return AttributesEnum.staticValues()[index - AttributesEnum.firstIndex()].get(this);
        }
        return super.getAttrInvokeAccessor(index, attrDef);
    }

    /**
     * setAttrInvokeAccessor: generated method. Do not modify.
     * @param index the index identifying the attribute
     * @param value the value to assign to the attribute
     * @param attrDef the attribute

     * @throws Exception
     */
    protected void setAttrInvokeAccessor(int index, Object value, AttributeDefImpl attrDef) throws Exception {
        if ((index >= AttributesEnum.firstIndex()) && (index < AttributesEnum.count())) {
            AttributesEnum.staticValues()[index - AttributesEnum.firstIndex()].put(this, value);
            return;
        }
        super.setAttrInvokeAccessor(index, value, attrDef);
    }

    /**
     * @return the associated entity oracle.jbo.server.EntityImpl.
     */
    public EntityImpl getEmployeeEO() {
        return (EntityImpl)getAttributeInternal(EMPLOYEEEO);
    }

    /**
     * Sets <code>value</code> as the associated entity oracle.jbo.server.EntityImpl.
     */
    public void setEmployeeEO(EntityImpl value) {
        setAttributeInternal(EMPLOYEEEO, value);
    }

    /**
     * @return the associated entity oracle.jbo.RowIterator.
     */
    public RowIterator getEmployeeEO1() {
        return (RowIterator)getAttributeInternal(EMPLOYEEEO1);
    }

    /**
     * @param departmentId key constituent

     * @return a Key object based on given key constituents.
     */
    public static Key createPrimaryKey(Integer departmentId) {
        return new Key(new Object[] { departmentId });
    }

    /**
     * @return the definition object for this instance class.
     */
    public static synchronized EntityDefImpl getDefinitionObject() {
        return EntityDefImpl.findDefObject("com.packtpub.adfguide.ch14.model.entity.DepartmentEO");
    }

    @Override
    public boolean isAttributeUpdateable(int index) {
        DBTransactionImpl dbtransaction = (DBTransactionImpl)this.getDBTransaction();
        DataSecurityProvider provider = _getDataSecurityProvider();
        if (provider == null) {
            return super.isAttributeUpdateable(index);
        }
        EntityCache ec = getEntityCache();
        AttributeDefImpl attrDef = (AttributeDefImpl)ec.getAttributeDef(index);
        String key = attrDef.getName();
        BindingPermissionDef permDef = attrDef.getPermissionDef();
        String privToCheck = permDef == null ? null : permDef.findPrivilege(PermissionHelper.UPDATE_ACTION);
        //privToCheck is null if no security has been enabled on the entity attribute.
        //Note that Security is enabled by choosing the Edit
        //Security option on the attribute context menu in the Structure Window
        if (privToCheck == null) {
            return super.isAttributeUpdateable(index);
        }
        //check if attribute is new (insert case)
        if (getPostState() == STATUS_NEW || getPostState() == STATUS_INITIALIZED) {
            //build ResourcePermission
            //type = ADFEntityRow,  Action = update
            String type = "ADFEntityRow";
            String entityName = this.getEntityDef().getName();
            String action = "update";
            SecurityContext securityCtx = ADFContext.getCurrent().getSecurityContext();
            ResourcePermission resourcePermission = new ResourcePermission(type, entityName, action);
            boolean userHasPermission = securityCtx.hasPermission(resourcePermission);
            System.out.println(" userHasPermission: " + userHasPermission);
            if (userHasPermission) {
                return true;
            }
            return false;
        }
        return super.isAttributeUpdateable(index);

    }


    DataSecurityProvider _getDataSecurityProvider() {
        if (_mDataSecurityMgr == null) {
            DBTransactionImpl dbtransaction = (DBTransactionImpl)this.getDBTransaction();
            _mDataSecurityMgr = new DataSecurityProviderManager(dbtransaction);
        }
        return _mDataSecurityMgr.getDataSecurityProvider();
    }


}
