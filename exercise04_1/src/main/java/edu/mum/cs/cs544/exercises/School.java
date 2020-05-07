package edu.mum.cs.cs544.exercises;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKey;
import javax.persistence.MapKeyColumn;
import javax.persistence.OneToMany;

@Entity
public class School {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	@OneToMany(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "student_id")
	@MapKeyColumn(name = "studentid", nullable = true)
	private Map<String, Student> students = new HashMap<String, Student>();
	
	public School() {
		// TODO Auto-generated constructor stub
	}

	public School(String name, Map<String, Student> s) {
		super();
		this.name = name;
		this.students = s;
	}
	
	public void addstudent(Student stud) {
		students.put(stud.getStudentid(), stud);
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

	public Map<String, Student> getStudents() {
		return students;
	}

	public void setStudents(Map<String, Student> students) {
		this.students = students;
	}
	
	 @Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (!(o instanceof School)) return false;
	        School school = (School) o;
	        return Objects.equals(getName(), school.getName()) &&
	                Objects.equals(getStudents(), school.getStudents());
	    }

	    @Override
	    public int hashCode() {
	        return Objects.hash(getName(), getStudents());
	    }

	    @Override
	    public String toString() {
	        return "School{" +
	                "id=" + id +
	                ", name='" + name + '\'' +
	                ", students=" + students +
	                '}';
	    }
	
	
}
