package model.emp.service;

import fmwk.extension.entity.GenericDataPersistanceService;
import fmwk.extension.view.GenericDataReadServiceInterface;
import fmwk.extension.view.GenericQueryModel;
import fmwk.extension.view.GenericRowCollection;
import fmwk.extension.view.GenericRowData;
import fmwk.extension.view.TransactionContext;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import oracle.adf.share.ADFContext;

import oracle.jbo.domain.Number;


/**
 * A custom data source implmentation for programmatic View and Entity Objects.
 * This demo class implmnets Read and Write contracts required by the ProgrammaticallyManagedViewObjectImpl and
 * ProgrammaticallyManagedEntityObjectImpl respectively
 */
public class MyEmpDataServiceImplementation implements GenericDataReadServiceInterface, GenericDataPersistanceService {
    public static final String EMPLOYEEID = "EmployeeId";
    public static final String FIRSTNAME = "FirstName";
    public static final String LASTNAME = "LastName";
    public static final String EMAIL = "Email";
    public static final String DEPARTMENTID = "DepartmentId";


    ArrayList<GenericRowData> dummyResultList = null;

    MyEmpDataServiceImplementation() {
        super();
        //Dummy data generation used for this example
        _generateDummyData();
    }

    /**
     * This demo caches the data source implmn at session level. I haven't tested this cahcing
     * startgey throughly so not fool prrof:) You can chnge it as per your runtime requirement
     * @return
     */
    public static synchronized MyEmpDataServiceImplementation getInstance() {
        MyEmpDataServiceImplementation vcImpl = null;
        ADFContext aDFContext = ADFContext.getCurrent();
        if (aDFContext.getSessionScope().get("SVC") == null) {
            vcImpl = new MyEmpDataServiceImplementation();
            aDFContext.getSessionScope().put("SVC", vcImpl);
        } else {
            vcImpl = (MyEmpDataServiceImplementation)aDFContext.getSessionScope().get("SVC");
        }
        return vcImpl;
    }

    /**
     * Gets data for queryModel
     * @param queryModel
     * @return
     */
    public GenericRowCollection executeServiceForCollection(GenericQueryModel queryModel) {
        int deptId = 10;
        Map filterPramValues = queryModel.getFilterPramValues();
        int size = queryModel.getPageSize();
        int startIndex = queryModel.getStartIndex();
        GenericRowCollection genColl = new GenericRowCollection();
        ArrayList<GenericRowData> filteerdResultList = new ArrayList<GenericRowData>();
        genColl.setRowCollection(filteerdResultList);
        if (size == 1 && startIndex == -1) {
            genColl.setQueryModel(queryModel);
            genColl.setRowCollection(dummyResultList);
        }
        Iterator<GenericRowData> iter = dummyResultList.iterator();
        while (iter.hasNext()) {
            GenericRowData data = iter.next();
            if (data.isQualified(filterPramValues)) {
                filteerdResultList.add(data);
            }
        }
        return genColl;
    }

    /**
     * Gets total row count for queryModel
     * @param queryModel
     * @return
     */
    public long getTotalRowCount(GenericQueryModel queryModel) {

        ArrayList<GenericRowData> filteerdResultList = new ArrayList<GenericRowData>();
        Map filterPramValues = queryModel.getFilterPramValues();
        long cnt = 0;
        Iterator<GenericRowData> iter = dummyResultList.iterator();
        while (iter.hasNext()) {
            GenericRowData data = iter.next();
            if (data.isQualified(filterPramValues)) {
                cnt++;
            }
        }
        log("Count:" + cnt);
        return cnt;
    }


    /**
     * Dummy data generation method
     */
    private void _generateDummyData() {

        int deptId = 10;
        int empID = 1000;
        dummyResultList = new ArrayList<GenericRowData>();
        for (int i = 0; i < 100; i++) {
            dummyResultList.add(getData(empID + i, deptId));
            if (i % 10 == 0)
                deptId += 10;
        }

    }

    private GenericRowData getData(int empId, int deptId) {
        Map k = new HashMap();
        Map m = new HashMap();
        m.put(EMPLOYEEID, new Number(empId));
        m.put(FIRSTNAME, "Fst Employee" + empId);
        m.put(LASTNAME, "Lst Employee" + empId);
        m.put(EMAIL, "employee" + empId + "@oracle.com"); //DEPARTMENTID
        m.put(DEPARTMENTID, new Number(deptId));
        GenericRowData data = new GenericRowData(m);
        return data;
    }

    /**
     * Delete logic for the object goes here
     * @param data
     */
    public void deleteObject(GenericRowData data) {
        log("deleteObject");
    }

    /**
     * Update logic for object goes here
     * @param data
     */
    public void updateObject(GenericRowData data) {
        log("updateObject");
    }

    /**
     * Creates logic for object goes here
     * @param data
     */
    public void createObject(GenericRowData data) {
        log("createObject");
    }

    public void lock(GenericRowData data) {
        log("lock");
    }

    public void doSelectRowNLock(GenericRowData data, boolean lock) {
        log("doSelectRowNLock");
    }

    /**
     * Hook foe After committing the txn.
     * This example does not implmenta this as it just demos with in memory data
     * @param tx
     */
    @Override
    public void afterCommit(TransactionContext tx) {
        log("afterCommit");
    }

    /**
     * Hook for After rolling back the txn
     * This example does not implmenta this as it just demos with in memory data
     * @param tx
     */
    @Override
    public void afterRollback(TransactionContext tx) {
        log("afterRollback");
    }

    /**
     * Hook for Before rolling back the txn
     * This example does not implmenta this as it just demos with in memory data
     * @param tx
     */
    @Override
    public void beforeRollback(TransactionContext tx) {
        log("beforeRollback");
    }

    /**
     * Hook for Before committing the txn
     * This example does not implmenta this as it just demos with in memory data
     * @param tx
     */
    @Override
    public void beforeCommit(TransactionContext tx) {
        log("beforeCommit");
    }

    /**
     * Validation logic goes here
     * This example does not implmenta this as it just demos with in memory data
     */
    @Override
    public void validate(GenericRowData data) {
        log("validate");
    }

    private void log(String msg) {
        System.out.println(msg);
    }

}
