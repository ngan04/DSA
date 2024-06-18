import java.io.Serializable;
import java.util.ArrayList;

import java.util.List;

public class Classrooms implements Serializable {
    private static final long serialVersionUID = 1L;

    private String className;
    private List<Students> students;
    private int maxStudents;

    public Classrooms(String className,int maxStudents) {
        this.className = className;
        this.students = new ArrayList<>();
        this.maxStudents = maxStudents;
    }
    public String getClassName() {
        return className;
    }

    public List<Students> getStudents() {
        return students;
    }
    public int getMaxStudents() {
        return maxStudents;
    }

    public void addStudent(Students student) {
        students.add(student);
    }
    public int getRemainingSlots() {
        return maxStudents - students.size();
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Class: ").append(className).append("\n");
        for (Students student : students) {
            sb.append(student).append("\n");
        }
        return sb.toString();
    }
}