package edu.mum.cs.cs544.exercises;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class App {

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
            Employee e1 = new Employee("John", "Cena");
            Set<Laptop> laptops = new HashSet<Laptop>();
            
            Laptop l1 = new Laptop("Apple", "Mac Book Pro");
            Laptop l2 = new Laptop("Lenovo", "G70");
            
            l1.setEmployee(e1);
            l2.setEmployee(e1);
            
            laptops.add(l1);
            laptops.add(l2);
            
            
            e1.setLaptops(laptops);
            
            session.persist(e1);

            //b
            DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT, Locale.US);
            List<Flight> flights = new ArrayList<Flight>();
            
            Flight f1 = new Flight("ETT-255", "Nirobi Kenya", "ADD", df.parse("10/02/2020"));
            Flight f2 = new Flight("DXB-444", "Dubai", "Frankfurt Germany", df.parse("07/11/2022"));
            
            flights.add(f1);
            flights.add(f2);
            
            Passenger p1 = new Passenger("Steve Jobs", flights);
            
            session.persist(p1);
            
            //c
            
            Map<String, Student> students = new HashMap<String, Student>();
            
            Student s1 = new Student("123", "Will", "Smith");
            Student s2 = new Student("224", "Angelina", "Jolli");
            Student s3 = new Student("321", "Jonny", "English");
            
            students.put("123", s1);
            students.put("224", s2);
            students.put("321", s3);
            
            School school1 = new School("MIU", students);
            
            
            session.persist(school1);
            

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
                System.out.println("Employee Name: " + e.getFirstname() + " " + e.getLastname() + "Laptops: " + e.getLaptops().toString());
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
