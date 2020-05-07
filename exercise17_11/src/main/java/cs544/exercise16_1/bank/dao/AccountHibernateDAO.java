package cs544.exercise16_1.bank.dao;

import cs544.exercise16_1.bank.domain.Account;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;

@Transactional(propagation = Propagation.MANDATORY)
public class AccountHibernateDAO implements IAccountDAO{
	Collection<Account> accountlist = new ArrayList<Account>();
    private SessionFactory sf;
    
    @Transactional(propagation = Propagation.SUPPORTS)
    public void setSessionFactory(SessionFactory sessionFactory) {
    	this.sf = sessionFactory;
    }

    public void saveAccount(Account account) {
        sf.getCurrentSession().persist(account);
    }

    public void updateAccount(Account account) {
        sf.getCurrentSession().persist(account);
    }

    public Account loadAccount(long accountnumber) {
    	Account account = (Account) sf.getCurrentSession().get(Account.class, accountnumber);
    	return account;
    }

    public Collection<Account> getAccounts() {
    	return accountlist =sf.getCurrentSession().createQuery("from Account").list();
    }

}


