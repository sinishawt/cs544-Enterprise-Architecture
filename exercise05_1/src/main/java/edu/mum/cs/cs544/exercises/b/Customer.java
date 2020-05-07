package edu.mum.cs.cs544.exercises.b;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name = "BCustomer")
public class Customer {
	
	@Id
	@GeneratedValue
	private int id;
	private String firstname;
	private String lastname;
	@OneToMany(mappedBy = "customer", cascade = CascadeType.PERSIST)
	private List<OrderB> orders = new ArrayList<OrderB>();
	
	public Customer() {
	}

	public Customer(String firstname, String lastname) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
	}
	
	public void addOrder(OrderB o) {
		this.orders.add(o);
		o.setCustomer(this);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public List<OrderB> getOrders() {
		return orders;
	}

	public void setOrders(List<OrderB> orders) {
		this.orders = orders;
	}
	
	

}
