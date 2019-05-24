package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBC {

    public static Connection connect() throws SQLException, ClassNotFoundException {

        Connection connection = null;

        String url = "jdbc:postgresql://localhost:5432/TaskManager";
        String name = "postgres";
        String password = "123";
        Class.forName("org.postgresql.Driver");
        connection = DriverManager.getConnection(url, name, password);


        return connection;
    }
}