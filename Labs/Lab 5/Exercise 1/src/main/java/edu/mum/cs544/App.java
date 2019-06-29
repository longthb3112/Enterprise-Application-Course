package edu.mum.cs544;

import com.sun.org.apache.xpath.internal.operations.Or;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.Date;
import java.util.List;

public class App {
    private static EntityManagerFactory emf;
    public static void main(String[] args) throws Exception {
     emf = Persistence.createEntityManagerFactory("lab5ex1");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Customer customer = new Customer("Long","Tran");
        Order order = new Order(new Date());

        Product book =  new Book("Product 1","book","book 1");
        Product cd =  new CD("Product 2","cd","Long Tran");
        Product dvd =  new DVD("Product 1","book","DVD 1");
        Orderline orderline1 = new Orderline(2, book);
        Orderline orderline2 = new Orderline(1, cd);
        Orderline orderline3 = new Orderline(3, dvd);

        order.setCustomer(customer);
        order.addOrderline(orderline1);
        order.addOrderline(orderline2);
        order.addOrderline(orderline3);
        em.persist(order);
        em.getTransaction().commit();
        em.close();

        // retieve all cars
        em = emf.createEntityManager();
        em.getTransaction().begin();
        TypedQuery<Order> query = em.createQuery("from Order", Order.class);
        List<Order> ordList = query.getResultList();
        for (Order ord : ordList) {
            System.out.println("customer name = " + ord.getCustomer().getFirstName()
                + " order date = " + ord.getOrderDate());
            if(ord.getOrderLines() != null && ord.getOrderLines().size() > 0){
                for(Orderline ol: ord.getOrderLines()){
                    System.out.println("quantity = "+ ol.getQuantity() +" product name= " + ol.getProduct().getName());
                }
            }
        }
        em.getTransaction().commit();
        em.close();
    }
}
