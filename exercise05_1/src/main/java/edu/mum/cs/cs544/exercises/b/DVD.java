package edu.mum.cs.cs544.exercises.b;

import javax.persistence.Entity;

@Entity(name = "BDVD")
public class DVD extends Product{

	private String genere;
	
	public DVD() {
		// TODO Auto-generated constructor stub
	}

	public DVD(String genere) {
		super();
		this.genere = genere;
	}

	public String getGenere() {
		return genere;
	}

	public void setGenere(String genere) {
		this.genere = genere;
	}
	
	
}
