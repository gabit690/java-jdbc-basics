import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        String databaseUrl = "jdbc:mysql://localhost:3306/javasql";
        try (Connection myConnection = DriverManager.getConnection(databaseUrl, "root", "")) {
            System.out.println("DATABASE CONNECTED");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}