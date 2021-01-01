package com.packtpub.adfguide.ch4.model.client;

import com.packtpub.adfguide.ch4.model.view.MarketingEmployeeGenericVORowImpl;
import com.packtpub.adfguide.ch4.model.view.MarketingEmployeeListVOImpl;

import com.packtpub.adfguide.ch4.model.view.MarketingEmployeeListVORowImpl;

import oracle.jbo.ApplicationModule;
import oracle.jbo.Key;
import oracle.jbo.NameValuePairs;
import oracle.jbo.Row;
import oracle.jbo.RowIterator;
import oracle.jbo.ViewObject;
import oracle.jbo.client.Configuration;

public class CRUDOperationClient {
    public CRUDOperationClient() {
        super();
    }

    public static void main(String[] args) {
        String amDef = "com.packtpub.adfguide.ch4.model.service.HRServiceAppModule";
        String config = "HRServiceAppModuleLocal";
        ApplicationModule am = Configuration.createRootApplicationModule(amDef, config);
        createNewCountry(am);
        // Work with your appmodule and view object here
        Configuration.releaseRootApplicationModule(am, true);
    }
    /**
     *
     * @param am
     */
    private static void createNewCountry(ApplicationModule am) {
        ViewObject countries = am.findViewObject("Countries");
        Row row = countries.createRow();
        row.setAttribute("CountryId", "XX");
        createCompositionChildRowsUsingNameValuePairs(am);
        am.getTransaction().postChanges();
    }
    /**
     *
     * @param am
     */
    private static void createCompositionChildRowsUsingChildIterator(ApplicationModule am) {
        ViewObject countries = am.findViewObject("Countries");
        Key key = new Key(new Object[] { "IN" });
        Row rows[] = countries.findByKey(key, 1);
        RowIterator locIter = (RowIterator)rows[0].getAttribute("LocationVO");
        Row row = locIter.createRow();
        row.setAttribute("LocationId", 2201);
        row.setAttribute("City", "Bangalore");
        locIter.insertRow(row);
        am.getTransaction().postChanges();
    }

    private static void createCompositionChildRowsUsingNameValuePairs(ApplicationModule am) {
        ViewObject locations = am.findViewObject("Locations");
        Row locRow = locations.createAndInitRow(new NameValuePairs(new String[] { "CountryId" }, new Object[] { "XX" }));
        locRow.setAttribute("LocationId", 2202);
        locRow.setAttribute("City", "Koramangala");
        locations.insertRow(locRow);

        am.getTransaction().postChanges();
    }

    /**
     *
     * @param am
     */
    private static void findEmpByAltKey(ApplicationModule am) {
        ViewObject vo = am.findViewObject("EmployeeDeptDetails");
        Key empDeptAltKey = new Key(new Object[] { "JWHALEN", "Administration" });
        RowIterator iter = vo.findByAltKey("EmpDeptAltKey", empDeptAltKey, -1, false);
        while (iter.hasNext()) {
            Row r = iter.next();
            String fn = (String)r.getAttribute("FirstName");
            String ln = (String)r.getAttribute("Email");
            System.out.println(fn + " - " + ln);
        }
    }

    /**
     *
     * @param am
     */
    private static void findEmpByKey(ApplicationModule am) {
        ViewObject vo = am.findViewObject("EmployeeDeptDetails");
        Key key = new Key(new Object[] { 115, 30 });
        Row row[] = vo.findByKey(key, -1);
        System.out.println(row.length);

    }

    private static void demoPolymorphicVO(ApplicationModule am) {
        MarketingEmployeeListVOImpl vo = (MarketingEmployeeListVOImpl)am.findViewObject("MarketingEmployeeList");
        MarketingEmployeeListVORowImpl execEmpRow = vo.createGenericMarketingEmployee();
        execEmpRow.processRow();
        MarketingEmployeeListVORowImpl salesEmpRow = vo.createSalesEmployee();
        salesEmpRow.processRow();
        MarketingEmployeeListVORowImpl marketingEmpRow = vo.createExecutiveEmployee();
        marketingEmpRow.processRow();

    }

    /**
     *
     * @param am
     */
    private static void createRowInPolymorphicVO(ApplicationModule am) {

    }

    private static void showRows(ViewObject vo, String comment) {
        System.out.println("+++++++++++ " + comment + " ++++++++++++");
        vo.reset();
        while (vo.hasNext()) {
            Row r = vo.next();
            String fn = (String)r.getAttribute("FirstName");
            String ln = (String)r.getAttribute("LastName");
            Boolean sel = (Boolean)r.getAttribute("MarkedForOperation");
            System.out.println(fn + " " + ln + " [" + sel + "]");
        }
    }

}
