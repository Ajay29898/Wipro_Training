package in.sp.main.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.sp.main.entities.Student;
import in.sp.main.repository.StudentRepository;

@Service  
public class StudentServiceImpl implements StudentService
{
	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public boolean addStudentDetails(Student std) 
	{
		boolean status = false;
		
		try
		{
			studentRepository.save(std);          // Saving student to the database
			status = true;                        // If save is successful, return true
		}
		catch(Exception e)
		{
			e.printStackTrace();                  // If an error occurs, print the stack trace
			status = false;                       // If there's an error, return false
		}
		return status;
	}
	
	@Override
	public List<Student> getAllStdDetails()      // It return List of Student Object
	{
		return studentRepository.findAll();     // Fetches all students from the database
	}
	
	@Override
	public Student getStdDetails(long id) 
	{
		// Optional<Student> is a container object that may or may not contain a Student object. Optional<T> is a class introduced in Java 8.optional is an instance of the Optional class,  
		// which contains a Student object. It Avoids NullPointerException – Instead of returning null when a student is not found, findById(id) returns an Optional<Student>, allowing safe handling.
		
		Optional<Student> optional = studentRepository.findById(id);    // The findById(id) method of StudentRepository is used to find the student by ID.
		if(optional.isPresent())
		{
			return optional.get();             // Return student if present

		}
		else
		{
			return null;                      // Return null if student is not found
		}
	}
	
	@Override
	public boolean updateStdDetails(long id, float marks) 
	{
		Student std = getStdDetails(id);           // Fetch student by ID.
		
		if(std!=null)
		{
			std.setMarks(marks);                   // Update the marks
			studentRepository.save(std);           // Save the updated student to the database
			return true;
		}
		return false;
	}
	
	@Override
	public boolean deleteStdDetails(long id) 
	{
		boolean status = false;
		
		try
		{
			studentRepository.deleteById(id);
			status = true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			status = false;
		}
		return status;
	}
}



// In a regular Java application, you need to create the object manually before passing it to the method.
// But in Spring  we can pass using @RequestBody as Spring creates the object automatically when it receives a request with the appropriate data (e.g., a JSON object in the request body).

// This class, StudentServiceImpl, is the implementation of the StudentService interface. It is marked with the @Service annotation to 
// indicate that it contains business logic for handling student-related operations.In Spring, service classes are typically used to 
// encapsulate the business logic of an application, and they are automatically managed by the Spring container.





//
// Purpose of Service Classes (@Service)
// Service classes, on the other hand, are responsible for business logic and often interact with repositories to perform database  
// operations in a more structured and abstracted way.The @Service annotation is used in service classes to tell Spring to manage the
// class as a Spring bean. These classes can be injected into other components like controllers or other services using dependency injection.
// why @Service is used only in Service Class and in Entity Class ?
// @Entity is used for classes that represent database tables in JPA. These classes don’t require Spring to manage them as beans 
// since they are purely data holders.
// @Service is used for service layer classes that contain business logic and require Spring's dependency injection to be managed as beans.








