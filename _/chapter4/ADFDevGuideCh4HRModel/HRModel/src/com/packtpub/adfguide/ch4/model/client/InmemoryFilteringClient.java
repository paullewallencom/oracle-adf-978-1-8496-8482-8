package com.packtpub.adfguide.ch4.model.client;

import oracle.adf.share.ADFContext;

import oracle.jbo.*;
import oracle.jbo.client.Configuration;
import oracle.jbo.common.JboCompOper;
import oracle.jbo.domain.*;
import oracle.jbo.domain.Number;


public class InmemoryFilteringClient {
    public InmemoryFilteringClient() {
        super();
    }

    public static void main(String[] args) {
        String amDef = "com.packtpub.adfguide.ch4.model.service.HRServiceAppModule";
        String config = "HRServiceAppModuleLocal";
        ApplicationModule am = Configuration.createRootApplicationModule(amDef, config);
        filterInMemoryWithoutAffetingDefaultRowset(am);
        // Work with your appmodule and view object here
        Configuration.releaseRootApplicationModule(am, true);
    }

    private static void filterUsingRowMatch(ApplicationModule am) {
        ViewObject vo = am.findViewObject("Employees");
        vo.executeQuery();
        showRows(vo, "Initial database results");

        Row row = vo.getCurrentRow();

        RowMatch rm = new RowMatch();
        rm.setWhereClause("FirstName = 'William'");

        if (rm.rowQualifies(row)) {
            System.out.println("++++++++++++++++++++ We have a row whose FirstName = William  ++++++++++++++++");
        }
        rm = new RowMatch(); //("FirstName = 'William'");
        rm.setWhereClause("UPPER(FirstName) = UPPER(:bvFirstName)");
        ViewObject ownerVO = (ViewObject)row.getStructureDef();
        ownerVO.getVariableManager().setVariableValue("bvFirstName", "William");
        if (rm.rowQualifies(row)) {
            System.out.println("++++++++++++++++++++ We have a row whose FirstName = William  ++++++++++++++++");
        }
        markOddRowsForOperation(vo);
        rm = new RowMatch("MarkedForOperation = true");
        vo.setRowMatch(rm);
        // vo.setQueryMode(ViewObject.QUERY_MODE_SCAN_VIEW_ROWS);
        vo.executeQuery();
        showRows(vo, "After marking odd rows");

        vo.setWhereClause(" EmployeeEO.LAST_NAME = :bvLastName or ( EmployeeEO.FIRST_NAME like 'A%' and  EmployeeEO.LAST_NAME like 'K%')");
        vo.defineNamedWhereClauseParam("bvLastName", null, null);
        rm = new RowMatch("LastName = :bvLastName or (FirstName like 'A%' and LastName like 'K%')");
        vo.setRowMatch(rm);
        vo.getVariableManager().setVariableValue("bvLastName", "Grant");
        vo.executeQuery();
        vo.setAssociationConsistent(true);

        showRows(vo, "After in-memory filtering with more complex expression");
        vo.setRowMatch(null);
        vo.setQueryMode(ViewObject.QUERY_MODE_SCAN_DATABASE_TABLES);
        vo.executeQuery();
        showRows(vo, "After re-querying to see a full list again");
    }

    private static void filterUsingVC(ApplicationModule am) {
        ViewObject vo = am.findViewObject("Employees");
        ADFContext aDFContext = ADFContext.getCurrent();

        // Show employees with a last name starting with a 'M'
        ViewCriteria vc = vo.createViewCriteria();
        ViewCriteriaRow vcr1 = vc.createViewCriteriaRow();
        vcr1.setAttribute("LastName", "LIKE 'P%'");
        vo.applyViewCriteria(vc);
        vo.executeQuery();
        vc.add(vcr1);
        vo.executeQuery();
        showRows(vo, "Initial database results with applied view criteria");

        // Subset results in memory to those with first name starting with 'S'

        ViewCriteriaRow vcr2 = vc.createViewCriteriaRow();
        vcr2.setAttribute("FirstName", "LIKE 'S%'");
        vcr2.setConjunction(ViewCriteriaRow.VC_CONJ_AND);
        vc.setCriteriaMode(ViewCriteria.CRITERIA_MODE_CACHE);
        vc.add(vcr2);
        vo.executeQuery();
        showRows(vo, "After augmenting view criteria and applying in-memory");

        // Set conjuction back to OR and re-apply to database query to find
        // customers with last name like 'H%' or first name like 'S%'
        vc.setCriteriaMode(ViewCriteria.CRITERIA_MODE_QUERY);
        vo.setQueryMode(ViewObject.QUERY_MODE_SCAN_DATABASE_TABLES);
        vcr2.setConjunction(ViewCriteriaRow.VC_CONJ_OR);
        vo.executeQuery();
        showRows(vo, "After changing view criteria and applying to database again");

        // Define new critera to find customers with first or last name like '%o%'
        ViewCriteria nameContainsO = vo.createViewCriteria();
        ViewCriteriaRow lastContainsO = nameContainsO.createViewCriteriaRow();
        lastContainsO.setAttribute("LastName", "LIKE '%o%'");
        ViewCriteriaRow firstContainsO = nameContainsO.createViewCriteriaRow();
        firstContainsO.setAttribute("FirstName", "LIKE '%o%'");
        nameContainsO.add(firstContainsO);
        nameContainsO.add(lastContainsO);
        nameContainsO.setCriteriaMode(ViewCriteria.CRITERIA_MODE_CACHE);

        // Use new criteria in memory find new rowset rather than subsetting
        RowSet rs = (RowSet)vo.findByViewCriteria(nameContainsO, -1, ViewObject.QUERY_MODE_SCAN_VIEW_ROWS);
        //showRows(rs,"Rows returned from in-memory findByViewCriteria");
        showRows(vo, "Note findByViewCriteria didn't change rows in the view");
    }

