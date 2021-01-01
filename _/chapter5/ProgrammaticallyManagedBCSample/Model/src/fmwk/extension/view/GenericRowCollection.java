package fmwk.extension.view;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Genric data strucutre to hold the result set
 */
public class GenericRowCollection implements Iterator<GenericRowData>,
                                             Iterable<GenericRowData> {
    /**
     * Query used ofr getting result set 
     */
    private GenericQueryModel queryModel;
    /**
     * List of GenericRowData objects
     */
    private List<GenericRowData> rowCollection =
        new ArrayList<GenericRowData>();
    private int currentPosition;

    public GenericRowCollection() {
        super();
        currentPosition = 0;
    }

    public boolean hasNext() {
        return currentPosition < rowCollection.size();
    }

    public GenericRowData next() {
        GenericRowData gr = rowCollection.get(currentPosition);
        currentPosition++;
        return gr;
    }

    public void remove() {
        rowCollection.remove(currentPosition);
    }

    public long geTotalRowCount() {
        return rowCollection.size();
    }

    public void setRowCollection(List<GenericRowData> rowCollection) {
        this.rowCollection = rowCollection;
        currentPosition = 0;
    }

    public List<GenericRowData> getRowCollection() {
        return rowCollection;
    }

    public void setQueryModel(GenericQueryModel queryModel) {
        this.queryModel = queryModel;
    }

    public GenericQueryModel getQueryModel() {
        return queryModel;
    }

    @Override
    public Iterator<GenericRowData> iterator() {
        currentPosition = 0;
        return this;
    }
}
