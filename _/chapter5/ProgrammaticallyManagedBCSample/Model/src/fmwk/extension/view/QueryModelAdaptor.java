package fmwk.extension.view;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import oracle.jbo.Key;
import oracle.jbo.ViewCriteria;
import oracle.jbo.ViewCriteriaItem;
import oracle.jbo.ViewCriteriaManager;
import oracle.jbo.ViewCriteriaRow;
import oracle.jbo.ViewLink;
import oracle.jbo.common.JboCompOper;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.QueryCollection;
import oracle.jbo.server.RowFilter;
import oracle.jbo.server.RowFilterKey;
import oracle.jbo.server.ViewLinkDefImpl;
import oracle.jbo.server.ViewLinkImpl;
import oracle.jbo.server.ViewRowSetImpl;


/**
 * An adpator to build a generic query model for third party services to retrive data
 */
public class QueryModelAdaptor {

    private GenericQueryModel queryModel = new GenericQueryModel();
    private QueryCollection qc;
    private ProgrammaticallyManagedViewObjectImpl vo;
    private ViewLinkDefImpl viewLinkDefImpl;
    /**
     * This is usefule when GenericQueryModel is constructed from executeQueryForCollection
     * @param sourceVO
     * @param qc
     * @param params
     * @param noUserParams
     */
    public QueryModelAdaptor(ProgrammaticallyManagedViewObjectImpl sourceVO, QueryCollection qc, Object[] params,
                             int noUserParams) {
        if (qc != null) {
            queryModel.setPageSize(qc.getRowSetImpl().getRangeSize());
            queryModel.setStartIndex(qc.getRowSetImpl().getRangeStart());

        }
        vo = sourceVO;
        queryModel.setAccessMode(vo.getAccessMode());
        queryModel.setFilterPramValues(buildFilterCriteria(qc, params, noUserParams));
    }
    /**
     * This is usefule when GenericQueryModel is constructed from getQueryHitCount
     * @param sourceVO
     * @param rowset
     */
    public QueryModelAdaptor(ProgrammaticallyManagedViewObjectImpl sourceVO, ViewRowSetImpl rowset) {

        vo = sourceVO;
        queryModel.setAccessMode(vo.getAccessMode());
        queryModel.setFilterPramValues(buildFilterCriteria(rowset));
    }

    public GenericQueryModel getQueryModel() {
        return queryModel;
    }
    
    /**
     * Build the filter filter criteria map which can be used later by the third party
     * service to filter the data. This is used for   row count query
     * @param rowset
     * @return
     */
    private Map<String, Object> buildFilterCriteria(ViewRowSetImpl rowset) {

        Map<String, Object> filter = new HashMap<String, Object>();
        RowFilter rowFilter = rowset.getQueryCollection().getRowFilter();
        if (rowFilter instanceof RowFilterKey) {
            Key key = ((RowFilterKey)rowFilter).getKey();
            if (key != null && key.getAttributeCount() > 0) {
                AttributeDefImpl[] attrDefImpls = null;
                if (viewLinkDefImpl != null) {
                    attrDefImpls = viewLinkDefImpl.getDestinationEnd().getAttributeDefImpls();
                } else {

                    ViewLink[] viewlinks = vo.getViewLinks();
                    if (viewlinks != null) {
                        for (ViewLink vl : viewlinks) {
                            if (vl.getDestination() == vo) {
                                ViewLinkImpl vli = (ViewLinkImpl)vl;
                                ViewLinkDefImpl vlDef = vli.getViewLinkDef();
                                attrDefImpls = vlDef.getDestinationEnd().getAttributeDefImpls();
                                break;
                            }
                        }
                    }
                }
                if (attrDefImpls != null) {
                    filter = new HashMap<String, Object>(attrDefImpls.length);
                    int attrSlot = 0;
                    for (AttributeDefImpl attrDef : attrDefImpls) {
                        Object keyValue = key.getAttribute(attrSlot++);
                        filter.put(vo.getFilterAttributeNameToUse(attrDef.getName()), keyValue);
                    }
                }
            }
        }
        ViewCriteriaManager vcm = rowset.getViewObject().getViewCriteriaManager();
        String[] vcNames = vcm.getApplyViewCriteriaNames();

        if (vcNames != null && vcNames.length > 0) {
            for (String vcName : vcNames) {
                ViewCriteria vc = vcm.getViewCriteria(vcName);
                vc.reset();
                while (vc.hasNext()) {
                    ViewCriteriaRow vcr = (ViewCriteriaRow)vc.next();
                    List<ViewCriteriaItem> vcis = vcr.getCriteriaItems();
                    for (ViewCriteriaItem vci : vcis) {
                        String oper = vci.getOperator();
                        if ((JboCompOper.OPER_EQ.equals(oper) || JboCompOper.OPER_LIKE.equals(oper)
                             ||JboCompOper.OPER_STARTS_WITH.equals(oper)) &&
                            vci.getValueCount() == 1) {
                            String paramName = vci.getAttributeDef().getName();
                            Object paramValue = vci.getValue(0);
                            if (filter == null) {
                                filter = new HashMap<String, Object>();
                            }
                            filter.put(paramName, paramValue);
                        }

                    }

                }
            }
        }
        return filter;

    }
   
