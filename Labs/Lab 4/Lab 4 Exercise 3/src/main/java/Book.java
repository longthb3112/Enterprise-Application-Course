import javax.persistence.*;

@Entity
public class Book {
    @Id
    @GeneratedValue
    private int id;
    private String isbn;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinTable(name="book_publisher",
            joinColumns = {@JoinColumn(name ="publisher_id")},
            inverseJoinColumns ={@JoinColumn(name ="book_id")} )
    private Publisher publisher;
    public Book(){}

    public Book(String isbn, Publisher publisher) {
        this.isbn = isbn;
        this.publisher = publisher;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }
}
