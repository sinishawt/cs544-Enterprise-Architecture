package edu.mum.cs.cs544.exercises.b;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity(name = "BOrder_line")
public class OrderLine {
	
	@Id
	@GeneratedValue
	private int id;
	private int quantity;
	
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Product product;
	
	public OrderLine() {
		// TODO Auto-generated constructor stub
	}

	public OrderLine(int quantity, Product product) {
		super();
		this.quantity = quantity;
		this.product = product;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	

}
