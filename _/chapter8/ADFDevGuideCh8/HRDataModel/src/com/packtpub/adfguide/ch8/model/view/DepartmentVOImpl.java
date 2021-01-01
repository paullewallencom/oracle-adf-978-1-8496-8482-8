package com.packtpub.adfguide.ch8.model.view;


import oracle.jbo.AttributeHints;
import oracle.jbo.Row;
import oracle.jbo.VariableValueManager;
import oracle.jbo.ViewCriteria;
import oracle.jbo.ViewCriteriaItem;
import oracle.jbo.ViewCriteriaManager;
import oracle.jbo.server.AssociationDefImpl;
import oracle.jbo.server.ViewObjectImpl;
import oracle.jbo.server.ViewRowSetImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Sat Jan 14 07:12:08 IST 2012
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
     * Returns the variable value for bindVarDeptName.
     * @return variable value for bindVarDeptName
     */
    public String getbindVarDeptName() {
        return (String)ensureVariableManager().getVariableValue("bindVarDeptName");
    }

    /**
     * Sets <code>value</code> for variable bindVarDeptName.
     * @param value value to bind as bindVarDeptName
     */
    public void setbindVarDeptName(String value) {
        ensureVariableManager().setVariableValue("bindVarDeptName", value);
    }


    /**
     * Returns the variable value for bindVarLocId.
     * @return variable value for bindVarLocId
     */
    public String getbindVarLocId() {
        return (String)ensureVariableManager().getVariableValue("bindVarLocId");
    }

    /**
     * Sets <code>value</code> for variable bindVarLocId.
     * @param value value to bind as bindVarLocId
     */
    public void setbindVarLocId(String value) {
        ensureVariableManager().setVariableValue("bindVarLocId", value);
    }

    /**
     * This method override the runtime display of criteria items that appear inside
     * a query component. By default it returns null. Subclasses may override to return
     * custom AttributeHints implementation for the given criteria item.
     */
    @Override
    public AttributeHints getCriteriaItemAttributeHints(ViewCriteriaItem vci) {
        if (vci != null && vci.getAttributeDef().getName().equals("DepartmentName")) {
            CustomCriteriaAttrHints attrHints = new CustomCriteriaAttrHints(vci);
            return attrHints;
        }
        return super.getCriteriaItemAttributeHints(vci);
    }

    /**
     * This method is called by framework to create view link accessor for associated detail view objects
     */
    @Override
    protected ViewRowSetImpl createViewLinkAccessorRS(AssociationDefImpl associationDefImpl, ViewObjectImpl accessorVO,
                                                      Row parentRow, Object[] object) {
        //Creste View Link Accessor for deatil VO that is linked through view link
        ViewRowSetImpl viewRowSetImpl =
            super.createViewLinkAccessorRS(associationDefImpl, accessorVO, parentRow, object);

        //Get the View Criteria defined on Deatil VO and pass bind paremeter values
        //This will be used when frameowrk later executes viewRowSetImpl
        ViewCriteriaManager vcm = accessorVO.getViewCriteriaManager();
        ViewCriteria vc = vcm.getViewCriteria("EmployeeViewCriteria");
        VariableValueManager vvm = vc.ensureVariableManager();
        vvm.setVariableValue("bindVarFirstName", getbindVarFirstName());
        accessorVO.applyViewCriteria(vc);

        return viewRowSetImpl;
    }


    /**
     * Returns the variable value for bindVarFirstName.
     * @return variable value for bindVarFirstName
     */
    public String getbindVarFirstName() {
        return (String)ensureVariableManager().getVariableValue("bindVarFirstName");
    }

    /**
     * Sets <code>value</code> for variable bindVarFirstName.
     * @param value value to bind as bindVarFirstName
     */
    public void setbindVarFirstName(String value) {
        ensureVariableManager().setVariableValue("bindVarFirstName", value);
    }

    /**
     * This method is invoked right before the row set executes the
     * query.  If this method is overridden, the custom logic
     * will be applied to all row sets.
     *
     * <p>
     * In contrast, if the user overrides the view object's
     * executeQuery(), the custom logic in it only applies only
     * when the user calls executeQuery() on the view object.
     * If he calls executeQuery() on secondary row sets, the
     * custom logic in executeQuery() will not apply.
     *
     * @param qc  the query collection about to execute the query.
     * @param params  the bind parameters that will be applied to the query.
     * @param noUserParams  the number of user bind parameters supplied
     *                      through the setWhereClauseParam calls.
     */
    protected void executeQueryForCollection(Object qc, Object[] params, int noUserParams) {
        super.executeQueryForCollection(qc, params, noUserParams);
    }


}