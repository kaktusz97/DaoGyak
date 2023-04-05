/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistence;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author Marci
 */
public class DatabaseProperties {

    private static String url;
    private static String username;
    private static String password;

    static {
        initProperties();
    }

    private DatabaseProperties() {
    }

    private static void initProperties() {
        try {
            Properties props = new Properties();
            FileInputStream fis = new FileInputStream("config.properties.txt");
            props.load(fis);
            url = props.getProperty("db.url");
            username = props.getProperty("db.username");
            password = props.getProperty("db.password");
            fis.close();
        } catch (IOException ex) {
            ex.getMessage();
        }
    }

    public static String getUrl() {
        String newUrl = url;
        return newUrl;
    }

    public static String getUsername() {
        String newUsername = username;
        return newUsername;
    }

    public static String getPassword() {
        String newPassword = password;
        return newPassword;
    }

}
