package Dao;

import java.sql.*;

/**
 * Created by Администратор on 13.11.2016.
 */
public class SQLConnector {


    public static Connection getConnection() throws ClassNotFoundException, SQLException{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String connectionString =
                "jdbc:sqlserver://127.0.0.1:1433;"
                        + "database=repair;"
                        + "user=repair;"
                        + "password=123;";
        Connection connection = DriverManager.getConnection(connectionString);

        return connection;
    }

}