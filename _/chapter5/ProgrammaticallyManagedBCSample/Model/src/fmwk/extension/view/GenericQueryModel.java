package fmwk.extension.view;

import java.util.Map;

import oracle.jbo.RowSet;


/**
 * Generic query model class. This is derived from VC,RowFilter and ViewLink defintion
 * and supplied to thirt party API for data retrieval
 */
public class GenericQueryModel {
    private Map<String, Object> filterPramValues;
    private byte accessMode = RowSet.SCROLLABLE;
    private int startIndex;
    private int pageSize;

    public GenericQueryModel() {
        super();
    }

    public void setFilterPramValues(Map<String, Object> filterPramValues) {
        this.filterPramValues = filterPramValues;
    }

    public Map<String, Object> getFilterPramValues() {
        return filterPramValues;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageSize() {
        return pageSize;
    }


    public void setAccessMode(byte accessMode) {
        this.accessMode = accessMode;
    }

    public byte getAccessMode() {
        return accessMode;
    }
}
