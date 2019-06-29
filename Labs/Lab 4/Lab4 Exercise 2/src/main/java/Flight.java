import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Flight {
    @Id
    private int id;
    private String flightNumber;
    public Flight(){}
    public Flight(int id, String flightNumber, String from, String to) {
        this.id = id;
        this.flightNumber = flightNumber;
        From = from;
        To = to;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getFrom() {
        return From;
    }

    public void setFrom(String from) {
        From = from;
    }

    public String getTo() {
        return To;
    }

    public void setTo(String to) {
        To = to;
    }

    @Column(name="departure")
    private String From;
    @Column(name="arrive")
    private String To;
}
