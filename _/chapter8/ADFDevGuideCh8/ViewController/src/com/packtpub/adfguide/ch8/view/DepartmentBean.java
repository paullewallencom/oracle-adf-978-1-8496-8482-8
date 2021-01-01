package com.packtpub.adfguide.ch8.view;

import java.util.Iterator;

import javax.faces.event.ActionEvent;

import oracle.adf.view.rich.component.rich.data.RichTable;

import oracle.jbo.Row;
import oracle.jbo.uicli.binding.JUCtrlHierNodeBinding;

import org.apache.myfaces.trinidad.model.RowKeySet;


public class DepartmentBean {
    private RichTable departmentTable;

    public DepartmentBean() {
    }

    public void handleAction(ActionEvent actionEvent) {
        RichTable deptTable = getDepartmentTable();
        Row row = getSelectedRow(deptTable);
        System.out.println("Selected Row Attrib Val -" + row.getAttribute(1));
    }

    /**
     * This method return selected row for the table
     * @param deptTable
     * @return
     */
    public Row getSelectedRow(RichTable deptTable) {
        Row currentRow = null;
        RowKeySet selectedRowKeys = deptTable.getSelectedRowKeys();

        //Store original rowKey
        Object oldRowKey = deptTable.getRowKey();
        try {

            if (selectedRowKeys != null) {
                Iterator iter = selectedRowKeys.iterator();
                if (iter != null && iter.hasNext()) {
                    Object rowKey = iter.next();
                    //stamp row
                    deptTable.setRowKey(rowKey);
                    JUCtrlHierNodeBinding rowData = (JUCtrlHierNodeBinding)deptTable.getRowData();
                    //rowData holds current row object,
                    //your code to deal with row goes here
                    currentRow = rowData.getRow();

                }
            }

        } finally {

            //Restore the original rowKey
            deptTable.setRowKey(oldRowKey);
        }
        return currentRow;
    }

    public void setDepartmentTable(RichTable departmentTable) {
        this.departmentTable = departmentTable;
    }

    public RichTable getDepartmentTable() {
        return departmentTable;
    }
}
