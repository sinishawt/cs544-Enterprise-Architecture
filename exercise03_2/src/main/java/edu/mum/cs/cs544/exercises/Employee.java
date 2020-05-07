package edu.mum.cs.cs544.exercises;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Employee {
	@Id
	@GeneratedValue
	private int Employeenumber;
	private String name;
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "department_number")
	private Department department;
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "office_room_number")
	private Office office;
	
	public Employee() {
	}
	
	public Employee(String name, Department department, Office office) {
		super();
		this.name = name;
		this.department = department;
		this.office = office;
	}

	

	public Office getOffice() {
		return office;
	}

	public void setOffice(Office office) {
		this.office = office;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public int getEmployeenumber() {
		return Employeenumber;
	}

	public void setEmployeenumber(int employeenumber) {
		Employeenumber = employeenumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
