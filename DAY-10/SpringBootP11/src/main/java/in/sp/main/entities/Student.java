package in.sp.main.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Student 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private long id;
	@Column
	private String name;
	@Column
	private String rollno;
	@Column
	private float marks;
	
	
	public Student() {}  //  JPA needed default constructor to make object so that it can store data from the data base to do operation 
	                     //  like delete,fetch,etc but in POST the object is created by Spring using @RequestBody,and JPA saves it to the database.
	
	public Student(long id, String name, String rollno, float marks) {
		super();
		this.id = id;
		this.name = name;
		this.rollno = rollno;
		this.marks = marks;
	}
	
	public long getId() {
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
	public String getRollno() {
		return rollno;
	}
	public void setRollno(String rollno) {
		this.rollno = rollno;
	}
	public float getMarks() {
		return marks;
	}
	public void setMarks(float marks) {
		this.marks = marks;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", rollno=" + rollno + ", marks=" + marks + "]";
	}
	
}


// This class is used to create a table in the database
