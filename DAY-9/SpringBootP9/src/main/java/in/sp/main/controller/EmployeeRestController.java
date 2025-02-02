package in.sp.main.controller;


import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.sp.main.employee.Employee;

@RestController
@RequestMapping("/myemployee")
public class EmployeeRestController {

    @PostMapping("/employee")
    public String saveEmployee(@RequestBody Employee e) {
        System.out.println(e);
        return "Employee is saved";
    }

    @GetMapping("/employee/{eid}")
    public Employee getEmployee(@PathVariable Integer eid) {
        Employee e = new Employee(1001, "John Smith", "IT", 60000.0);
        return e;
    }

    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        Employee e1 = new Employee(1001, "John Smith", "IT", 60000.0);
        Employee e2 = new Employee(1002, "Jane Doe", "HR", 50000.0);
        return Arrays.asList(e1, e2);
    }
}
