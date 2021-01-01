package fmwk.extension.view;

import java.sql.ResultSet;

import java.util.HashMap;
import java.util.Map;

import oracle.jbo.AttributeDef;
import oracle.jbo.Row;
import oracle.jbo.Variable;
import oracle.jbo.ViewObject;
import oracle.jbo.server.AssociationDefImpl;
import oracle.jbo.server.QueryCollection;
import oracle.jbo.server.ViewDefImpl;
import oracle.jbo.server.ViewLinkDefImpl;
import oracle.jbo.server.ViewObjectImpl;
import oracle.jbo.server.ViewRowImpl;
import oracle.jbo.server.ViewRowSetImpl;


/**
 * Programmatically mqanged ViewObject. This is a generic base class abstracting the
 * base implemntation from subclasses
 *
 */
public abstract class ProgrammaticallyManagedViewObjectImpl extends ViewObjectImpl {

    private boolean inExecuteEmptyRowSet = false;
    private boolean initialized = false;
    /*
      * Used by overridden createViewLinkAccessorRS() method to help the
      * destination view object know what view link definition connects
      * it to the view link accessor rowsets parent.
      */
    private ViewLinkDefImpl viewLinkDefImpl;
    Map<String, String> bindVariableToAttributeNameMapping = null;

    public ProgrammaticallyManagedViewObjectImpl(String string, ViewDefImpl viewDefImpl) {
        super(string, viewDefImpl);
    }

    public ProgrammaticallyManagedViewObjectImpl() {
        super();
    }

    /**
     * This is overridden to control the execution in executeQueryForCollection trigged from
     * executeEmptyRowSet()
     * Reference : Steve Muench's exmaple
     */
    @Override
    public void executeEmptyRowSet() {
        try {
            inExecuteEmptyRowSet = true;
            super.executeEmptyRowSet();
        } finally {
            inExecuteEmptyRowSet = false;
        }

    }

    private boolean performingExecuteEmptyRowSet(QueryCollection qc) {
        return inExecuteEmptyRowSet;
    }

    /**
     * Gets the bind variable to attibute name mapping. Usefule to identify the
     * right logical comparison in a programmatic VO whther there is no SQL :)
     * Reference : Steve Muench's exmaple
     * @return
     */
    protected Map<String, String> getBindVariableToAttributeNameMapping() {

        if (bindVariableToAttributeNameMapping == null) {
            bindVariableToAttributeNameMapping = new HashMap<String, String>();
            Variable[] variables = ensureVariableManager().getVariables();
            if (variables != null && variables.length > 0) {
                for (Variable v : variables) {
                    Object propVal = v.getProperty("MapToAttribute");
                    if (propVal != null) {
                        bindVariableToAttributeNameMapping.put(v.getName(), (String)propVal);
                    }
                }
            }
        }
        return bindVariableToAttributeNameMapping;
    }

    private void initialize() {
        setManageRowsByKey(true);
        bindVariableToAttributeNameMapping = getBindVariableToAttributeNameMapping();
    }

