import javax.persistence.*;

@Entity
public class OneToMany_Book {
    @Id
    @GeneratedValue
    private long bookid;
    private String name;
    @ManyToOne
    @JoinTable(name ="employee_book_JoinTable",
                joinColumns = {@JoinColumn(name ="book_id",referencedColumnName = "bookid")},
                inverseJoinColumns = {@JoinColumn(name="employee_id",referencedColumnName = "id")})
    private OneToMany_Employee employee;
    public long getBookid() {
        return bookid;
    }

    public void setBookid(long bookid) {
        this.bookid = bookid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public OneToMany_Book(String name) {
        this.name = name;
    }

    public OneToMany_Book(){}
}
