import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
public class OneToMany_Employee {
    @Id
    @GeneratedValue
    private long id;

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

    public List<OneToMany_Book> getBooks() {
        return books;
    }

    public void setBooks(List<OneToMany_Book> books) {
        this.books = books;
    }

    public OneToMany_Employee(String name, List<OneToMany_Book> books) {
        this.name = name;
        this.books = books;
    }

    private String name;
    @OneToMany(mappedBy = "employee")
    //@JoinColumn(name ="Empployee_book")
//    @JoinTable(name ="EMP_BOOK",
//               joinColumns = {@JoinColumn(name = "emp_id" , referencedColumnName = "id")},
//                inverseJoinColumns = {@JoinColumn(name ="book_id" , referencedColumnName = "bookid")})
    private List<OneToMany_Book> books = new ArrayList<>();
    public OneToMany_Employee(){}

}
