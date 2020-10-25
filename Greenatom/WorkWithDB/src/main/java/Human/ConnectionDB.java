package Human;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {

    static final String DB_URL = "jdbc:postgresql://localhost:5433/Greenatom";
    static final String USER = "postgres";
    static final String PASS = "postgrespass";
//
//    public ConnectionDB() {
//        getConnection();
//    }

    public Connection getConnection() {
        Connection connection = null;

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return connection;
        }

        try {
            connection = DriverManager
                    .getConnection(DB_URL, USER, PASS);

        } catch (SQLException e) {
            e.printStackTrace();
            return connection;
        }

        if (connection != null) {
            System.out.println("Connection");
        } else {
            System.out.println("Failed to make connection to database");
        }
        return connection;
    }
}
