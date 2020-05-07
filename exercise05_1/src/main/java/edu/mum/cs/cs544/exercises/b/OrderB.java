package edu.mum.cs.cs544.exercises.b;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Border_table")
public class OrderB {
	
	@Id
	private int orderid;
	@Temporal(TemporalType.DATE)
	private Date date;
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;
	
	@OneToMany(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "order_id")
	private List<OrderLine> orderlines = new ArrayList<OrderLine>();
	
	public OrderB() {
		// TODO Auto-generated constructor stub
	}

	public OrderB(int orderid, Date date) {
		super();
		this.orderid = orderid;
		this.date = date;
	}
	
	public void addOrderLine(OrderLine o) {
		this.orderlines.add(o);
	}

	public int getOrderid() {
		return orderid;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<OrderLine> getOrderlines() {
		return orderlines;
	}

	public void setOrderlines(List<OrderLine> orderlines) {
		this.orderlines = orderlines;
	}
	
	

}
