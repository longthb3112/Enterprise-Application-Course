package edu.mum.cs544;



import javax.persistence.*;

@Entity
@SecondaryTable(name = "Address", pkJoinColumns = {
        @PrimaryKeyJoinColumn(name = "patient_id", referencedColumnName = "id")
})
public class Patient {
    @Id
    @GeneratedValue
    private long id;

    @Column(table = "Address")
    private String street;
    @Column(table = "Address")
    private String zip;
    @Column(table = "Address")
    private String city;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }


    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public long getId(){
        return this.id;
    }
    public Patient(){}

    public Patient(String street, String zip, String city, String name) {
        this.street = street;
        this.zip = zip;
        this.city = city;
        this.name = name;
    }
}
