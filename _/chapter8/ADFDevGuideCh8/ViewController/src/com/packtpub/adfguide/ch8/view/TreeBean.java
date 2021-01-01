package com.packtpub.adfguide.ch8.view;

import oracle.adf.view.rich.component.rich.data.RichTreeTable;

import oracle.jbo.Key;
import oracle.jbo.RowIterator;
import oracle.jbo.uicli.binding.JUCtrlHierNodeBinding;

public class TreeBean {
    private RichTreeTable deptTreeTable;

    public TreeBean() {
    }

    public void setDeptTreeTable(RichTreeTable deptTreeTable) {
        this.deptTreeTable = deptTreeTable;
    }

    public RichTreeTable getDeptTreeTable() {
        return deptTreeTable;
    }

    /**
     * This method returns RowIterator object for currently selected
     * row(nde)
     * @return
     */
    public RowIterator getSelectedNodeRowIterator() {
        RowIterator ri = null;
        RichTreeTable depTreeTable = getDeptTreeTable();
        //Store the original Key
        Object oldKey = depTreeTable.getRowKey();
        try {
            if (depTreeTable.getSelectedRowKeys() != null) {
                for (Object opaqueFacesKey : depTreeTable.getSelectedRowKeys()) {
                    depTreeTable.setRowKey(opaqueFacesKey);
                    //Get the RowIterator for the lowest node in the selected node path
                    ri = ((JUCtrlHierNodeBinding)depTreeTable.getRowData()).getRowIterator();
                    break;
                }
            }
        } finally {
            //Restore the original Key
            getDeptTreeTable().setRowKey(oldKey);
        }
        return ri;
    }

    /**
     *
     * @return
     */
    public boolean isSelectedNodeInRowIteratorFirst() {
        RowIterator ri = getSelectedNodeRowIterator();
        if (ri != null) {
            Key selectedNodeRowKey = getSelectedNodeRowKey();
            if (selectedNodeRowKey != null) {
                return selectedNodeRowKey.equals(ri.first().getKey());
            }
        }
        return false;
    }

    public boolean isSelectedNodeInRowIteratorLast() {
        RowIterator ri = getSelectedNodeRowIterator();
        if (ri != null) {
            Key selectedNodeRowKey = getSelectedNodeRowKey();
            if (selectedNodeRowKey != null) {
                return selectedNodeRowKey.equals(ri.last().getKey());
            }
        }
        return false;
    }
    
    /**
     * This method returns Key for the selected node
     * @return
     */
    public Key getSelectedNodeRowKey() {
        Key key = null;
        RichTreeTable depTreeTable = getDeptTreeTable();
        //Store the original Key
        Object oldKey = depTreeTable.getRowKey();

        try {
            if (depTreeTable.getSelectedRowKeys() != null) {
             
                for (Object opaqueFacesKey : depTreeTable.getSelectedRowKeys()) {
                    //Return the Key for the lowest level in the selection
                    depTreeTable.setRowKey(opaqueFacesKey);
                    key = ((JUCtrlHierNodeBinding)depTreeTable.getRowData()).getRowKey();
                    break;
                }
            }
        } finally {
            //Restore the original Key
            depTreeTable.setRowKey(oldKey);
        }
        return key;
    }

    public String getSelectedNodeViewDefFullName() {
        String defName = null;
        RichTreeTable depTreeTable = getDeptTreeTable();
        Object oldKey = depTreeTable.getRowKey();
        try {

            if (depTreeTable.getSelectedRowKeys() != null) {
                for (Object opaqueFacesKey : depTreeTable.getSelectedRowKeys()) {
                    depTreeTable.setRowKey(opaqueFacesKey);
                    defName = ((JUCtrlHierNodeBinding)depTreeTable.getRowData()).getViewObject().getDefFullName();
                    break;
                }
            }
        } finally {
            depTreeTable.setRowKey(oldKey);
        }
        return defName;
    }

}
