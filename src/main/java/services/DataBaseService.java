package services;

import groovy.xml.StreamingDOMBuilder;

import java.sql.*;

public class DataBaseService {

    static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
    static final String PASS = "gazette7";
    static final String USER = "postgres";

    Connection connection;
    Statement statement;

    public DataBaseService() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e.toString());
            throw new RuntimeException(e);
        }

        try {
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException e) {
            System.out.println(e.toString());
            throw new RuntimeException(e);
        }

        if (connection != null) {
            System.out.println("you successfully connected to DB");
        } else {
            System.out.println("что-то пошло не так");
        }
    }

    public void closeConnection() {
        try {
            connection.close();
            System.out.println("connection is closed");
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public Statement getStatement() {
        if (statement == null) {
            try {
                statement = this.connection.createStatement();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return statement;
    }

    public void executeSQL(String sql) { //insert, update,delete т к они не возвращают значения, а только true/false
        try {
            getStatement().execute(sql);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public ResultSet executeQuery(String sql) { // select, должен вернуть Result set, множество результатов
        try {
            return getStatement().executeQuery(sql);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }
}