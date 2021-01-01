package fmwk.extension.entity;

import fmwk.extension.ConversionUtil;
import fmwk.extension.view.DefaultTransactionContext;
import fmwk.extension.view.GenericRowData;

import oracle.jbo.server.EntityImpl;
import oracle.jbo.server.TransactionEvent;

/**
 * A generic base calss for building programmatically managed entity object
 */
public abstract class ProgrammaticallyManagedEntityObjectImpl extends EntityImpl {
    private DefaultTransactionContext txnCntxt = null;

    public ProgrammaticallyManagedEntityObjectImpl() {
        super();
    }

    /**
     * Locks the row.
     *
     * <p>If the row is new or already locked by this Entity Object,
     * or if the transaction's locking mode is <tt>LOCK_NONE</tt>,
     * this method has no effect.
     *
     * <p>If this Entity Object is contained by another
     * (that is, it is part of a composition association and has a master Entity Object),
     * this method locks the top-most
     * Entity Object in the chain of containers before attempting to lock itself.
     *  <p>
     * This method should not be overridden unless the application is
     * maintaining Entity lock
     * states.
     * @exception AlreadyLockedException if the row is locked by another user or transaction.
     * @exception DeadEntityAccessException if the Entity Object is
     * marked "unusable" or is <tt>STATUS_DEAD</tt>.
     */
    public void lock() {

        GenericDataPersistanceService svcImpl = getService();
        GenericRowData rowData = ConversionUtil.converEntityToRowData(this);
        svcImpl.lock(rowData);
        super.lock();

    }

    /**
     * This is invoked in two scenarios:
     * 1. EntityDefImpl.findByPrimaryKey() will end up in the entity's doSelect() method.
     * 2. ADF BC framework needs to lock the entity object durinf edit based on the lockong mode
     * It will lock the entity by using doSelect() passing "true" for the lock parameter
     * @param lock
     */
    @Override
    protected final void doSelect(boolean lock) {

        log("doSelect");
        GenericDataPersistanceService svcImpl = getService();
        svcImpl.doSelectRowNLock(null, lock);
        //Dont call super.doSelect as it genrates native SQL
        //which is not expected for programmtic EO
    }

    /**
     * Custom DML update/insert/delete logic here.
     * @param operation the operation type
     * @param e the transaction event
     */
    @Override
    protected final void doDML(int operation, TransactionEvent e) {

        log("doDML");

        GenericDataPersistanceService svcImpl = getService();
        GenericRowData rowData = ConversionUtil.converEntityToRowData(this);
        switch (operation) {
        case EntityImpl.DML_DELETE:
            svcImpl.deleteObject(rowData);
            break;
        case EntityImpl.DML_INSERT:
            svcImpl.createObject(rowData);
            break;
        case EntityImpl.DML_UPDATE:
            svcImpl.updateObject(rowData);
        }

    }

    public abstract GenericDataPersistanceService getService();

    private void log(String msg) {
        System.out.println(msg);
    }

    public void afterCommit(TransactionEvent e) {
        super.afterCommit(e);
        getService().afterCommit(txnCntxt);
    }


    public void afterRollback(TransactionEvent e) {
        super.afterRollback(e);
        getService().afterRollback(txnCntxt);
    }

    /**
     * Polls transaction listeners before a <em>commit</em> operation.
     * @param e this Entity Object's transaction event.
     * @see TransactionListener
     */
    public void beforeCommit(TransactionEvent e) {
        super.beforeCommit(e);
        getService().beforeCommit(txnCntxt);
    }

    /**
     * Polls transaction listeners before a <em>rollback</em> operation.
     * @param e this Entity Object's transaction event.
     * @see TransactionListener
     */
    public void beforeRollback(TransactionEvent e) {
        super.beforeRollback(e);
        getService().beforeRollback(txnCntxt);
    }

    /**
     * Validates the Entities and other listeners that are members of ValidationListeners list.
     * Once all listeners are validated and removed from the list, invoke
     * declarative validators (if attached to this Entity Object's defintion) to validate
     * this Entity Object instance. For example,
     * {@link oracle.jbo.server.JboMandatoryAttributesValidator JboMandatoryAttributesValidator}
     * (if applicable) will be invoked here to perform null-value checks on mandatory attributes.
     * <p> Applications should subclass this method to perform custom Entity-level validation
     * and call <code>super.validateEntity()</code> to enable the framework to coordinate
     * validation of detail Entities and validation via the declarative validators (that is,
     * Entity validators declared at design-time).
     * <p>
     * In the case of composition, child Entities are validated from this method.
     * <p>
     * In the following example, code is added to <tt>validateEntity()</tt> to throw an exception
     * if the value of the <tt>Emp.Ename</tt> attribute is "Jerome".
     * <p>
     * <pre>
     *     public void validateEntity() {
     *       if (getEname().equals("Jerome"))
     *         throw new JboException("Name cannot be Jerome");
     *       super.validateEntity();
     *      }
     * </pre>
     * <p>
     * @exception JboException in case validation fails.
     */
    protected void validateEntity() {
        GenericRowData rowData = ConversionUtil.converEntityToRowData(this);
        getService().validate(rowData);
        super.validateEntity();
    }


}
