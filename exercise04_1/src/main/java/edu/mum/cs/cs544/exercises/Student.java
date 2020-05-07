package edu.mum.cs.cs544.exercises;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MapKey;

@Entity
public class Student {

	@Id
	@MapKey
	private String studentid;
	
	private String firstname;
	private String lastname;
	
	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(String studentid, String firstname, String lastname) {
		super();
		this.studentid = studentid;
		this.firstname = firstname;
		this.lastname = lastname;
	}

	public String getStudentid() {
		return studentid;
	}

	public void setStudentid(String studentid) {
		this.studentid = studentid;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	@Override
	public boolean equals(Object obj) {
		if(this == obj)
			return true;
		if((obj == null) || obj.getClass() != this.getClass())
			return false;
		Student s = (Student) obj;
		if(studentid == s.studentid || (studentid != null && studentid.equals(s.studentid))) {
			return true;
		}else {
			return false;
		}
			
	}

	@Override
	public int hashCode() {
		return Objects.hash(getStudentid());
	}
	
	
	
	
}
