package in.sp.main;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import in.sp.main.entities.Student;
import in.sp.main.services.StudentService;
import in.sp.main.services.StudentServiceImpl;


@SpringBootApplication
public class SpringBootP11Application 
{
	public static void main(String[] args) 
	{
		// ApplicationContext ---> Spring Container(Stores and provides objects of your classes.)
		ApplicationContext context = SpringApplication.run(SpringBootP11Application.class, args);
		
		StudentService stdService = context.getBean(StudentServiceImpl.class);
		
		//------------------------> Delete Operation<--------------------------//	
		
//		boolean status = stdService.deleteStdDetails(2L);
//		if(status)
//		{
//			System.out.println("Student details delete sucessfully");
//		}
//		else
//		{
//			System.out.println("Student details not delete due to some error");
//		}
	}

}

	
//------------------------> Insert Operation<--------------------------//

//	Student std = new Student();
//	std.setName("Vishal");
//	std.setRollno("102");
//	std.setMarks(94.0f);
//	
//	boolean status = stdService.addStudentDetails(std);
//	if(status)
//	{
//		System.out.println("Student inserted sucessfully");
//	}
//	else
//	{
//		System.out.println("Student not inserted due to some error");
//	}
	
	
//------------------------> Select Operation-1<--------------------------//
	
//	List<Student> stdList = stdService.getAllStdDetails();
//	
//	for(Student std : stdList)
//	{
//		System.out.println("Id : "+std.getId());
//		System.out.println("name : "+std.getName());
//		System.out.println("rollno : "+std.getRollno());
//		System.out.println("name : "+std.getMarks());
//		
//		System.out.println();
//	}


//------------------------> Select Operation-2<--------------------------//

//Student std = stdService.getStdDetails(3L);
//
//if(std != null)
//{
//	System.out.println("Id : "+std.getId());
//	System.out.println("name : "+std.getName()); 
//	System.out.println("rollno : "+std.getRollno());
//    System.out.println("name : "+std.getMarks());
//}
//else
//{
//	System.out.println("Student not found");
//}



//------------------------> Update Operation<--------------------------//

//		boolean status = stdService.updateStdDetails(1L, 91.7f);
//		if(status)
//		{
//			System.out.println("Student details updated sucessfully");
//		}
//		else
//		{
//			System.out.println("Student details not updated due to some error");
//		}
// ---------------------------------Conclusion of Code------------------------------------------

// ApplicationContext context = SpringApplication.run(SpringBootP11Application.class, args);
// ---> Performs 3 main tasks:
//1️ Runs the application (starts the Spring Boot app).
//2️ Scans all packages and sub-packages (looks for @Component, @Service, @Repository, @Controller).
//3️ Stores all found beans in ApplicationContext, which acts like a container for objects.
//So, whenever you need a bean (object) like StudentServiceImpl, you don’t need to create it manually.
//Instead, you retrieve it from the ApplicationContext like this:
// StudentService stdService = context.getBean(StudentServiceImpl.class);
//----> his line retrieves a bean of StudentServiceImpl.class class from ApplicationContext  and store it to stdservice.




