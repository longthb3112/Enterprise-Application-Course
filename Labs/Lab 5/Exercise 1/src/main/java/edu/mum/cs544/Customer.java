package edu.mum.cs544;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Customer {
    @Id
    @GeneratedValue
    private int id;
    private String firstName;
    private String lastName;
    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
    private List<Order> orders = new ArrayList<>();
    public Customer(){}

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void addOrder(Order order){
        this.orders.add(order);
    }
    public List<Order> getOrders(){
        return this.orders;
    }
}
