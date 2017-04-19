package com.bigmacdev.pharmacy_app;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



/**
 * Created by dev on 4/19/2017.
 */

public class DBConfig {

    private static final String USERNAME = "dev";
    private static final String PASSWORD = "Nofool01!";
    private static final String CONN = ("jdbc:mysql://10.0.0.34:3306/");
    private static final String DB = "allmed?useSSL=false";


    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection((CONN + DB), USERNAME, PASSWORD);
    }

    public static void displayException(SQLException ex) {
        System.out.println("Error Message: " + ex.getMessage());
        System.out.println("Error Code: " + ex.getErrorCode());
        System.out.println("SQL Status: " + ex.getSQLState());

    }
}


