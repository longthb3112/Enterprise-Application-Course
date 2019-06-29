import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
public class Department {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name ="department_id")
    private List<Employee> employees = new ArrayList<Employee>();
    public Department(){}

    public Department(String name) {
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

    public List<Employee> getEmployees() {
        return employees;
    }

    public void addEmployee(Employee emp) {
        this.employees.add(emp);
    }
}
