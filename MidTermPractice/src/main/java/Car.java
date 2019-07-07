import javax.persistence.*;

@Entity
public class Car {
    @Id
    @GeneratedValue
    private long id;

    private String brand;

    public Car(){}

    public Car(String brand) {
        this.brand = brand;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
    @ManyToOne(cascade = CascadeType.ALL)
    //@JoinColumn(name = "customer_id_pk", referencedColumnName = "id")
    @JoinTable(name ="customer_car" ,
            inverseJoinColumns = {@JoinColumn(name ="customer_id",referencedColumnName = "id")},
            joinColumns = {@JoinColumn(name ="car_id" , referencedColumnName = "id")})
    private Customer customer;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
