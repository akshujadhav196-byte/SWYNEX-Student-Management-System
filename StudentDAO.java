import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDAO {

    // CREATE - Add student
    public void addStudent(Student student) {

        String sql = "INSERT INTO students (name, course, email) VALUES (?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, student.getName());
            statement.setString(2, student.getCourse());
            statement.setString(3, student.getEmail());

            statement.executeUpdate();

            System.out.println("Student added successfully!");

        } catch (SQLException e) {
            System.out.println("Error adding student: " + e.getMessage());
        }
    }

    // READ - View all students
    public void viewStudents() {

        String sql = "SELECT * FROM students";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            System.out.println("\n===== Student List =====");

            while (resultSet.next()) {

                System.out.println(
                    "ID: " + resultSet.getInt("id") +
                    " | Name: " + resultSet.getString("name") +
                    " | Course: " + resultSet.getString("course") +
                    " | Email: " + resultSet.getString("email")
                );
            }

        } catch (SQLException e) {
            System.out.println("Error viewing students: " + e.getMessage());
        }
    }

    // UPDATE - Update student
    public void updateStudent(int id, String name, String course, String email) {

        String sql = "UPDATE students SET name = ?, course = ?, email = ? WHERE id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, name);
            statement.setString(2, course);
            statement.setString(3, email);
            statement.setInt(4, id);

            int rows = statement.executeUpdate();

            if (rows > 0) {
                System.out.println("Student updated successfully!");
            } else {
                System.out.println("Student not found.");
            }

        } catch (SQLException e) {
            System.out.println("Error updating student: " + e.getMessage());
        }
    }

    // DELETE - Delete student
    public void deleteStudent(int id) {

        String sql = "DELETE FROM students WHERE id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);

            int rows = statement.executeUpdate();

            if (rows > 0) {
                System.out.println("Student deleted successfully!");
            } else {
                System.out.println("Student not found.");
            }

        } catch (SQLException e) {
            System.out.println("Error deleting student: " + e.getMessage());
        }
    }
}