package org.ngam.vanilla.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 * Created by phoenix on 9/15/16.
 */
public class ConnectionFactory implements AbstractConnectionFactory {
    private Connection connection = null;

    @Override
    public Connection get() {
        if (connection==null)
            setup();
        return connection;
    }

    private void setup() {
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream("resources/database.properties"));

            String driver=properties.getProperty("connection.driver"),
                    url=properties.getProperty("connection.url"),
                    db=properties.getProperty("database.name"),
                    uname=properties.getProperty("user.name"),
                    pw=properties.getProperty("user.password");

            if (url.charAt(url.length()-1)!='/')
                url += "/";
            url += db;

            Class.forName(driver).newInstance();
            connection = DriverManager.getConnection(url,uname,pw);
        } catch (Exception e) {
            System.err.println("Error : " + e);
        }
    }
}
