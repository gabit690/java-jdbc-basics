import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        String databaseUrl = System.getenv("DATABASE_URL");
        String user = System.getenv("USER");
        String password = System.getenv("PASSWORD");
        try (Connection myConnection = DriverManager.getConnection(
                databaseUrl,
                user,
                password)) {
            System.out.println("DATABASE CONNECTED");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}