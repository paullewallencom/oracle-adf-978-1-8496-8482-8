package com.packtpub.adfguide.ch5.model.view;

import oracle.jbo.domain.ClobDomain;
import oracle.jbo.domain.DBSequence;
import oracle.jbo.domain.Timestamp;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.EntityImpl;
import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Sun Nov 06 12:53:56 IST 2011
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class FileStorageVORowImpl extends ViewRowImpl {
    public static final int ENTITY_FILESTORAGEEO = 0;

    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. Do not modify.
     */
    public enum AttributesEnum {
        FileId {
            public Object get(FileStorageVORowImpl obj) {
                return obj.getFileId();
            }

            public void put(FileStorageVORowImpl obj, Object value) {
                obj.setFileId((DBSequence)value);
            }
        }
        ,
        FileName {
            public Object get(FileStorageVORowImpl obj) {
                return obj.getFileName();
            }

            public void put(FileStorageVORowImpl obj, Object value) {
                obj.setFileName((String)value);
            }
        }
        ,
        FileContent {
            public Object get(FileStorageVORowImpl obj) {
                return obj.getFileContent();
            }

            public void put(FileStorageVORowImpl obj, Object value) {
                obj.setFileContent((ClobDomain)value);
            }
        }
        ,
        CreatedOn {
            public Object get(FileStorageVORowImpl obj) {
                return obj.getCreatedOn();
            }

            public void put(FileStorageVORowImpl obj, Object value) {
                obj.setCreatedOn((Timestamp)value);
            }
        }
        ;
        private static AttributesEnum[] vals = null;
        private static int firstIndex = 0;

        public abstract Object get(FileStorageVORowImpl object);

        public abstract void put(FileStorageVORowImpl object, Object value);

        public int index() {
            return AttributesEnum.firstIndex() + ordinal();
        }

        public static int firstIndex() {
            return firstIndex;
        }

        public static int count() {
            return AttributesEnum.firstIndex() + AttributesEnum.staticValues().length;
        }

        public static AttributesEnum[] staticValues() {
            if (vals == null) {
                vals = AttributesEnum.values();
            }
            return vals;
        }
    }
    public static final int FILEID = AttributesEnum.FileId.index();
    public static final int FILENAME = AttributesEnum.FileName.index();
    public static final int FILECONTENT = AttributesEnum.FileContent.index();
    public static final int CREATEDON = AttributesEnum.CreatedOn.index();

    /**
     * This is the default constructor (do not remove).
     */
    public FileStorageVORowImpl() {
    }

    /**
     * Gets FileStorageEO entity object.
     * @return the FileStorageEO
     */
    public EntityImpl getFileStorageEO() {
        return (EntityImpl)getEntity(ENTITY_FILESTORAGEEO);
    }

    /**
     * Gets the attribute value for FILE_ID using the alias name FileId.
     * @return the FILE_ID
     */
    public DBSequence getFileId() {
        return (DBSequence)getAttributeInternal(FILEID);
    }

    /**
     * Sets <code>value</code> as attribute value for FILE_ID using the alias name FileId.
     * @param value value to set the FILE_ID
     */
    public void setFileId(DBSequence value) {
        setAttributeInternal(FILEID, value);
    }

    /**
     * Gets the attribute value for FILE_NAME using the alias name FileName.
     * @return the FILE_NAME
     */
    public String getFileName() {
        return (String) getAttributeInternal(FILENAME);
    }

    /**
     * Sets <code>value</code> as attribute value for FILE_NAME using the alias name FileName.
     * @param value value to set the FILE_NAME
     */
    public void setFileName(String value) {
        setAttributeInternal(FILENAME, value);
    }

    /**
     * Gets the attribute value for FILE_CONTENT using the alias name FileContent.
     * @return the FILE_CONTENT
     */
    public ClobDomain getFileContent() {
        return (ClobDomain)getAttributeInternal(FILECONTENT);
    }

    /**
     * Sets <code>value</code> as attribute value for FILE_CONTENT using the alias name FileContent.
     * @param value value to set the FILE_CONTENT
     */
    public void setFileContent(ClobDomain value) {
        setAttributeInternal(FILECONTENT, value);
    }

    /**
     * Gets the attribute value for CREATED_ON using the alias name CreatedOn.
     * @return the CREATED_ON
     */
    public Timestamp getCreatedOn() {
        return (Timestamp) getAttributeInternal(CREATEDON);
    }

    /**
     * Sets <code>value</code> as attribute value for CREATED_ON using the alias name CreatedOn.
     * @param value value to set the CREATED_ON
     */
    public void setCreatedOn(Timestamp value) {
        setAttributeInternal(CREATEDON, value);
    }

    /**
     * getAttrInvokeAccessor: generated method. Do not modify.
     * @param index the index identifying the attribute
     * @param attrDef the attribute

     * @return the attribute value
     * @throws Exception
     */
    protected Object getAttrInvokeAccessor(int index, AttributeDefImpl attrDef) throws Exception {
        if ((index >= AttributesEnum.firstIndex()) && (index < AttributesEnum.count())) {
            return AttributesEnum.staticValues()[index - AttributesEnum.firstIndex()].get(this);
        }
        return super.getAttrInvokeAccessor(index, attrDef);
    }

    /**
     * setAttrInvokeAccessor: generated method. Do not modify.
     * @param index the index identifying the attribute
     * @param value the value to assign to the attribute
     * @param attrDef the attribute

     * @throws Exception
     */
    protected void setAttrInvokeAccessor(int index, Object value, AttributeDefImpl attrDef) throws Exception {
        if ((index >= AttributesEnum.firstIndex()) && (index < AttributesEnum.count())) {
            AttributesEnum.staticValues()[index - AttributesEnum.firstIndex()].put(this, value);
            return;
        }
        super.setAttrInvokeAccessor(index, value, attrDef);
    }
}
