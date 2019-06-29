package edu.mum.cs544;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class App{

	private static EntityManagerFactory emf;
    public static void main(String[] args) throws Exception {
        emf = Persistence.createEntityManagerFactory("lab5ex2");
        		
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Patient patient = new Patient("North st","52556","IOWA","Patient 1");
        Doctor doctor = new Doctor("Therapist","Long","doctor");
        Payment payment = new Payment("1/1/2020",100);
        Appointment appointment = new Appointment("1/1/2020",patient,doctor,payment);
        em.persist(appointment);
        em.getTransaction().commit();
        em.close();

        // retieve appointment
        em = emf.createEntityManager();
        em.getTransaction().begin();
        TypedQuery<Appointment> query = em.createQuery("from Appointment", Appointment.class);
        List<Appointment> appList = query.getResultList();
        for (Appointment app : appList) {
            System.out.println("appointment date = " + app.getAppdate());
            System.out.println("Doctor = " + app.getDoctor().getFirstname());
            System.out.println("Patient = " + app.getPatient().getName());
            System.out.println("Payment amount = " + app.getPayment().getAmount());
        }
        em.getTransaction().commit();
        em.close();
    }
}

