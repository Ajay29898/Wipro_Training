package in.sp.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import in.sp.main.entity.EmployeeEntity;
import java.util.List;

public interface Repository extends JpaRepository<EmployeeEntity, Long> {

    // JPQL query to find employee by email
    @Query("SELECT e FROM EmployeeEntity e WHERE e.email = :email")
    EmployeeEntity findByEmail(@Param("email") String email);

    // JPQL query to find employees by department
    @Query("SELECT e FROM EmployeeEntity e WHERE e.department = :dept")
    List<EmployeeEntity> findByDepartment(@Param("dept") String dept);
}
