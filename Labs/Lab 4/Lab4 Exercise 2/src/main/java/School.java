import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Entity
public class School {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<Integer, Student> getStudents() {
        return students;
    }

    public void addStudent(Student student) {
        this.students.put(student.getId(),student);
    }

    public School(String name) {
        this.name = name;
    }
public School(){}
    @Id
    @GeneratedValue
    private int id;
    private String name;

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
    @MapKey(name="id")
    private Map<Integer,Student> students = new HashMap<>();
}

