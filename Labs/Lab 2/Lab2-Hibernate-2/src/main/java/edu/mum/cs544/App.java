package edu.mum.cs544;

import org.hibernate.internal.build.AllowSysOut;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class App {
    private static EntityManagerFactory emf;
    public static void main(String[] args){
        emf = Persistence.createEntityManagerFactory("simpsons");
        //get all students
        getAllStudents();

        EntityManager entityManager;
        entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();
        if(entityManager.createQuery("SELECT s From edu.mum.cs544.Students s WHERE s.id = 1",Students.class).getResultList().size() == 0){
            Students stu = new Students(1,"Long","hbtran@mum.edu","1234");
            entityManager.persist(stu);
            entityManager.getTransaction().commit();
            entityManager.close();
        }

        //get all students
        getAllStudents();

    }

    private static void getAllStudents() {
        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();
        TypedQuery<Students> query = entityManager.createQuery("from edu.mum.cs544.Students",Students.class);
        List<Students> students = query.getResultList();
        for (Students student:students){
            System.out.println("student id = " +student.getId() + ", name = "
                    + student.getName() + ", email = " + student.getEmail());
        }
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
