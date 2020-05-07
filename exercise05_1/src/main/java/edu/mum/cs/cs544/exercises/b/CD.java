package edu.mum.cs.cs544.exercises.b;

import javax.persistence.Entity;

@Entity(name = "BCD")
public class CD extends Product {
	
	private String artist;
	
	public CD() {
		// TODO Auto-generated constructor stub
	}
	
	

	public CD(String prod, String description, String artist) {
		super(prod, description);
		this.artist = artist;
	}



	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}
	
	

}
