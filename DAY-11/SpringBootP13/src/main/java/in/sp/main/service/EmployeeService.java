package in.sp.main.service;

import in.sp.main.entity.EmployeeEntity;
import java.util.List;

public interface EmployeeService {
    double calculateBonus(long employeeId);
    EmployeeEntity addEmployee(EmployeeEntity employee);
    EmployeeEntity findByEmail(String email);  // JPQL method
    List<EmployeeEntity> findByDepartment(String department);  // JPQL method
}

