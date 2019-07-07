import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@SecondaryTables({@SecondaryTable(name ="table 1"), @SecondaryTable(name ="table 2")})
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;

    @OneToMany(mappedBy = "customer")
    private List<Car> cars = new ArrayList<>();
    public Customer(){}
    public Customer(String name) {
        this.name = name;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
