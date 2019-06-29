package edu.mum.cs544;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name ="OrderCus")
public class Order {
    @Id
    @GeneratedValue
    private int orderId;
    @Temporal(TemporalType.DATE)
    private Date orderDate;

    @ManyToOne(cascade = CascadeType.ALL)
    private Customer customer;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Orderline> orderLines = new ArrayList<>();
    public Order(){}

    public Order(Date orderDate) {
        this.orderDate = orderDate;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    public void addOrderline(Orderline ol){
        this.orderLines.add(ol);
    }
    public List<Orderline> getOrderLines(){
        return this.orderLines;
    }
}
