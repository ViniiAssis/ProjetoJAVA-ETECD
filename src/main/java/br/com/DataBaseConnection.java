package br.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {
    private static final String URL = "jbdc:postgresql://localhost:5432/teste_db";

    private static final String USER = "user";
    private static final String PASSWORD = "0910";

    public static Connection getConnection()
        throws SQLException{
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
