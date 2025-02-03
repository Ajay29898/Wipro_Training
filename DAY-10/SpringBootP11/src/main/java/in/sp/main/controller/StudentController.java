package in.sp.main.controller;

import in.sp.main.entities.Student;
import in.sp.main.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")  // Base URL for endpoints
public class StudentController 
{
    @Autowired
    private StudentService studentService;

    @GetMapping
    public List<Student> getAllStudents() 
    {
        return studentService.getAllStdDetails();
    }

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable long id) 
    {
        return studentService.getStdDetails(id);
    }

    @PostMapping
    public boolean addStudent(@RequestBody Student student) 
    {
        return studentService.addStudentDetails(student);
    }

    @PutMapping("/{id}")
    public boolean updateStudent(@PathVariable long id,@RequestBody Student student) 
    {
        return studentService.updateStdDetails(id, student.getMarks());
    }

    @DeleteMapping("/{id}")
    public boolean deleteStudent(@PathVariable long id) 
    {
        return studentService.deleteStdDetails(id);
    }
}

