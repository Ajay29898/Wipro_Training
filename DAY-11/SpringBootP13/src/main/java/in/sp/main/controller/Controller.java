package in.sp.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.sp.main.entity.EmployeeEntity;
import in.sp.main.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class Controller 
{

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/{id}/bonus")
    public double getBonus(@PathVariable long id) {
        return employeeService.calculateBonus(id);
    }

    @PostMapping("/emp")
    public ResponseEntity<EmployeeEntity> createEmployee(@RequestBody EmployeeEntity employee) 
    {
        EmployeeEntity savedEmployee = employeeService.addEmployee(employee);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    // Fetch employee by email using JPQL
    @GetMapping("/email/{email}")
    public ResponseEntity<EmployeeEntity> getEmployeeByEmail(@PathVariable String email) 
    {
        EmployeeEntity employee = employeeService.findByEmail(email);
        return ResponseEntity.ok(employee);
    }
}
