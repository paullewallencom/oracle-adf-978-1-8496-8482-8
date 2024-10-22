package model;

import fmwk.extension.view.GenericDataReadServiceInterface;
import fmwk.extension.view.ProgrammaticallyManagedViewObjectImpl;

import model.emp.service.MyEmpDataServiceImplementation;

// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Wed Jun 22 07:19:07 IST 2011
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class ProgrammaticallyManagedEmployeeVOImpl extends ProgrammaticallyManagedViewObjectImpl {
    /**
     * This is the default constructor (do not remove).
     */
    public ProgrammaticallyManagedEmployeeVOImpl() {
    }
    /**
     * Delegates the  call to third party data source, the rest of the life cycle is handled by 
     * the base class ProgrammaticallyManagedViewObjectImpl
     * @return
     */
    @Override
    public GenericDataReadServiceInterface getService() {
        return MyEmpDataServiceImplementation.getInstance();
    }
}
