package services;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseService {

    static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
    static final String PASS = "gazette7";
    static final String USER = "postgres";

    Connection connection;

    public DataBaseService() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e.toString());
            throw new RuntimeException(e);
        }

        try {
            DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException e) {
            System.out.println(e.toString());
            throw new RuntimeException(e);
        }

        if (connection != null ){
            System.out.println("you successfully connected to DB");
        } else {
            System.out.println("что-то пошло не так");
        }
    }
}
