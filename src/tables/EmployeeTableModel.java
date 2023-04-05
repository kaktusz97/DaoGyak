/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tables;

import entities.Employee;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Marci
 */
public class EmployeeTableModel extends AbstractTableModel {

    private List<Employee> employees;
    private String[] columnNames;

    public EmployeeTableModel(List<Employee> data) {
        initColumnNames();
        employees = data;
    }

    @Override
    public int getRowCount() {
        return employees.size();
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
        Employee temp = employees.get(rowIndex);
        String result = null;
        switch (columnIndex) {
            case 0 ->
                result = String.valueOf(temp.getId());
            case 1 ->
                result = temp.getName();
            case 2 ->
                result = String.valueOf(temp.getSalary());
        }
        return result;
    }

    private void initColumnNames() {
        columnNames = new String[]{"id", "name", "salary"};
    }

}
