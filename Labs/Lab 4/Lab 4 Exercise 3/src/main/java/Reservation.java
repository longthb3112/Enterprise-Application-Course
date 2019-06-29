import javax.persistence.*;
import java.util.Date;

@Entity
public class Reservation {
    @Id
    @GeneratedValue
    private int id;
    private String description;
    @Temporal(TemporalType.DATE)
    private Date reserveTime;
    @ManyToOne(cascade = CascadeType.ALL)
    private Book book;
    public Reservation(){}

    public Reservation(String description, Date reserveTime) {
        this.description = description;
        this.reserveTime = reserveTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getReserveTime() {
        return reserveTime;
    }

    public void setReserveTime(Date reserveTime) {
        this.reserveTime = reserveTime;
    }
    public void setBook(Book book){
        this.book = book;
    }
    public Book getBook(){
        return this.book;
    }
}
