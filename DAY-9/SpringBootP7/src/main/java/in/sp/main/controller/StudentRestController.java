package in.sp.main.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.sp.main.Student.Student;

@RestController
@RequestMapping("/mystudent")
public class StudentRestController {

    @PostMapping("/student")
    public String saveStudent(@RequestBody Student s) {
        System.out.println(s);
        return "Student is saved";
    }

    @GetMapping("/student/{sid}")
    public Student getStudent(@PathVariable Integer sid) {
        Student s = new Student(100, "Alice", "Computer Science", 20);
        return s;
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        Student s1 = new Student(100, "Alice", "Computer Science", 20);
        Student s2 = new Student(101, "Bob", "Mathematics", 22);
        return Arrays.asList(s1, s2);
    }
}

