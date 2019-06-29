import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.Date;
import java.util.List;

public class App {
    private static EntityManagerFactory emf;
    public static void main(String[] args){

        //Create a Bidirectional OneToMany association between Department and Employee using annotations.
        emf = Persistence.createEntityManagerFactory("lab4ex3");
        EntityManager entityManager = emf.createEntityManager();

        entityManager.getTransaction().begin();

        Department department1 = new Department("Deparment 1");
        department1.addEmployee(new Employee("Long 1"));
        Department department2 = new Department("Deparment 2");
        department2.addEmployee(new Employee("Long 2"));
        entityManager.persist(department1);
        entityManager.persist(department2);

        entityManager.getTransaction().commit();
        entityManager.close();
        printDepartmentInfo();

        //Create an Optional Unidirectional ManyToOne association between Book and
        //Publisher using annotations and without using NULL fields in the database
        entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();
        Book book1 = new Book("123",new Publisher("Long 1"));
        Book book2 = new Book("123",new Publisher("Long 1"));
        entityManager.persist(book1);
        entityManager.persist(book2);
        entityManager.getTransaction().commit();
        entityManager.close();
        printBookInfo();

        //Create a Bidirectional ManyToMany association between Student and Course
        //using annotations. Be sure to make studentid values application assigned (not generated)!
        entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();
        Student student1 = new Student(1, "Long 1");
        student1.addCourse(new Course("course 1"));
        Student student2 = new Student(2, "Long 2");
        student2.addCourse(new Course("course 2"));
        entityManager.persist(student1);
        entityManager.persist(student2);
        entityManager.getTransaction().commit();
        entityManager.close();
        printStudentInfo();

        //Create a Unidirectional OneToMany association between Customer and
        //Reservation using annotations.
        entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();
        Customer customer1 = new Customer("Long 1");
        customer1.addReservation(new Reservation("day 1",new Date()));
        Customer customer2 = new Customer("Long 1");
        customer2.addReservation(new Reservation("day 2",new Date()));
        entityManager.persist(customer1);
        entityManager.persist(customer2);
        entityManager.getTransaction().commit();
        entityManager.close();
        printCustomerInfo();

        //Create a Unidirectional ManyToOne association between Reservation and
        //Book using annotations.
        entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();
        Reservation reservation1 = new Reservation("description 1",new Date());
        reservation1.setBook(new Book("12345",new Publisher("Long 4")));
        entityManager.persist(reservation1);
        entityManager.getTransaction().commit();
        entityManager.close();
        printReservationInfo();

        //Create a Bidirectional ManyToOne association between Employee and Office
        //using annotations.
        entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();
        Employee emp = new Employee("Long 4");
        emp.setOffice(new Office("Office 1"));
        entityManager.persist(emp);
        entityManager.getTransaction().commit();
        entityManager.close();
        printEmployeeOfficeInfo();
    }
    private static void printDepartmentInfo(){
        // retieve all Employee
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        TypedQuery<Department> query = em.createQuery("from Department", Department.class);
        List<Department> dptList = query.getResultList();
        for (Department dpt : dptList) {
            System.out.println("Department name = " + dpt.getName()
                    + " Employee name = " + dpt.getEmployees().get(0).getName());
        }

        em.getTransaction().commit();
        em.close();

    }
    private static void printBookInfo(){
        // retieve all Book
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        TypedQuery<Book> query = em.createQuery("from Book", Book.class);
        List<Book> bookList = query.getResultList();
        for (Book book : bookList) {
            System.out.println("Book isbn = " + book.getIsbn()
                    + " publisher name = " + book.getPublisher().getName());
        }

        em.getTransaction().commit();
        em.close();
    }
    private static void printStudentInfo(){
        // retieve all Student
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        TypedQuery<Student> query = em.createQuery("from Student", Student.class);
        List<Student> stuList = query.getResultList();
        for (Student stu : stuList) {
            System.out.println("Student name = " + stu.getName()
                    + " course name = " + stu.getCourses().get(0).getName());
        }

        em.getTransaction().commit();
        em.close();

    }
    private static void printCustomerInfo(){
        // retieve all Student
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        TypedQuery<Customer> query = em.createQuery("from Customer", Customer.class);
        List<Customer> cusList = query.getResultList();
        for (Customer cus : cusList) {
            System.out.println("Customer name = " + cus.getName()
                    + " description = " + cus.getReservations().get(0).getDescription()
                    + " reserved time =" + cus.getReservations().get(0).getReserveTime());
        }

        em.getTransaction().commit();
        em.close();
    }
    private static void printReservationInfo(){
        // retieve all Student
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        TypedQuery<Reservation> query = em.createQuery("from Reservation", Reservation.class);
        List<Reservation> resList = query.getResultList();
        for (Reservation res : resList) {
            if(res.getBook() != null){
                System.out.println("Reservation description = " + res.getDescription()
                        + " reserved time =" +res.getReserveTime()
                        + " book isbn =" + res.getBook().getIsbn());
            }
        }

        em.getTransaction().commit();
        em.close();
    }
    private static void printEmployeeOfficeInfo(){
        // retieve all Student
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        TypedQuery<Employee> query = em.createQuery("from Employee", Employee.class);
        List<Employee> empList = query.getResultList();
        for (Employee emp : empList) {
            if(emp.getOffice() != null){
                System.out.println("Employee name  = " + emp.getName()
                        + " office name = " + emp.getOffice().getName());
            }
        }

        em.getTransaction().commit();
        em.close();
    }
}
