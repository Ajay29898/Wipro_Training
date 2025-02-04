package in.sp.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import in.sp.main.entity.EmployeeEntity;
import in.sp.main.repository.Repository;
import jakarta.transaction.Transactional;

import java.util.List;

@Service
public class Imp_EmployeeService implements EmployeeService {

    @Autowired
    private Repository repository;

    @Override
    public double calculateBonus(long employeeId) {
        return 5000;
    }

    @Override
    @Transactional
    public EmployeeEntity addEmployee(EmployeeEntity employee) 
    {
    	 System.out.println("Adding employee: " + employee.toString()); 
        return repository.save(employee);
    }

    @Override
    public EmployeeEntity findByEmail(String email) {
        return repository.findByEmail(email);
    }

    @Override
    public List<EmployeeEntity> findByDepartment(String department) {
        return repository.findByDepartment(department);
    }
}
