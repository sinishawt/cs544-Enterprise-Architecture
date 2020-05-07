package edu.mum.cs.cs544.exercises;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Student {

	@Id
	@GeneratedValue
	private int studentid;
	private String firstname;
	private String lastname;
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "Students_Courses", 
		joinColumns = {@JoinColumn(name = "student_id")}, 
		inverseJoinColumns = {@JoinColumn(name = "course_id")}
			)
	private List<Course> courses = new ArrayList<Course>();
	
	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(String firstname, String lastname, List<Course> courses) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.courses = courses;
	}

	public int getStudentid() {
		return studentid;
	}

	public void setStudentid(int studentid) {
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

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	
	
	
}
