package ua.edu.ucu.apps.task2;

import java.sql.*;
import java.util.List;

public class database {
    public static final String DATABASE_URL = "jdbc:sqlite:cache.sqlite";

    public static Connection prepareConnection() throws SQLException {
        Connection connection = DriverManager.getConnection(DATABASE_URL);
        PreparedStatement preparedStatement = connection.prepareStatement(
                "CREATE TABLE IF NOT EXISTS cache (id INTEGER PRIMARY KEY, location TEXT, data TEXT)"
        );
        preparedStatement.execute();
        preparedStatement.close();

        return connection;
    }

    public static List<String> getCache(String location) throws SQLException {
        String parse;

        Connection connection = prepareConnection();
        PreparedStatement statement = connection.prepareStatement(
                "SELECT data FROM cache WHERE location = ?"
        );
        statement.setString(1, location);

        ResultSet response = statement.executeQuery();

        if (response.next()) {
            parse = response.getString("data");
            connection.close();
        } else {
            return List.of();
        }
        return List.of(parse.split(", "));
    }

    public static void setCache(String location, List<String> data) throws SQLException {
        String parse = String.join(", ", data);

        Connection connection = prepareConnection();
        PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO cache (location, data) VALUES (?, ?)"
        );

        statement.setString(1, location);
        statement.setString(2, parse);
        statement.execute();

        statement.close();
        connection.close();
    }
}
