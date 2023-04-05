/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistence;

import entities.Employee;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Marci
 */
public class EmployeeDAO implements DAO<Long, Employee> {

    private static Connection connection;
    private static final String INSERT = "insert into employees (id, name, salary) VALUES (?, ?, ?); ";
    private static final String SELECT_BY_ID = "select * from employees where id =?";
    private static final String SELECT_ALL = "select * from employees";
    private static final String UPDATE = "update employees set name= ?, salary =? where id = ?;";
    private static final String DELETE = "delete from employees where id = ?;";

    static {
        try {
            connection = ConnectionFactory.getInstance().getConnection();
        } catch (SQLException ex) {
            ex.getMessage();
        }
    }

    protected EmployeeDAO() {
    }

    @Override
    public void create(Employee t) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(INSERT);
        importEmployeeToStatement(statement, t);
        statement.executeUpdate();
    }

    @Override
    public Employee read(Long id) throws SQLException {
        Employee e = null;
        PreparedStatement statement = connection.prepareStatement(SELECT_BY_ID);
        statement.setLong(1, id);
        ResultSet rs = statement.executeQuery();
        while (rs.next()) {
            e = extractEmployeeFromResultSet(rs);
        }
        return e;
    }

    @Override
    public void update(Employee t) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(UPDATE);
        statement.setString(1, t.getName());
        statement.setDouble(2, t.getSalary());
        statement.setLong(3, t.getId());
        statement.executeUpdate();
    }

    @Override
    public void remove(Long id) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(DELETE);
        statement.setLong(1, id);
        statement.executeUpdate();
    }

    @Override
    public List<Employee> readAll() throws SQLException {
        List<Employee> result = new ArrayList<>();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL + ";");
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            result.add(extractEmployeeFromResultSet(rs));
        }
        return result;
    }

    private Employee extractEmployeeFromResultSet(ResultSet rs) throws SQLException {
        return new Employee(
                rs.getLong("id"),
                rs.getString("name"),
                rs.getDouble("salary"));
    }

    private void importEmployeeToStatement(PreparedStatement statement, Employee t) throws SQLException {
        statement.setLong(1, t.getId());
        statement.setString(2, t.getName());
        statement.setDouble(3, t.getSalary());
    }

}
