package edu.mum.cs.cs544.exercises.a;

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
            
            Product car = new Product("BMW X6", "Amazing new BMW Car 2020 model Convirtible");
            Product laptop = new Product("Acer Gaming laptop", "High End Gaming laptop x series");
            Product tv = new Product("SAMSUNG Curved", "Samsung is better TV than LG");
            
            OrderLine ol1 = new OrderLine(5, tv);
            OrderLine ol2 = new OrderLine(1, car);
            OrderLine ol3 = new OrderLine(2, laptop);
            
            DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT, Locale.US);
            
            Order o1 = new Order(4587, df.parse("01/20/2020"));
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
            List<Order> orderList = session.createQuery("from Order").list();
            for (Order o : orderList) {
                System.out.println("Order Id= " + o.getOrderid() + ", Order Date = "
                        + o.getDate() + " Customer :  " + o.getCustomer().getFirstname() + " " + o.getCustomer().getLastname());
                for(OrderLine ol : o.getOrderlines()) {
                	System.out.println("Product: " + ol.getProduct().getName() + "Product Description: " + ol.getProduct().getDescription() + "Quantity: " + ol.getQuantity()); 
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
