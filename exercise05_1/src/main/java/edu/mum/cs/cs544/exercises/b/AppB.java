package edu.mum.cs.cs544.exercises.b;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.List;
import java.util.Locale;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class AppB {

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
            
            Product CD = new CD("Belive Album", "Combining the best of Music", "One Republic");
            
            DVD DVD = new DVD();
            DVD.setName("The Irsih Man (2019)");
            DVD.setDescription("A Remake o fht greatest movie by Robert deniro and alpachino");
            DVD.setGenere("Action");
            
            Book Book = new Book();
            Book.setName("Malcom Gladwel");
            Book.setDescription("This is a  simple description");
            Book.setTitle("The Outliers");
            
            OrderLine ol1 = new OrderLine(5, Book);
            OrderLine ol2 = new OrderLine(1, CD);
            OrderLine ol3 = new OrderLine(2, DVD);
            
            DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT, Locale.US);
            
            OrderB o1 = new OrderB(4587, df.parse("01/20/2020"));
            o1.addOrderLine(ol1);
            o1.addOrderLine(ol2);
            o1.addOrderLine(ol3);
            
            Customer c1 = new Customer("Will", "Smith");
            c1.addOrder(o1);
            
            session.persist(c1);
            

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

            // retieve all cars
            @SuppressWarnings("unchecked")
            List<OrderB> orderList = session.createQuery("from OrderB").list();
            for (OrderB o : orderList) {
                System.out.println("Order Id= " + o.getOrderid() + ", Order Date = "
                        + o.getDate() + " Customer :  " + o.getCustomer().getFirstname() + " " + o.getCustomer().getLastname());
                for(OrderLine ol : o.getOrderlines()) {
                	System.out.println("Product Type: " + ol.getProduct().getClass().getName() + "Product: " + ol.getProduct().getName() + "Product Description: " + ol.getProduct().getDescription() + "Quantity: " + ol.getQuantity()); 
                }
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
