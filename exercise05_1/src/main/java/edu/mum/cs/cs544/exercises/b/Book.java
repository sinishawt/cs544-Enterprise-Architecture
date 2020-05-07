package edu.mum.cs.cs544.exercises.b;

import javax.persistence.Entity;

@Entity(name = "BBook")
public class Book extends Product{
	
	private String title;

	public Book() {
		// TODO Auto-generated constructor stub
	}
	
	public Book(String title) {
		super();
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	
	

}
