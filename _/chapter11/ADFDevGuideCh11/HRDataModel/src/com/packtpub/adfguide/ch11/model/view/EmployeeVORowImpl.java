package com.packtpub.adfguide.ch11.model.view;

import com.packtpub.adfguide.ch11.model.common.EmailDomain;

import java.math.BigDecimal;

import oracle.jbo.RowIterator;
import oracle.jbo.domain.Timestamp;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.EntityImpl;
import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Wed Mar 28 08:48:20 IST 2012
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class EmployeeVORowImpl extends ViewRowImpl {
    public static final int ENTITY_EMPLOYEEEO = 0;

    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. Do not modify.
     */
    public enum AttributesEnum {
        EmployeeId {
            public Object get(EmployeeVORowImpl obj) {
                return obj.getEmployeeId();
            }

            public void put(EmployeeVORowImpl obj, Object value) {
                obj.setEmployeeId((Integer)value);
            }
        }
        ,
        FirstName {
            public Object get(EmployeeVORowImpl obj) {
                return obj.getFirstName();
            }

            public void put(EmployeeVORowImpl obj, Object value) {
                obj.setFirstName((String)value);
            }
        }
        ,
        LastName {
            public Object get(EmployeeVORowImpl obj) {
                return obj.getLastName();
            }

            public void put(EmployeeVORowImpl obj, Object value) {
                obj.setLastName((String)value);
            }
        }
        ,
        Email {
            public Object get(EmployeeVORowImpl obj) {
                return obj.getEmail();
            }

            public void put(EmployeeVORowImpl obj, Object value) {
                obj.setEmail((EmailDomain)value);
            }
        }
        ,
        PhoneNumber {
            public Object get(EmployeeVORowImpl obj) {
                return obj.getPhoneNumber();
            }

            public void put(EmployeeVORowImpl obj, Object value) {
                obj.setPhoneNumber((String)value);
            }
        }
        ,
        HireDate {
            public Object get(EmployeeVORowImpl obj) {
                return obj.getHireDate();
            }

            public void put(EmployeeVORowImpl obj, Object value) {
                obj.setHireDate((Timestamp)value);
            }
        }
        ,
        JobId {
            public Object get(EmployeeVORowImpl obj) {
                return obj.getJobId();
            }

            public void put(EmployeeVORowImpl obj, Object value) {
                obj.setJobId((String)value);
            }
        }
        ,
        Salary {
            public Object get(EmployeeVORowImpl obj) {
                return obj.getSalary();
            }

            public void put(EmployeeVORowImpl obj, Object value) {
                obj.setSalary((BigDecimal)value);
            }
        }
        ,
        CommissionPct {
            public Object get(EmployeeVORowImpl obj) {
                return obj.getCommissionPct();
            }

            public void put(EmployeeVORowImpl obj, Object value) {
                obj.setCommissionPct((BigDecimal)value);
            }
        }
        ,
        ManagerId {
            public Object get(EmployeeVORowImpl obj) {
                return obj.getManagerId();
            }

            public void put(EmployeeVORowImpl obj, Object value) {
                obj.setManagerId((Integer)value);
            }
        }
        ,
        DepartmentId {
            public Object get(EmployeeVORowImpl obj) {
                return obj.getDepartmentId();
            }

            public void put(EmployeeVORowImpl obj, Object value) {
                obj.setDepartmentId((Integer)value);
            }
        }
        ,
        DepartmentVO {
            public Object get(EmployeeVORowImpl obj) {
                return obj.getDepartmentVO();
            }

            public void put(EmployeeVORowImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ,
        EmployeeVO {
            public Object get(EmployeeVORowImpl obj) {
                return obj.getEmployeeVO();
            }

            public void put(EmployeeVORowImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ;
        private static AttributesEnum[] vals = null;
        private static int firstIndex = 0;

        public abstract Object get(EmployeeVORowImpl object);

        public abstract void put(EmployeeVORowImpl object, Object value);

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
    public static final int EMPLOYEEID = AttributesEnum.EmployeeId.index();
    public static final int FIRSTNAME = AttributesEnum.FirstName.index();
    public static final int LASTNAME = AttributesEnum.LastName.index();
    public static final int EMAIL = AttributesEnum.Email.index();
    public static final int PHONENUMBER = AttributesEnum.PhoneNumber.index();
    public static final int HIREDATE = AttributesEnum.HireDate.index();
    public static final int JOBID = AttributesEnum.JobId.index();
    public static final int SALARY = AttributesEnum.Salary.index();
    public static final int COMMISSIONPCT = AttributesEnum.CommissionPct.index();
    public static final int MANAGERID = AttributesEnum.ManagerId.index();
    public static final int DEPARTMENTID = AttributesEnum.DepartmentId.index();
    public static final int DEPARTMENTVO = AttributesEnum.DepartmentVO.index();
    public static final int EMPLOYEEVO = AttributesEnum.EmployeeVO.index();

    /**
     * This is the default constructor (do not remove).
     */
    public EmployeeVORowImpl() {
    }

    /**
     * Gets EmployeeEO entity object.
     * @return the EmployeeEO
     */
    public EntityImpl getEmployeeEO() {
        return (EntityImpl)getEntity(ENTITY_EMPLOYEEEO);
    }

    /**
     * Gets the attribute value for EMPLOYEE_ID using the alias name EmployeeId.
     * @return the EMPLOYEE_ID
     */
    public Integer getEmployeeId() {
        return (Integer) getAttributeInternal(EMPLOYEEID);
    }

    /**
     * Sets <code>value</code> as attribute value for EMPLOYEE_ID using the alias name EmployeeId.
     * @param value value to set the EMPLOYEE_ID
     */
    public void setEmployeeId(Integer value) {
        setAttributeInternal(EMPLOYEEID, value);
    }

    /**
     * Gets the attribute value for FIRST_NAME using the alias name FirstName.
     * @return the FIRST_NAME
     */
    public String getFirstName() {
        return (String) getAttributeInternal(FIRSTNAME);
    }

    /**
     * Sets <code>value</code> as attribute value for FIRST_NAME using the alias name FirstName.
     * @param value value to set the FIRST_NAME
     */
    public void setFirstName(String value) {
        setAttributeInternal(FIRSTNAME, value);
    }

    /**
     * Gets the attribute value for LAST_NAME using the alias name LastName.
     * @return the LAST_NAME
     */
    public String getLastName() {
        return (String) getAttributeInternal(LASTNAME);
    }

    /**
     * Sets <code>value</code> as attribute value for LAST_NAME using the alias name LastName.
     * @param value value to set the LAST_NAME
     */
    public void setLastName(String value) {
        setAttributeInternal(LASTNAME, value);
    }

    /**
     * Gets the attribute value for EMAIL using the alias name Email.
     * @return the EMAIL
     */
    public EmailDomain getEmail() {
        return (EmailDomain)getAttributeInternal(EMAIL);
    }

    /**
     * Sets <code>value</code> as attribute value for EMAIL using the alias name Email.
     * @param value value to set the EMAIL
     */
    public void setEmail(EmailDomain value) {
        setAttributeInternal(EMAIL, value);
    }

    /**
     * Gets the attribute value for PHONE_NUMBER using the alias name PhoneNumber.
     * @return the PHONE_NUMBER
     */
    public String getPhoneNumber() {
        return (String) getAttributeInternal(PHONENUMBER);
    }

    /**
     * Sets <code>value</code> as attribute value for PHONE_NUMBER using the alias name PhoneNumber.
     * @param value value to set the PHONE_NUMBER
     */
    public void setPhoneNumber(String value) {
        setAttributeInternal(PHONENUMBER, value);
    }

    /**
     * Gets the attribute value for HIRE_DATE using the alias name HireDate.
     * @return the HIRE_DATE
     */
    public Timestamp getHireDate() {
        return (Timestamp) getAttributeInternal(HIREDATE);
    }

    /**
     * Sets <code>value</code> as attribute value for HIRE_DATE using the alias name HireDate.
     * @param value value to set the HIRE_DATE
     */
    public void setHireDate(Timestamp value) {
        setAttributeInternal(HIREDATE, value);
    }

    /**
     * Gets the attribute value for JOB_ID using the alias name JobId.
     * @return the JOB_ID
     */
    public String getJobId() {
        return (String) getAttributeInternal(JOBID);
    }

    /**
     * Sets <code>value</code> as attribute value for JOB_ID using the alias name JobId.
     * @param value value to set the JOB_ID
     */
    public void setJobId(String value) {
        setAttributeInternal(JOBID, value);
    }

    /**
     * Gets the attribute value for SALARY using the alias name Salary.
     * @return the SALARY
     */
    public BigDecimal getSalary() {
        return (BigDecimal) getAttributeInternal(SALARY);
    }

    /**
     * Sets <code>value</code> as attribute value for SALARY using the alias name Salary.
     * @param value value to set the SALARY
     */
    public void setSalary(BigDecimal value) {
        setAttributeInternal(SALARY, value);
    }

    /**
     * Gets the attribute value for COMMISSION_PCT using the alias name CommissionPct.
     * @return the COMMISSION_PCT
     */
    public BigDecimal getCommissionPct() {
        return (BigDecimal) getAttributeInternal(COMMISSIONPCT);
    }

    /**
     * Sets <code>value</code> as attribute value for COMMISSION_PCT using the alias name CommissionPct.
     * @param value value to set the COMMISSION_PCT
     */
    public void setCommissionPct(BigDecimal value) {
        setAttributeInternal(COMMISSIONPCT, value);
    }

    /**
     * Gets the attribute value for MANAGER_ID using the alias name ManagerId.
     * @return the MANAGER_ID
     */
    public Integer getManagerId() {
        return (Integer) getAttributeInternal(MANAGERID);
    }

    /**
     * Sets <code>value</code> as attribute value for MANAGER_ID using the alias name ManagerId.
     * @param value value to set the MANAGER_ID
     */
    public void setManagerId(Integer value) {
        setAttributeInternal(MANAGERID, value);
    }

    /**
     * Gets the attribute value for DEPARTMENT_ID using the alias name DepartmentId.
     * @return the DEPARTMENT_ID
     */
    public Integer getDepartmentId() {
        return (Integer) getAttributeInternal(DEPARTMENTID);
    }

    /**
     * Sets <code>value</code> as attribute value for DEPARTMENT_ID using the alias name DepartmentId.
     * @param value value to set the DEPARTMENT_ID
     */
    public void setDepartmentId(Integer value) {
        setAttributeInternal(DEPARTMENTID, value);
    }

    /**
     * Gets the associated <code>RowIterator</code> using master-detail link DepartmentVO.
     */
    public RowIterator getDepartmentVO() {
        return (RowIterator)getAttributeInternal(DEPARTMENTVO);
    }

    /**
     * Gets the associated <code>RowIterator</code> using master-detail link EmployeeVO.
     */
    public RowIterator getEmployeeVO() {
        return (RowIterator)getAttributeInternal(EMPLOYEEVO);
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
}
