
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Manament sm = new Manament();

        System.out.print("Enter classroom name: ");
        String className = sc.nextLine();
        System.out.print("Enter number of students: ");
        int numStudents = sc.nextInt();
        sc.nextLine();
        sm.createClassroom(className, numStudents);

        boolean exit = false;
        while (!exit) {
            System.out.println("\nMenu:");
            System.out.println("1. Add student");
            System.out.println("2. Edit student");
            System.out.println("3. Delete student");
            System.out.println("4. Sort students (Quick Sort)");
            System.out.println("5. Sort students (Selection Sort)");
            System.out.println("6. Search student");
            System.out.println("7. Display students");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    // Add student
                    System.out.println("Enter details for the student:");
                    System.out.print("Enter student ID: ");
                    String id = sc.nextLine();
                    System.out.print("Enter student name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter student marks: ");
                    double marks = sc.nextDouble();
                    sc.nextLine(); // consume newline
                    Students student = new Students(id, name, marks);
                    sm.addStudentToClassroom(className, student);
                    break;

                case 2:
                    // Edit student
                    System.out.print("Enter the ID of the student to edit: ");
                    String editId = sc.nextLine();
                    System.out.print("Enter new name: ");
                    String newName = sc.nextLine();
                    System.out.print("Enter new marks: ");
                    double newMarks = sc.nextDouble();
                    sc.nextLine(); // consume newline
                    sm.editStudentInClassroom(className, editId, newName, newMarks);
                    break;

                case 3:
                    // Delete student
                    System.out.print("Enter the ID of the student to delete: ");
                    String deleteId = sc.nextLine();
                    sm.deleteStudentFromClassroom(className, deleteId);
                    break;

                case 4:
                    // Sort students (Quick Sort)
                    sm.quickSortStudentsInClassroom(className);
                    System.out.println("Students sorted by marks (Quick Sort).");
                    break;

                case 5:
                    // Sort students (Selection Sort)
                    sm.selectionSortStudentsInClassroom(className);
                    System.out.println("Students sorted by marks (Selection Sort).");
                    break;

                case 6:
                    // Search student
                    System.out.print("Enter the ID of the student to search: ");
                    String searchId = sc.nextLine();
                    Students foundStudent = sm.searchStudentInClassroom(className, searchId);
                    if (foundStudent != null) {
                        System.out.println("Found student: " + foundStudent);
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                case 7:
                    // Display students
                    System.out.println("Student information for classroom " + className + ":");
                    sm.displayStudentInfo(className);
                    break;

                case 8:
                    // Exit
                    exit = true;
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
        sc.close();
    }
}
