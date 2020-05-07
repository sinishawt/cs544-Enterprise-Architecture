package cs544.exercise16_1.bank.logging;

import org.hibernate.SessionFactory;

public class Logger implements ILogger{

	SessionFactory sf;

	public void log(String logstring) {
		java.util.logging.Logger.getLogger("BankLogger").info(logstring);		
	}

    public void setSessionFactory(SessionFactory sessionFactory) {
		this.sf=sessionFactory;
    }
	

}
