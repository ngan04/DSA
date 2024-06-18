
import java.io.Serializable;

public class Students implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private String name;
    private double mark;

    public Students(String id, String name, double mark) {
        this.id = id;
        this.name = name;
        this.mark = mark;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMark() {
        return mark;
    }

    public void setMark(double mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "ID: " + id + " || Name: " + name + " || Marks: " + mark;
    }
}
