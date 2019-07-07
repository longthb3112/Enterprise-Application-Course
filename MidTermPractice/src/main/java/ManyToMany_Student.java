import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class ManyToMany_Student {
    @Id
    @GeneratedValue
    private long id;

    private String name;

    @ManyToMany
    @JoinTable(name = "Pro_Stu")
    private List<ManyToMany_Professor> pros = new ArrayList<>();

    public ManyToMany_Student(){}
    public ManyToMany_Student(String name, List<ManyToMany_Professor> pros) {
        this.name = name;
        this.pros = pros;
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

    public List<ManyToMany_Professor> getPros() {
        return pros;
    }

    public void setPros(List<ManyToMany_Professor> pros) {
        this.pros = pros;
    }
}
