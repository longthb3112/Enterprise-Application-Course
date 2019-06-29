package edu.mum.cs544;

import javax.persistence.*;

@Entity
public class Orderline {
    @Id
    @GeneratedValue
    private int id;
    private int quantity;
    @ManyToOne(cascade = CascadeType.ALL)
    private Product product;
    public Orderline(){}

    public Orderline(int quantity, Product product) {
        this.quantity = quantity;
        this.product = product;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
