import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Employee {
    @Id
    @GeneratedValue
    private int id;
    private String name;
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
    @OneToMany(mappedBy="owner",cascade = CascadeType.ALL,orphanRemoval = true)
    @OrderBy("id ASC")
    private Set<Laptop> laptops = new HashSet<>();
    public void addLaptop(Laptop laptop){
        laptops.add(laptop);
        laptop.setEmployee(this);
    }
    public Set<Laptop> getLaptops(){
        return laptops;
    }

}