    void setViewLinkDefImpl(ViewLinkDefImpl vldef) {
        viewLinkDefImpl = vldef;
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
    @Override
    protected void executeQueryForCollection(Object qc, Object[] params, int noUserParams) {
        if (!initialized) {
            initialize();
            initialized = true;
        }

        super.executeQueryForCollection(qc, params, noUserParams);
        // When executeEmptyRowSet() is called executeQueryForCollection()
        // will be invoked. In that case, skip the custom processing here.
        if (!performingExecuteEmptyRowSet((QueryCollection)qc)) {
            if (!((QueryCollection)qc).getRowSetImpl().isFetchComplete()) {

                GenericRowCollection rowCollection =
                    executeServiceForCollection(new QueryModelAdaptor(this, (QueryCollection)qc, params,
                                                                      noUserParams).getQueryModel());
                this.setUserDataForCollection(qc, rowCollection);
            }
        }
    }


    /**
     * Overridden framework method
     *
     * The framework calls this method to support the hasNext() method on
     * the rowset iterator for a rowset created from this view object.
     * We return true if our fetchPosition is still less than the rows in
     * our in-memory data arrays
     *
     * @param rowset The current query collection based on this view object
     * @return  true if there are more rows still to fetch.
     */
    @Override
    protected boolean hasNextForCollection(Object qc) {
        boolean bRet = false;
        GenericRowCollection rowColl = ((GenericRowCollection)getUserDataForCollection(qc));
        if (rowColl != null)
            bRet = rowColl.hasNext();
        if (!bRet) {
            setFetchCompleteForCollection(qc, true);
        }
        log("  HasNextForCollection " + bRet);
        return bRet;
    }

    /**
     * Overridden framework method.
     *
     * Populates the "fetched" data for one row when the framework asks us to.
     * We get the data from the "codes" array and the "descriptions" array
     * to populate the first (position 0) and second attribute slots in the
     * view object row. We ignore the resultSet passed in which will be null
     * since there is no real query going on here to get the data.
     *
     * @param rowset The current query collection based on this view object
     * @param rs The JDBC result set being used to fetch data from
     * @return Next view row fetched from this rowset
     */
    @Override
    protected ViewRowImpl createRowFromResultSet(Object qc, ResultSet resultSet) {
        GenericRowCollection rowColl = ((GenericRowCollection)getUserDataForCollection(qc));
        if (rowColl != null) {
            if (rowColl.hasNext()) {
                ViewRowImpl r = createNewRowForCollection(qc);
                GenericRowData values = rowColl.next();
                if (values != null && values.getDataMap() != null) {
                    for (Object k : values.getDataMap().keySet()) {
                        AttributeDef adef = r.findAttributeDef((String)k);
                        if (adef != null) {
                            populateAttributeForRow(r, adef.getIndex(), values.getDataMap().get(k));
                        }

                    }
                }
                return r;
            }
        }
        return null;
    }

    @Override
    public long getQueryHitCount(ViewRowSetImpl viewRowSet) {
        return getQueryHitCount(viewRowSet, null);
    }

    @Override
    public long getQueryHitCount(ViewRowSetImpl viewRowSet, Row[] masterRows) {

        getQuery(); // make sure the row filter is built
        //call return getRowCount() if you want the framework to return size() of the Collection from
        //third party data source
        return getService().getTotalRowCount((new QueryModelAdaptor(this, viewRowSet).getQueryModel()));

    }

    /**
     * Overrode to  help the destination view object know what view link definition connects
     * @param assocDef
     * @param accessorVO
     * @param masterRow
     * @param values
     * @return
     */
    @Override
    protected ViewRowSetImpl createViewLinkAccessorRS(AssociationDefImpl assocDef, ViewObjectImpl accessorVO,
                                                      Row masterRow, Object[] values) {
        ViewRowSetImpl ret = super.createViewLinkAccessorRS(assocDef, accessorVO, masterRow, values);
        ViewLinkDefImpl vldef = (ViewLinkDefImpl)assocDef.getAssociation();
        ViewObject vo = ret.getViewObject();
        if (vo instanceof ProgrammaticallyManagedViewObjectImpl) {
            ((ProgrammaticallyManagedViewObjectImpl)vo).setViewLinkDefImpl(vldef);
        }
        return ret;
    }

    String getFilterAttributeNameToUse(String attrName) {
        String remappedName = null;
        if (bindVariableToAttributeNameMapping != null) {
            remappedName = bindVariableToAttributeNameMapping.get(attrName);
        }
        return remappedName != null ? remappedName : attrName;
    }

    /**
     * Delgates the executeQueryForCollection call to custom data source service
     * @param queryModel
     * @return
     */
    protected GenericRowCollection executeServiceForCollection(GenericQueryModel queryModel) {
        return getService().executeServiceForCollection(queryModel);
    }

    /**
     * Sub lcasses may need to override this bu supplying its  own GenericDataReadServiceInterface
     * implmentation
     * @return
     */
    public abstract GenericDataReadServiceInterface getService();


    protected void log(String msg) {
        System.out.println(msg);
    }

    /**
     * This method executes a count query and returns the number of rows
     * that could end up in the rowset.
     */
    public long getCappedQueryHitCount(ViewRowSetImpl viewRowSet, Row[] masterRows, long oldCap, long cap) {
        return this.getQueryHitCount(viewRowSet, masterRows);
    }
}

