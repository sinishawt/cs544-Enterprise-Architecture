package cs544.exercise16_1.bank.service;

import org.hibernate.SessionFactory;

public class CurrencyConverter implements ICurrencyConverter{
	SessionFactory sf;
	
    public double euroToDollars (double amount){
		System.out.println("CurrencyConverter: converting "+amount+" dollars to euros");
        return 1.57 * amount;
    }
    
    public double dollarsToEuros (double amount){
        return 0.637 * amount;
    }
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sf=sessionFactory;
    }
}
