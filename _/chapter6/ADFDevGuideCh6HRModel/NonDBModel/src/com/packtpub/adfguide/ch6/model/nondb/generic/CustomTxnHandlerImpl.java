package com.packtpub.adfguide.ch6.model.nondb.generic;

import java.sql.Connection;

import oracle.jbo.server.DefaultTxnHandlerImpl;

public class CustomTxnHandlerImpl extends DefaultTxnHandlerImpl{
    public CustomTxnHandlerImpl() {
        super();
    }

    /**
     * Issues a <tt>rollback()</tt> command to the JDBC connection.
     * @throws DMLException if an attempt to post to the database was
     * unsuccessful.
     */
    public void handleRollback(Connection conn, boolean autoStart) {
       // super.handleRollback(conn, autoStart);
    }

    /**
     * Opens a transaction.
     * Under JDBC, the transaction is already assumed to be open. Other than set
     * autocommit to <tt>false</tt>, this default implementation does nothing.
     */
    public void handleOpen(Connection conn) {
        super.handleOpen(conn);
    }

    /**
     * Issues a <tt>commit()</tt> command to the JDBC connection.
     * @throws DMLException if an attempt to post to the database was
     * unsuccessful.
     */
    public void handleCommit(Connection conn, boolean autoStart) {
        //super.handleCommit(conn, autoStart);
    }

    /**
     * Issues a <tt>close()</tt> command to the JDBC connection.
     * @throws DMLException if an attempt to post to the database was
     * unsuccessful.
     */
    public void handleClose(Connection conn) {
        super.handleClose(conn);
    }
}