   /**
     * Build the filter filter criteria map which can be used later by the third party
     * service to filter the data. This is used to delegate the call from executeQueryForCollection
     * Reference :  Steve Muench's exmaple
     * @param qc
     * @param params
     * @param noUserParams
     * @return
     */
    private Map<String, Object> buildFilterCriteria(QueryCollection qc, Object[] params, int noUserParams) {
        Map<String, Object> filter = null;
        if (params != null && params.length > 0) {
            filter = new HashMap<String, Object>(params.length);
         /*
          * First hand any user-defined parameters
          */
            if (noUserParams > 0) {
                for (int z = 0; z < noUserParams; z++) {
                    String paramName = null;
                    Object paramValue = null;
                    if (params[z] instanceof Object[]) {
                        Object[] paramObjArr = (Object[])params[z];
                        if (paramObjArr.length == 2 && paramObjArr[0] instanceof String) {
                            paramName = (String)paramObjArr[0];
                            paramValue = paramObjArr[1];
                        }
                    }
                    if (paramName != null && paramValue != null) {
                        filter.put(vo.getFilterAttributeNameToUse(paramName), paramValue);
                    }
                }
            }
            /*
          * Then, handle any viewlink related parameters the system has added
          */
            RowFilter rowFilter = ((QueryCollection)qc).getRowFilter();
            if (rowFilter instanceof RowFilterKey) {
                Key key = ((RowFilterKey)rowFilter).getKey();
                if (key != null && key.getAttributeCount() > 0) {
                    AttributeDefImpl[] attrDefImpls = null;
                    if (viewLinkDefImpl != null) {
                        attrDefImpls = viewLinkDefImpl.getDestinationEnd().getAttributeDefImpls();
                    } else {

                        ViewLink[] viewlinks = vo.getViewLinks();
                        if (viewlinks != null) {
                            for (ViewLink vl : viewlinks) {
                                if (vl.getDestination() == vo) {
                                    ViewLinkImpl vli = (ViewLinkImpl)vl;
                                    ViewLinkDefImpl vlDef = vli.getViewLinkDef();
                                    attrDefImpls = vlDef.getDestinationEnd().getAttributeDefImpls();
                                    break;
                                }
                            }
                        }
                    }
                    if (attrDefImpls != null) {
                        filter = new HashMap<String, Object>(attrDefImpls.length);
                        int attrSlot = 0;
                        for (AttributeDefImpl attrDef : attrDefImpls) {
                            Object keyValue = key.getAttribute(attrSlot++);
                            filter.put(vo.getFilterAttributeNameToUse(attrDef.getName()), keyValue);
                        }
                    }
                }
            }
        }
        /*
      * Then handle any view criteria
      */
        ViewCriteriaManager vcm = qc.getRowSetImpl().getViewObject().getViewCriteriaManager();
        String[] vcNames = vcm.getApplyViewCriteriaNames();
        if (vcNames != null && vcNames.length > 0) {
            for (String vcName : vcNames) {
                ViewCriteria vc = vcm.getViewCriteria(vcName);
                vc.reset();
                while (vc.hasNext()) {
                    ViewCriteriaRow vcr = (ViewCriteriaRow)vc.next();
                    List<ViewCriteriaItem> vcis = vcr.getCriteriaItems();
                    for (ViewCriteriaItem vci : vcis) {
                        String oper = vci.getOperator();
                        if ((JboCompOper.OPER_EQ.equals(oper) || JboCompOper.OPER_LIKE.equals(oper)) &&
                            vci.getValueCount() == 1) {
                            String paramName = vci.getAttributeDef().getName();
                            Object paramValue = vci.getValue(0);
                            if (filter == null) {
                                filter = new HashMap<String, Object>();
                            }
                            filter.put(paramName, paramValue);
                        }

                    }

                }
            }
        }

        return filter;
    }
}
