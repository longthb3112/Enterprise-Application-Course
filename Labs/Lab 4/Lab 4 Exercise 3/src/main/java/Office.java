import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Office {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    @OneToMany(mappedBy = "office")
    private List<Employee> employees = new ArrayList<>();
    public Office(){}

    public Office(String name) {
        this.name = name;
    }

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
}
