import org.hibernate.tuple.GeneratedValueGeneration;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Passenger {
    public Passenger(){}
    public Passenger(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Flight> getFlights() {
        return fights;
    }

    public void setFight(Flight flight) {
        this.fights.add(flight);
    }

    @Id
    @GeneratedValue
    private int id;
    private String name;

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Flight> fights = new ArrayList<>();


}
