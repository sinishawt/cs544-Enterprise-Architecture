package edu.mum.cs.cs544.exercises.b;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Lob;


@Entity(name = "BProduct")
@Inheritance(strategy = InheritanceType.JOINED)
public class Product {
	
	@Id
	@GeneratedValue
	private int id;
	private String name;
	@Lob
	private String description;
	
	
	public Product() {
	}

	public Product(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
		
	

}
