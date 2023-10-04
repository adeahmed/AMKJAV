package data;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MariaDbConnection {
    private static Connection connection;

    private MariaDbConnection() {
    }

    public static Connection getInstance() {
        if (connection == null) {
            try {
                // Luo tietokantayhteys
                String url = "jdbc:mariadb://localhost:3306/data.sql";
                String username = "root";
                String password = "password123";
                connection = DriverManager.getConnection(url, username, password);
            } catch (SQLException e) {
                e.printStackTrace();

            }
        }
        return connection;
    }
}
