import java.util.Scanner;

public class StudentManagementSystem {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        StudentDAO studentDAO = new StudentDAO();

        int choice = 0;

        while (choice != 5) {

            System.out.println("\n===== Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");

            try {

                choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {

                    case 1:

                        System.out.print("Enter Student Name: ");
                        String name = scanner.nextLine().trim();

                        if (name.isEmpty()) {
                            System.out.println("Name cannot be empty.");
                            break;
                        }

                        System.out.print("Enter Course: ");
                        String course = scanner.nextLine().trim();

                        if (course.isEmpty()) {
                            System.out.println("Course cannot be empty.");
                            break;
                        }

                        System.out.print("Enter Email: ");
                        String email = scanner.nextLine().trim();

                        if (!email.contains("@") || !email.contains(".")) {
                            System.out.println("Please enter a valid email.");
                            break;
                        }

                        Student student =
                                new Student(name, course, email);

                        studentDAO.addStudent(student);

                        break;

                    case 2:

                        studentDAO.viewStudents();

                        break;

                    case 3:

                        System.out.print("Enter Student ID to update: ");
                        int updateId = Integer.parseInt(scanner.nextLine());

                        if (updateId <= 0) {
                            System.out.println("Invalid Student ID.");
                            break;
                        }

                        System.out.print("Enter New Name: ");
                        String newName = scanner.nextLine().trim();

                        if (newName.isEmpty()) {
                            System.out.println("Name cannot be empty.");
                            break;
                        }

                        System.out.print("Enter New Course: ");
                        String newCourse = scanner.nextLine().trim();

                        if (newCourse.isEmpty()) {
                            System.out.println("Course cannot be empty.");
                            break;
                        }

                        System.out.print("Enter New Email: ");
                        String newEmail = scanner.nextLine().trim();

                        if (!newEmail.contains("@") || !newEmail.contains(".")) {
                            System.out.println("Please enter a valid email.");
                            break;
                        }

                        studentDAO.updateStudent(
                                updateId,
                                newName,
                                newCourse,
                                newEmail
                        );

                        break;

                    case 4:

                        System.out.print("Enter Student ID to delete: ");
                        int deleteId = Integer.parseInt(scanner.nextLine());

                        if (deleteId <= 0) {
                            System.out.println("Invalid Student ID.");
                            break;
                        }

                        studentDAO.deleteStudent(deleteId);

                        break;

                    case 5:

                        System.out.println(
                                "Thank you for using Student Management System!"
                        );

                        break;

                    default:

                        System.out.println(
                                "Invalid choice! Please select 1-5."
                        );
                }

            } catch (NumberFormatException e) {

                System.out.println(
                        "Invalid input! Please enter a number."
                );
            }
        }

        scanner.close();
    }
}