/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistence;

import entities.CEO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Marci
 */
public class CEODAO implements DAO<Long, CEO> {

    private static Connection connection;
    private static final String INSERT = "insert into ceos (id, name, salary) VALUES (?, ?, ?); ";
    private static final String SELECT_BY_ID = "select * from ceos where id =?";
    private static final String SELECT_ALL = "select * from ceos";
    private static final String UPDATE = "update ceos set name= ?, salary =? where id = ?;";
    private static final String DELETE = "delete from ceos where id = ?;";

    static {
        try {
            connection = ConnectionFactory.getInstance().getConnection();
        } catch (SQLException ex) {
            ex.getMessage();
        }
    }

    @Override
    public void create(CEO t) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(INSERT);
        importCEOToStatement(statement, t);
        statement.executeUpdate();
    }

    @Override
    public CEO read(Long id) throws SQLException {
        CEO c = null;
        PreparedStatement statement = connection.prepareStatement(SELECT_BY_ID);
        statement.setLong(1, id);
        ResultSet rs = statement.executeQuery();
        while (rs.next()) {
            c = extractCEOFromResultSet(rs);
        }
        return c;
    }

    @Override
    public void update(CEO t) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(UPDATE);
        statement.setString(1, t.getName());
        statement.setInt(2, t.getEmployees());
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
    public List<CEO> readAll() throws SQLException {
        List<CEO> result = new ArrayList<>();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL + ";");
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            result.add(extractCEOFromResultSet(rs));
        }
        return result;
    }

    private CEO extractCEOFromResultSet(ResultSet rs) throws SQLException {
        return new CEO(
                rs.getLong("id"),
                rs.getString("name"),
                rs.getInt("employees"));
    }

    private void importCEOToStatement(PreparedStatement statement, CEO t) throws SQLException {
        statement.setLong(1, t.getId());
        statement.setString(2, t.getName());
        statement.setInt(3, t.getEmployees());
    }

}
