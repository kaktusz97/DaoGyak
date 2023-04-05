/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Marci
 */
public class ConnectionFactory {

    private static ConnectionFactory instance;
    private static final String URL;
    private static final String USERNAME;
    private static final String PASSWORD;

    static {
        instance = new ConnectionFactory();
        URL = DatabaseProperties.getUrl();
        USERNAME = DatabaseProperties.getUsername();
        PASSWORD = DatabaseProperties.getPassword();
    }

    private ConnectionFactory() {
    }

    public static final ConnectionFactory getInstance() {
        return instance;
    }

    public final Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        return connection;
    }

}
