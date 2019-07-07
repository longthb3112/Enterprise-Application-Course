import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class ManyToMany_Professor {
    @Id
    @GeneratedValue
    private long id;
    @ManyToMany(mappedBy = "pros")
    private List<ManyToMany_Student> students = new ArrayList<>()
;    private String name;
    public ManyToMany_Professor(){}

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

    public ManyToMany_Professor(String name) {
        this.name = name;
    }
}