    private static void filterUsingVCQBEWithMulitpleConditions(ApplicationModule appMod) {
        // Create and populate criteria rows to support query-by-example.
        ViewObject empView = appMod.findViewObject("Employees");
        // Show employees with JobId=IT_PROG and DepartmentId <> 60
        ViewCriteria vc = empView.createViewCriteria();
        ViewCriteriaRow vcRow1 = vc.createViewCriteriaRow();
        vcRow1.setAttribute("JobId", "IT_PROG");
        vc.addElement(vcRow1);

        ViewCriteriaRow vcRow2 = vc.createViewCriteriaRow();
        vcRow2.setAttribute("DepartmentId", "= 10");
        vcRow2.setConjunction(ViewCriteriaRow.VC_CONJ_AND | ViewCriteriaRow.VC_CONJ_NOT);
        vc.addElement(vcRow2);
        empView.applyViewCriteria(vc);
        empView.executeQuery();

    }

    private static void filterUsingVCWithMulitpleConditions(ApplicationModule am) {
        ViewObject vo = am.findViewObject("Employees");

        // Show employees with JobId=IT_PROG and DepartmentId <> 60
        ViewCriteria vc = vo.createViewCriteria();
        vc.setConjunction(ViewCriteria.VC_CONJ_OR);
        ViewCriteriaRow vcr1 = vc.createViewCriteriaRow();
        vcr1.setConjunction(ViewCriteriaRow.VC_CONJ_OR);
        ViewCriteriaItem vci11 = vcr1.ensureCriteriaItem("JobId");
        vci11.setOperator(JboCompOper.OPER_EQ);
        vci11.setValue("IT_PROG");
        vc.insertRow(vcr1);

        ViewCriteriaRow vcr2 = vc.createViewCriteriaRow();
        vcr2.setConjunction(ViewCriteriaRow.VC_CONJ_OR);
        ViewCriteriaItem vci21 = vcr2.ensureCriteriaItem("DepartmentId");
        vci21.setOperator(JboCompOper.OPER_EQ);
        vci21.setValue("60");
        vcr2.setConjunction(vcr2.VC_CONJ_NOT | vcr2.VC_CONJ_OR);
        vc.addElement(vcr2);

        vo.applyViewCriteria(vc);
        vo.executeQuery();

        showRows(vo, "Initial database results with applied view criteria");


    }

    private static void filterInMemoryWithoutAffetingDefaultRowset(ApplicationModule am) {
        ViewObject vo = am.findViewObject("Countries");
        vo.executeQuery();
        showRows(vo, "Print All rows");
        //Define VC for in-memroy filtering
        ViewCriteria countryStartsWithA = vo.createViewCriteria();
        countryStartsWithA.setCriteriaMode(ViewCriteria.CRITERIA_MODE_CACHE);
        ViewCriteriaRow vcr1 = countryStartsWithA.createViewCriteriaRow();
        vcr1.setAttribute("CountryName", "LIKE A%");
        countryStartsWithA.add(vcr1);
        //Set In memory VC mode
        countryStartsWithA.setCriteriaMode(ViewCriteria.CRITERIA_MODE_CACHE);
        //Perfrom in-memory filter and get new row set
        RowSet rs = (RowSet)vo.findByViewCriteria(countryStartsWithA, -1, ViewObject.QUERY_MODE_SCAN_VIEW_ROWS);
        showRows(rs,"After Filtering");
        showRows(vo, "Print All rows");
    }

    private static void showRows(RowSet vo, String comment) {
        System.out.println("+++++++++++ " + comment + " ++++++++++++");
        vo.reset();
        while (vo.hasNext()) {
            Row r = vo.next();
            System.out.println("Row -" + r.getAttribute(0) + " " + r.getAttribute(1));
        }
    }
   
    private static void markOddRowsForOperation(ViewObject vo) {
        vo.reset();
        while (vo.hasNext()) {
            Row r = vo.next();
            if (vo.getCurrentRowIndex() % 2 == 1) {
                r.setAttribute("MarkedForOperation", Boolean.TRUE);
            }
        }
    }
}
