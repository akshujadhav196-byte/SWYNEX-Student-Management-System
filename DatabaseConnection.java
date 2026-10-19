import java.sql.Connection;

public class DatabaseConnection {

    public static void main(String[] args) {

        Connection connection = DatabaseConnection.getConnection();

        if (connection != null) {
            System.out.println("Database connected successfully!");
        }
    }

    private static final String URL =
            "jdbc:mysql://localhost:3306/student_management";

    private static final String USER = "root";

    private static final String PASSWORD = "admin@123";

    public static Connection getConnection() {

        try {
            return java.sql.DriverManager.getConnection(URL, USER, PASSWORD);

        } catch (Exception e) {
            System.out.println("Database connection failed!");
            e.printStackTrace();
            return null;
        }
    }
}