package cs544.exercise16_1.bank.jms;


import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;

public class JMSSender implements IJMSSender{

	SessionFactory sf;

	public void sendJMSMessage (String text){
		System.out.println("JMSSender: sending JMS message ="+text);
	}

    public void setSessionFactory(SessionFactory sessionFactory) {
		this.sf=sessionFactory;
    }
}
