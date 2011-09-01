package com.jusco.taste.jrs.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.naming.NoInitialContextException;


public class DBUtil {
    private static Connection connection = null;

    public static Connection getConnection(){
        // Try JNDI
        try {
            if(connection != null && !connection.isClosed())
                return connection;
            //Class.forName("org.postgresql.Driver").newInstance();
            Context c = new InitialContext();
            String host = (String)c.lookup("java:comp/env/jdbc/host");
            String user = (String)c.lookup("java:comp/env/jdbc/user");
            String password = (String)c.lookup("java:comp/env/jdbc/password");
            connection = DriverManager.getConnection(host, user, password);
        } catch (NoInitialContextException e) {
            e.printStackTrace();
        } catch (NamingException e) {
            e.printStackTrace();
        } catch( RuntimeException e ) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
       // } catch (InstantiationException e) {
        //    e.printStackTrace();
       // } catch (IllegalAccessException e) {
       //     e.printStackTrace();
        //} catch (ClassNotFoundException e) {
        //    e.printStackTrace();
        }

        return connection;
    }
}