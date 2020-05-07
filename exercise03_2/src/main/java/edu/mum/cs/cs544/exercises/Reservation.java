package edu.mum.cs.cs544.exercises;


import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Reservation {
	@Id
	@GeneratedValue
	private int id;
	@Temporal(TemporalType.DATE)
	private Date date;
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "Customer_Id")
	private Customer customer;
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "Book_isbn")
	private Book book;
	
	public Reservation() {
		
	}

	public Reservation(Date date, Customer customer, Book book) {
		super();
		this.date = date;
		this.customer = customer;
		this.book = book;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
	
	
	
}
