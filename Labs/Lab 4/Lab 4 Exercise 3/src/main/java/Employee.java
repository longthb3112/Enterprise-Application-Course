import javax.persistence.*;
import java.nio.MappedByteBuffer;

@Entity
public class Employee {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    @ManyToOne(cascade = CascadeType.ALL)
    private Office office;
    public Employee(){}

    public Employee(String name) {
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
    @ManyToOne
    @JoinColumn(name ="department_id",insertable = false,updatable = false)
    private Department department;

    public Department getDepartment(){
        return this.department;
    }
    public void setOffice(Office office){
        this.office = office;
    }
    public Office getOffice(){
        return this.office;
    }
}
