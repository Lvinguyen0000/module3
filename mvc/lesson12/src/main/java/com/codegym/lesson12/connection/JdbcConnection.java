package com.codegym.lesson12.connection;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnection {
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String CONNECTION_URL = "jdbc:mysql://localhost:3306/student_management";
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "root";

    public static Connection getConnection(){
        Connection connection;
        try{
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(CONNECTION_URL, USERNAME, PASSWORD);
            return connection;
        }
        catch (ClassNotFoundException e){
            System.out.println("No driver found");
            e.printStackTrace();
        }
        catch (SQLException e){
            System.out.println("Something is wrong");
            e.printStackTrace();
        }
        return null;
    }
}
