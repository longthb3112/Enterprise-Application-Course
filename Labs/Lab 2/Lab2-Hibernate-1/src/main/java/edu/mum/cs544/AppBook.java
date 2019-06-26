package edu.mum.cs544;

import sun.util.resources.LocaleData;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class AppBook {
    private static EntityManagerFactory emf;
    public static void main(String[] args){
        emf = Persistence.createEntityManagerFactory("cs544");
        EntityManager entityManager = emf.createEntityManager();

        entityManager.getTransaction().begin();

        Book book1 = new Book("Book 1","124156","Long Tran",1000, new Date(2019,1,1,0,0));
        Book book2 = new Book("Book 2","124157","Long Tran",1000, new Date(2019,1,1,0,0));
        Book book3 = new Book("Book 3","124158","Long Tran",1000, new Date(2019,1,1,0,0));
        entityManager.persist(book1);
        entityManager.persist(book2);
        entityManager.persist(book3);

        entityManager.getTransaction().commit();
        entityManager.close();

        printAllBooks();

        //get one book to update
        entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();
        TypedQuery<Book> query1 = entityManager.createQuery("from Book", Book.class);
        List<Book> bookList1 = query1.getResultList();
        for (Book book : bookList1) {
            if(book.getISBN().equalsIgnoreCase("124156") ) {
                book.setPrice(1100);
                entityManager.merge(book);

            }else if(book.getISBN().equalsIgnoreCase("124157") ){
                entityManager.remove(book);
            }
        }
        entityManager.getTransaction().commit();
        entityManager.close();

        printAllBooks();
    }

    private static void printAllBooks() {
        EntityManager entityManager;
        entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();
        TypedQuery<Book> query = entityManager.createQuery("from Book", Book.class);
        List<Book> bookList = query.getResultList();
        for (Book book : bookList) {
            System.out.println("book id = " + book.getId()+ ", ISBN = "
                    + book.getISBN() + ", author = " + book.getAuthor() + ", price = " + book.getPrice());
        }
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
