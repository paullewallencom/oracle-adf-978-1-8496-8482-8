package fmwk.extension.view;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import oracle.jbo.server.Entity;


/**
 * This corresponds to a row in the result returned from the data source.
 * Strucutre is like a Map to ensure the generic usage
 */
public class GenericRowData extends HashMap {
    /**
     * Status flag for the data, this is same as entities state flag
     */
    byte status = Entity.STATUS_UNMODIFIED;

    public GenericRowData() {
        super();
    }

    public GenericRowData(Map dataMap) {
        this.putAll(dataMap);
    }

    public void setAttribute(String attribute, Object value) {
        put(attribute, value);
    }

    public Object getAttribute(String attribute) {
        return get(attribute);
    }

    public Map getDataMap() {
        return (Map)this.clone();
    }

    /**
     * Check whther the entries in GenericRowData matches with filterPramValues
     * This is used to check whether whather data meets the filtering criteria used for
     * getting the collection from ViewObjectImpl::executeQueryForCollection(...)
     * @param filterPramValues
     * @return
     */
    public boolean isQualified(Map<String, Object> filterPramValues) {
        if (filterPramValues == null || filterPramValues.size() == 0) {
            return true;
        }
        Set<String> keys = filterPramValues.keySet();
        Iterator<String> keyIter = keys.iterator();
        while (keyIter.hasNext()) {
            String attribute = keyIter.next();
            if (get(attribute) != null && filterPramValues.get(attribute) != null) {
                if (!get(attribute).equals(filterPramValues.get(attribute))) {
                    return false;
                }
            }
        }
        return true;
    }

    public void setStatus(byte status) {
        this.status = status;
    }

    public byte getStatus() {
        return status;
    }
}
