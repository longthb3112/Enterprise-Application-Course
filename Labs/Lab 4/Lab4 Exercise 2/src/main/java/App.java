import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Set;

public class App {
    private static EntityManagerFactory emf;
    public static void main(String[] args){

        emf = Persistence.createEntityManagerFactory("lab4ex2");

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Employee employee1 = new Employee("Long 1");
        employee1.addLaptop(new Laptop(1,"IBM"));
        employee1.addLaptop(new Laptop(3,"Surface"));
        Employee employee2 = new Employee("Long 2");
        employee2.addLaptop(new Laptop(2,"Apple"));

        em.persist(employee1);
        em.persist(employee2);
        em.getTransaction().commit();
        em.close();

        // retieve all Employee
        em = emf.createEntityManager();
        em.getTransaction().begin();
        TypedQuery<Employee> query = em.createQuery("from Employee", Employee.class);
        List<Employee> empList = query.getResultList();
        for (Employee emp : empList) {
            System.out.println("employee name = " + emp.getName()
                    + " laptop = " + emp.getLaptops().stream().findFirst().get().getBrand());
        }

        em.getTransaction().commit();
        em.close();

        //////////////////////////////Create Passenger//////////////////////////////////
        em = emf.createEntityManager();
        em.getTransaction().begin();
        Passenger pas1 = new Passenger("Long 1");
        pas1.setFight(new Flight(1,"VA123","VN","US"));

        Passenger pas2 = new Passenger("Long 2");
        pas2.setFight(new Flight(2,"US123","US","VN"));

        em.persist(pas1);
        em.persist(pas2);
        em.flush();
        em.getTransaction().commit();
        em.close();

        // retieve all Passenger
        em = emf.createEntityManager();
        em.getTransaction().begin();
        TypedQuery<Passenger> query1 = em.createQuery("from Passenger", Passenger.class);
        List<Passenger> psList = query1.getResultList();
        for (Passenger pas : psList) {
            System.out.println("passenger name = " + pas.getName()
                    + " fight number = " + pas.getFlights().get(0).getFlightNumber());
        }

        ////////////////////////School-Student////////////////////
        em = emf.createEntityManager();
        em.getTransaction().begin();
        School school1 = new School("school 1");
        school1.addStudent(new Student(1,"Long 1"));
        School school2 = new School("school 2");
        school2.addStudent(new Student(2,"Long 2"));

        em.persist(school1);
        em.persist(school2);

        em.getTransaction().commit();
        em.close();

        // retieve all Passenger
        em = emf.createEntityManager();
        em.getTransaction().begin();
        TypedQuery<School> query2 = em.createQuery("from School", School.class);
        List<School> scList = query2.getResultList();
        for (School school : scList) {
            System.out.println("school name = " + school.getName()
                    + " student name = " + school.getStudents().values().stream().findFirst().get().getName());
        }

    }
}
