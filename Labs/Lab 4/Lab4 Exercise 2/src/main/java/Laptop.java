import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Objects;

@Entity
public class Laptop {
    @Id
    private int id;
    private String brand;
    public Laptop(){}
    public Laptop(int id, String brand) {
        this.id = id;
        this.brand = brand;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }



    public void setBrand(String brand) {
        this.brand = brand;
    }

    @ManyToOne
    private Employee owner;
    public void setEmployee(Employee emp){
        this.owner = emp;
    }
    public Employee getEmployee(){
        return owner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Laptop laptop = (Laptop) o;
        return id == laptop.id &&
                Objects.equals(brand, laptop.brand);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, brand);
    }
}
