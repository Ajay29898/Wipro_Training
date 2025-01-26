// This program implements a Student Grade Management System allowing the management of students, courses, and grades. 
// It supports operations like adding students and courses, assigning grades, viewing student details with GPAs, and listing available courses

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

// Represents a student and manages their grades for courses.Stores and processes information about individual students.
// purpose of the class is to tracks courses and grades for each student.

class Student         
{
    String studentId;
    String name;

//  A HashMap that stores grades for each course.Each Student object has a separate courseGrades object which stores grades for each courses.

    HashMap<Course, Grade> courseGrades = new HashMap<>();    
                                                              
    public Student(String studentId, String name)             
    {
        this.studentId = studentId;
        this.name = name;
    }

    public void assignGrade(Course course, Grade grade)    // Adds a grade for a specific course in the courseGrades map
    {
        courseGrades.put(course, grade);
        System.out.println("Grade assigned: " + grade.letterGrade + " for course: " + course.courseName);
    }

    public double calculateGPA()        // Calculates the student's Grade Point Average (GPA) as the average of all grade points in courseGrades
    {
        if (courseGrades.isEmpty())    
        {                               
            return 0.0;                 // Returns 0.0 if the student has no grades.
        }
        double totalGradePoints = 0.0;
        int totalCourses = courseGrades.size();

        for (Grade grade : courseGrades.values()) 
        {
            totalGradePoints += grade.gradePoint;
        }
        return totalGradePoints / totalCourses;
    }

    @Override
    public String toString() 
    {
        return "Student ID: " + studentId + ", Name: " + name + ", GPA: " + calculateGPA();
    }
}

class Course                  // Represents a course that students can take.Purpose of a class is to Encapsulate the information about a course.
{
    String courseId;
    String courseName;

    public Course(String courseId, String courseName) 
    {
        this.courseId = courseId;
        this.courseName = courseName;
    }

    @Override
    public String toString() 
    {
        return "Course ID: " + courseId + ", Course Name: " + courseName;
    }
}

class Grade                       // Represents the grade for a student in a course.Links a course and student to the grade they achieved
{
    String letterGrade;
    double gradePoint;

    public Grade(String letterGrade, double gradePoint) 
    {
        this.letterGrade = letterGrade;         // The letter representation of the grade (e.g., A, B, C).
        this.gradePoint = gradePoint;           //  The numeric representation of the grade (e.g., A = 4.0, B = 3.0).
    }
}

public class GradeManagementSystem              // Provides the user interface and core functionality for managing the overall system
{
    ArrayList<Student> students = new ArrayList<>();
    ArrayList<Course> courses = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public void addStudent()                   // Stores all student records.
    {
        System.out.print("Enter Student ID: ");
        String studentId = scanner.nextLine();
        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();
        students.add(new Student(studentId, name));
        System.out.println("Student added successfully.");
    }

    public void addCourse()                 // Stores all course records
    {
        System.out.print("Enter Course ID: ");
        String courseId = scanner.nextLine();
        System.out.print("Enter Course Name: ");
        String courseName = scanner.nextLine();
        courses.add(new Course(courseId, courseName));
        System.out.println("Course added successfully.");
    }

    public Student findStudent(String studentId)        // Prompts the user for student details and adds a new Student object to the students list.
    {
        for (Student student : students) 
        {
            if (student.studentId.equals(studentId)) 
            {
                return student;
            }
        } 
        System.out.println("Student not found.");
        return null;
    }

    public Course findCourse(String courseId)           // Prompts the user for course details and adds a new Course object to the courses list.
    {
        for (Course course : courses) 
        {
            if (course.courseId.equals(courseId)) 
            {
                return course;
            }
        }
        System.out.println("Course not found.");
        return null;
    }

    // Prompts(Ask to enter) the user for the student ID and course ID, then finds the respective Student and Course objects.
    // Asks for a letter grade, converts it to a grade point using convertGradeToPoint(), and assigns the grade to the student.

    public void assignGrade()          
    {
        System.out.print("Enter Student ID: ");
        String studentId = scanner.nextLine();
        Student student = findStudent(studentId);

        if (student != null) 
        {
            System.out.print("Enter Course ID: ");
            String courseId = scanner.nextLine();
            Course course = findCourse(courseId);

            if (course != null) 
            {
                System.out.print("Enter Grade (e.g., A, B, C): ");
                String letterGrade = scanner.nextLine();
                double gradePoint = convertGradeToPoint(letterGrade);

                if (gradePoint >= 0)
                {
                    Grade grade = new Grade(letterGrade, gradePoint);
                    student.assignGrade(course, grade);
                } 
                else 
                {
                    System.out.println("Invalid grade.");
                }
            }
        }
    }

    public double convertGradeToPoint(String letterGrade) 
    {
        return switch (letterGrade.toUpperCase()) {
            case "A" -> 4.0;
            case "B" -> 3.0;
            case "C" -> 2.0;
            case "D" -> 1.0;
            case "F" -> 0.0;
            default -> -1.0;
        };
    }

    public void viewStudents() 
    {
        if (students.isEmpty()) 
        {
            System.out.println("No students available.");
        } 
        else 
        {
            for (Student student : students) 
            {
                System.out.println(student);
            }
        }
    }

    public void viewCourses() 
    {
        if (courses.isEmpty()) 
        {
            System.out.println("No courses available.");
        } 
        else 
        {
            for (Course course : courses) 
            {
                System.out.println(course);
            }
        }
    }

    public void menu() 
    {
        int choice;
        do 
        {
            System.out.println("\nStudent Grade Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Add Course");
            System.out.println("3. Assign Grade");
            System.out.println("4. View Students");
            System.out.println("5. View Courses");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) 
            {
                case 1 -> addStudent();
                case 2 -> addCourse();
                case 3 -> assignGrade();
                case 4 -> viewStudents();
                case 5 -> viewCourses();
                case 6 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 6);
    }

    public static void main(String[] args) 
    {
        GradeManagementSystem gms = new GradeManagementSystem();
        gms.menu();
    }
}
