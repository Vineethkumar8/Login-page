import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseHelper{
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/mydatabase"; // Update with your database name
    private static final String JDBC_USERNAME = "sensen"; // Your MySQL username (replace with your credentials)
    private static final String JDBC_PASSWORD = "admin"; // Your MySQL password (replace with your password)

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
    }
}

