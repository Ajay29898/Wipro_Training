package in.sp.main.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="employee_table")
public class EmployeeEntity 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private long id;   
	@Column
	private String name;
	@Column
	private String email; 
	@Column
	private double salary;
	
	@Column
	private String department;
	@Column
	private LocalDate joiningDate;
	@Column
    private LocalDate resignationDate;
	
	public EmployeeEntity() 
	{
		
	}
	
	public EmployeeEntity(long id, String name, String email, double salary, String department, LocalDate joiningDate,
			LocalDate resignationDate) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.salary = salary;
		this.department = department;
		this.joiningDate = joiningDate;
		this.resignationDate = resignationDate;
	}

	@Override
	public String toString() {
		return "EmployeeEntity [id=" + id + ", name=" + name + ", email=" + email + ", salary=" + salary
				+ ", department=" + department + ", joiningDate=" + joiningDate + ", resignationDate=" + resignationDate
				+ "]";
	}
}
