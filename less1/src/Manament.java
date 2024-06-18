
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.io.*;

public class Manament {
    private List<Classrooms> classrooms;
    private static final String FILENAME = "manament.txt";

    public Manament() {
        classrooms = new ArrayList<>();
        loadClassrooms();
    }

    public void createClassroom(String className, int maxStudents) {
        Classrooms classroom = new Classrooms(className, maxStudents);
        classrooms.add(classroom);
        saveClassrooms();
    }

    public void addStudentToClassroom(String className, Students student) {
        for (Classrooms classroom : classrooms) {
            if (classroom.getClassName().equals(className)) {
                classroom.addStudent(student);
                saveClassrooms();
                return;
            }
        }
        System.out.println("Classroom not found.");
    }

    public void editStudentInClassroom(String className, String studentId, String newName, double newMark) {
        for (Classrooms classroom : classrooms) {
            if (classroom.getClassName().equals(className)) {
                for (Students student : classroom.getStudents()) {
                    if (student.getId().equals(studentId)) {
                        student.setName(newName);
                        student.setMark(newMark);
                        saveClassrooms();
                        return;
                    }
                }
            }
        }
        System.out.println("Student not found.");
    }

    public void deleteStudentFromClassroom(String className, String studentId) {
        for (Classrooms classroom : classrooms) {
            if (classroom.getClassName().equals(className)) {
                List<Students> students = classroom.getStudents();
                students.removeIf(student -> student.getId().equals(studentId));
                saveClassrooms();
                return;
            }
        }
        System.out.println("Student not found.");
    }

    public void quickSortStudentsInClassroom(String className) {
        for (Classrooms classroom : classrooms) {
            if (classroom.getClassName().equals(className)) {
                List<Students> students = classroom.getStudents();
                quickSort(students, 0, students.size() - 1);
                saveClassrooms();
                return;
            }
        }
        System.out.println("Classroom not found.");
    }

    private void quickSort(List<Students> students, int low, int high) {
        if (low < high) {
            int pi = partition(students, low, high);

            quickSort(students, low, pi - 1);
            quickSort(students, pi + 1, high);
        }
    }

    private int partition(List<Students> students, int low, int high) {
        double pivot = students.get(high).getMark();
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (students.get(j).getMark() < pivot) {
                i++;

                Students temp = students.get(i);
                students.set(i, students.get(j));
                students.set(j, temp);
            }
        }

        Students temp = students.get(i + 1);
        students.set(i + 1, students.get(high));
        students.set(high, temp);

        return i + 1;
    }

    public void selectionSortStudentsInClassroom(String className) {
        for (Classrooms classroom : classrooms) {
            if (classroom.getClassName().equals(className)) {
                List<Students> students = classroom.getStudents();
                selectionSort(students);
                saveClassrooms();
                return;
            }
        }
        System.out.println("Classroom not found.");
    }

    private void selectionSort(List<Students> students) {
        int n = students.size();

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (students.get(j).getMark() < students.get(minIndex).getMark()) {
                    minIndex = j;
                }
            }

            Students temp = students.get(minIndex);
            students.set(minIndex, students.get(i));
            students.set(i, temp);
        }
    }

    public Students searchStudentInClassroom(String className, String studentId) {
        for (Classrooms classroom : classrooms) {
            if (classroom.getClassName().equals(className)) {
                for (Students student : classroom.getStudents()) {
                    if (student.getId().equals(studentId)) {
                        return student;
                    }
                }
            }
        }
        System.out.println("Student not found.");
        return null;
    }

    public void displayStudentInfo(String className) {
        for (Classrooms classroom : classrooms) {
            if (classroom.getClassName().equals(className)) {
                for (Students student : classroom.getStudents()) {
                    System.out.println("ID: " + student.getId());
                    System.out.println("Name: " + student.getName());
                    System.out.println("Marks: " + student.getMark());
                    System.out.println("Ranking: " + getRanking(student.getMark()));
                    System.out.println("---------------");
                }
                return;
            }
        }
        System.out.println("Classroom not found.");
    }

    private String getRanking(double marks) {
        if (marks < 5.0) {
            return "Fail";
        } else if (marks < 6.5) {
            return "Medium";
        } else if (marks < 7.5) {
            return "Good";
        } else if (marks < 9.0) {
            return "Very Good";
        } else {
            return "Excellent";
        }
    }

    private void loadClassrooms() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILENAME))) {
            classrooms = (List<Classrooms>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("No previous data found, starting fresh.");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading classrooms: " + e.getMessage());
        }
    }

    private void saveClassrooms() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILENAME))) {
            oos.writeObject(classrooms);
        } catch (IOException e) {
            System.err.println("Error saving classrooms: " + e.getMessage());
        }
    }
}

