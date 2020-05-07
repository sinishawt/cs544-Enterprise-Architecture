package edu.mum.cs.cs544.exercises;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class Main {

    private static final SessionFactory sessionFactory;
    private static final ServiceRegistry serviceRegistry;

    static {
        Configuration configuration = new Configuration();
        configuration.configure();
        serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
                configuration.getProperties()).build();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    }

    public static void main(String[] args) throws ParseException {
        // Hibernate placeholders
        Session session = null;
        Transaction tx = null;

        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();
            //a
            Employee e1 = new Employee("John D Doe", new Department("IT Dep"), new Office(32, "Verri Hall"));
            
            session.persist(e1);
            //b
            Book b1 = new Book(125, "The Power of Postive Thinking", "Norman Pele", new Publisher("Tsehay"));
            
            session.persist(b1);
            //c
            Course c1 = new Course(223, "Intro to computers");
            Course c2 = new Course(344, "Programming");
            
            Student s1 = new Student("Abebe", "Fredrik", Arrays.asList(c1, c2));
            session.persist(s1);
            //d & e
            DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT, Locale.US);
            Customer cust1 = new Customer("King");
            Book book1 = new Book(475598, "The Hotel", "Mark Lenovo", new Publisher("Oracle"));
            Reservation r1 = new Reservation(df.parse("10/02/2020"), cust1, book1);
            session.persist(r1);
            //f
            Office o1 = new Office(75, "New Building");
            Department d1 = new Department("HR");
            Employee emp1 = new Employee("Jason", d1, o1);
            session.persist(emp1);

            tx.commit();

        } catch (HibernateException e) {
            if (tx != null) {
                System.err.println("Rolling back: " + e.getMessage());
                tx.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }

        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();

            // retieve
            @SuppressWarnings("unchecked")
            List<Employee> employees = session.createQuery("from Employee").list();
            for (Employee e : employees) {
                System.out.println("Employee Name: " + e.getName() + "Department: " + e.getDepartment().getName());
            }
            
            @SuppressWarnings("unchecked")
            List<Book> books = session.createQuery("from Book").list();
            for (Book b : books) {
                System.out.println("ISBN: " + b.getIsbn() + "Book Title: " + b.getTitle() + "Publisher: " + b.getPublisher().getName());
            }
            
            
            tx.commit();

        } catch (HibernateException e) {
            if (tx != null) {
                System.err.println("Rolling back: " + e.getMessage());
                tx.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }

        // Close the SessionFactory (not mandatory)
        sessionFactory.close();
        System.exit(0);
    }
}
