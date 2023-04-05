/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tables;

import entities.CEO;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Marci
 */
public class CEOTableModel extends AbstractTableModel {

    private List<CEO> ceos;
    private String[] columnNames;

    public CEOTableModel(List<CEO> data) {
        initColumnNames();
        ceos = data;
    }

    @Override
    public int getRowCount() {
        return ceos.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        CEO temp = ceos.get(rowIndex);
        String result = null;
        switch (columnIndex) {
            case 0 ->
                result = String.valueOf(temp.getId());
            case 1 ->
                result = temp.getName();
            case 2 ->
                result = String.valueOf(temp.getEmployees());
        }
        return result;
    }

    private void initColumnNames() {
        columnNames = new String[]{"id", "name", "employees"};
    }

}
