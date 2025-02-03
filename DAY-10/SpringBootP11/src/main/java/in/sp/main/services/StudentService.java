package in.sp.main.services;

import java.util.List;

import in.sp.main.entities.Student;

public interface StudentService 
{
	public boolean addStudentDetails(Student std);

	public List<Student> getAllStdDetails();
	
	public Student getStdDetails(long id);
	
	public boolean updateStdDetails(long id, float marks);
	
	public boolean deleteStdDetails(long id);	
}


// This code defines an interface named StudentService, which serves as a contract for the business logic layer of the application. 
// It outlines the operations that can be performed on the Student entity. In Spring-based applications, it is common to define service 
// interfaces and implement them in service classes, which are later injected into controllers or other components.
