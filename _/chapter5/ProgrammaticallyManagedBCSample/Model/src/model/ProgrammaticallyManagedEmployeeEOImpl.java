package model;

import fmwk.extension.entity.ProgrammaticallyManagedEntityObjectImpl;

import fmwk.extension.entity.GenericDataPersistanceService;

import model.emp.service.MyEmpDataServiceImplementation;

import oracle.jbo.Key;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.EntityDefImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Sat Jun 25 11:43:33 IST 2011
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class ProgrammaticallyManagedEmployeeEOImpl extends ProgrammaticallyManagedEntityObjectImpl {
    /**
     * This is the default constructor (do not remove).
     */
    public ProgrammaticallyManagedEmployeeEOImpl() {
    }

    /**
     * @param employeeId key constituent

     * @return a Key object based on given key constituents.
     */
    public static Key createPrimaryKey(oracle.jbo.domain.Number employeeId) {
        return new Key(new Object[] { employeeId });
    }

    /**
     * @return the definition object for this instance class.
     */
    public static synchronized EntityDefImpl getDefinitionObject() {
        return EntityDefImpl.findDefObject("model.ProgrammaticallyManagedEmployeeEO");
    }

    /**
     * Delegates the  call to third party data source, the rest of the life cycle is handled by
     * the base class ProgrammaticallyManagedEntityObjectImpl
     * @return
     */
    @Override
    public GenericDataPersistanceService getService() {
        return MyEmpDataServiceImplementation.getInstance();
    }
}
