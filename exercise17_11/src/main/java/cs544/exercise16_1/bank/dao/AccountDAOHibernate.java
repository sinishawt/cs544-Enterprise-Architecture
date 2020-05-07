package cs544.exercise16_1.bank.dao;

import java.util.*;

import cs544.exercise16_1.bank.domain.Account;
import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


public class AccountDAOHibernate implements IAccountDAO {
	private SessionFactory sf;
	Collection<Account> accountlist = new ArrayList<Account>();



	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sf=sessionFactory;

	}

	public void saveAccount(Account account) {
		sf.getCurrentSession().persist(account);
	}

	public void updateAccount(Account account) {
		sf.getCurrentSession().persist(account);
	}


	public Account loadAccount(long accountnumber) {
//		return (Account) sf.getCurrentSession().createQuery("Select distinct a From Account a where a.accountnumber = :accountnumber").
//				setParameter("accountnumber", accountnumber).setMaxResults(1).uniqueResult();

		Account account = (Account) sf.getCurrentSession().get(Account.class, accountnumber);
		//Hibernate.initialize(acct.getEntryList());
		return account;
	}

	public Collection<Account> getAccounts() {

		return accountlist =sf.getCurrentSession().createQuery("from Account").list();
	}


}
