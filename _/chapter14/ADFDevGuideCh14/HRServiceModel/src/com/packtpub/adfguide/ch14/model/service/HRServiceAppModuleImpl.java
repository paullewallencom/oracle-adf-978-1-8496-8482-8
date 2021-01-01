package com.packtpub.adfguide.ch14.model.service;

import com.packtpub.adfguide.ch14.model.service.common.HRServiceAppModule;
import com.packtpub.adfguide.ch14.model.view.DepartmentVOImpl;

import java.security.Permission;

import java.util.ArrayList;
import java.util.Arrays;

import java.util.List;

import oracle.adf.share.ADFContext;
import oracle.adf.share.security.SecurityContext;
import oracle.adf.share.security.authorization.MethodPermission;

import oracle.jbo.Session;
import oracle.jbo.server.ApplicationModuleImpl;
import oracle.jbo.server.ViewLinkImpl;
import oracle.jbo.server.ViewObjectImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Fri May 11 10:49:50 IST 2012
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class HRServiceAppModuleImpl extends ApplicationModuleImpl implements HRServiceAppModule {
    /**
     * This is the default constructor (do not remove).
     */
    public HRServiceAppModuleImpl() {

    }

    /**
     * Container's getter for Departments.
     * @return Departments
     */
    public DepartmentVOImpl getDepartments() {
        return (DepartmentVOImpl)findViewObject("Departments");
    }

    /**
     * Container's getter for EmployeesInDepartment.
     * @return EmployeesInDepartment
     */
    public ViewObjectImpl getEmployeesInDepartment() {
        return (ViewObjectImpl)findViewObject("EmployeesInDepartment");
    }

    /**
     * Container's getter for EmpDeptFkLink1.
     * @return EmpDeptFkLink1
     */
    public ViewLinkImpl getEmpDeptFkLink1() {
        return (ViewLinkImpl)findViewLink("EmpDeptFkLink1");
    }

    public void updateDeparmentDetails() {
        Permission permission =
            new MethodPermission("com.packtpub.adfguide.ch14.model.service.HRServiceAppModuleImpl.updateDeparmentDetails",
                                 "invoke");
        SecurityContext securityCtx = ADFContext.getCurrent().getSecurityContext();
        boolean userHasPermission = securityCtx.hasPermission(permission);
        System.out.println(" userHasPermission: " + userHasPermission);
    }

    public void securityAPICheck() {

        SecurityContext securityCtx = ADFContext.getCurrent().getSecurityContext();
        String loggedInUserName = securityCtx.getUserName();

        ADFContext adfContext = ADFContext.getCurrent();
        String enterpriseName = adfContext.getEnterpriseName();
        boolean isuserInRole = securityCtx.isUserInRole("it-dmin");

        String[] assignedRoles = securityCtx.getUserRoles();
        String commaSepartedRoles = "it-dmin,standard-user";

        String[] commaSepartedRolesArray = commaSepartedRoles.split(",");
        List assignedRolesAsList = Arrays.asList(assignedRoles);
        for (String role : commaSepartedRolesArray) {

            if (assignedRolesAsList.contains(role)) {

            }

        }

    }

    public boolean isUserInAllRoles(String commaSepartedRoles) {
        SecurityContext securityCtx = ADFContext.getCurrent().getSecurityContext();
        String[] assignedRoles = securityCtx.getUserRoles();

        String[] commaSepartedRolesArray = commaSepartedRoles.split(",");
        List assignedRolesAsList = Arrays.asList(assignedRoles);
        for (String role : commaSepartedRolesArray) {

            if (!assignedRolesAsList.contains(role)) {
                return false;
            }

        }
        return true;
    }

    /**
     * Prepare the ApplicationModule and/or the JDBC session.
     * Application developers may extend this method to initialize JDBC or
     * ApplicationModule session state.  For example, a developer could extend
     * this method to prepare PL/SQL session state which is related to a
     * virtual private database.  A developer may also extend this method to
     * initialize state in the ApplicationModule Session.
     * <p>
     * The application module may be assumed to be in a valid, connected
     * state when this method is invoked.
     * <p>
     * This method is invoked when:
     * <p>
     * 1.  An ApplicationModule is first created.
     * <p>
     * 2.  An ApplicationModule is associated with a user
     * session -- typically an ApplicationModuleHandle that was created by the
     * pooling framework.  Note that a handle may be
     * disassociated from an ApplicationModule as ApplicationModules are
     * recycled.  prepareSession will be invoked when the handle is
     * associated with a new ApplicationModule, before the handle's state
     * is activated.
     * <p>
     * 3.  An ApplicationModule session is reconnected to a database.
     * <p>
     * @see #getSession()
     */
    protected void prepareSession(Session session) {
        super.prepareSession(session);
    }
}
