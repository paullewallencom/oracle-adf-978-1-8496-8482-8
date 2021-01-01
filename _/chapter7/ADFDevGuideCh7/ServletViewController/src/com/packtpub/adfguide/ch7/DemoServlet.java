package com.packtpub.adfguide.ch7;

import java.io.IOException;
import java.io.PrintWriter;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.*;
import javax.servlet.http.*;

import oracle.adf.model.BindingContext;
import oracle.adf.model.DataControlFrame;
import oracle.adf.model.binding.DCBindingContainer;

import oracle.adf.model.binding.DCDataControl;

import oracle.adf.model.dcframe.DataControlFrameImpl;

import oracle.jbo.Row;
import oracle.jbo.uicli.binding.JUCtrlRangeBinding;
import oracle.jbo.uicli.binding.JUCtrlValueBindingRef;

public class DemoServlet extends HttpServlet {
    private static final String CONTENT_TYPE = "text/html; charset=windows-1252";

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }
    // com_packtpub_adfguide_ch7_view_departmentPageDef

    /**Process the HTTP doGet request.
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BindingContext bindingContext = null;
        try {
            bindingContext = BindingContext.getCurrent();


            response.setContentType(CONTENT_TYPE);
            PrintWriter out = response.getWriter();
            out.println("<html>");
            out.println("<head><title>SampleServlet</title></head>");
            out.println("<body>");
            out.println("<p>The servlet has received a GET. This is the reply.</p>");
            DataControlFrameImpl dcframe = (DataControlFrameImpl)BindingContext.getCurrent().dataControlFrame();

            DCDataControl dcd = dcframe.findDataControl("HRServiceAppModuleDataControl","HRServiceAppModuleDataControl", true);
           
            System.out.println("AM  - " + dcframe.getName() + dcd );
            DCBindingContainer dcBindingContainer =
                bindingContext.findBindingContainer("com_packtpub_adfguide_ch7_view_servlet_departmentPageDef");
            JUCtrlRangeBinding depts = (JUCtrlRangeBinding)dcBindingContainer.findCtrlBinding("Departments");
            dcBindingContainer.refreshControl();
            List<JUCtrlValueBindingRef> deptsList = depts.getRangeSet();
            Iterator deptsIter = deptsList.iterator();


            while (deptsIter.hasNext()) {
                JUCtrlValueBindingRef valueBinding = (JUCtrlValueBindingRef)deptsIter.next();
                Row attrs = valueBinding.getRow();
                out.println(attrs.getAttribute("DepartmentId") + "&nbsp;" + attrs.getAttribute("DepartmentName") +
                            "<br/>");
            }
            out.println("<b>");
            out.println("</body></html>");
            out.close();
        } finally {
            // Clean up goes here...

            /**
            *  Call the following on session time out/logout
            *  if (bindingContext != null)
            *      bindingContext.release();
            */
        }
    }
}
