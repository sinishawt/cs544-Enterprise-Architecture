package edu.mum.cs.cs544.exercises;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;

@Entity
public class Passenger {

	@Id
	@GeneratedValue
	private int id;
	private String name;
	
	@OneToMany(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "passanger_id")
	@OrderColumn(name = "sequence")
	private List<Flight> flights = new ArrayList<Flight>();
	
	public Passenger() {
		// TODO Auto-generated constructor stub
	}

	public Passenger(String name, List<Flight> flights) {
		super();
		this.name = name;
		this.flights = flights;
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

	public List<Flight> getFlights() {
		return flights;
	}

	public void setFlights(List<Flight> flights) {
		this.flights = flights;
	}
	
	
	
}
