package edu.mum.cs.cs544.exercises;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Flight {

	@Id
	@GeneratedValue
	private int id;
	private String flightnumber;
	@Column(name = "to_")
	private String to;
	@Column(name = "from_")
	private String from;
	@Temporal(TemporalType.DATE)
	private Date date;
	
	public Flight() {
		// TODO Auto-generated constructor stub
	}

	public Flight(String flightnumber, String to, String from, Date date) {
		super();
		this.flightnumber = flightnumber;
		this.to = to;
		this.from = from;
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFlightnumber() {
		return flightnumber;
	}

	public void setFlightnumber(String flightnumber) {
		this.flightnumber = flightnumber;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	
}
