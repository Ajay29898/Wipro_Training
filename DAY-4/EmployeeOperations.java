import java.util.*;
import java.util.stream.Collectors;

class Employee 
{
    String name;
    double salary;
    String department;

    public Employee(String name, double salary, String department) 
    {
        this.name = name;
        this.salary = salary;
        this.department = department;
    }

    public String getName() 
    {
        return name;
    }

    public double getSalary() 
    {
        return salary;
    }

    public String getDepartment() 
    {
        return department;
    }

    @Override
    public String toString() 
    {
        return "Employee{name='" + name + "', salary=" + salary + ", department='" + department + "'}";
    }
}

public class EmployeeOperations 
{
    public static void main(String[] args) 
    {
        List<Employee> employees = Arrays.asList(
            new Employee("Alice", 7000, "HR"),
            new Employee("Bob", 4000, "Engineering"),
            new Employee("Charlie", 5500, "Engineering"),
            new Employee("David", 8000, "Marketing"),
            new Employee("Eva", 5000, "HR"),
            new Employee("Frank", 4500, "Engineering")
        );

        // 1. Find Employee with Highest Salary

        Employee highestSalaryEmployee = employees.stream()
                .max(Comparator.comparingDouble(Employee::getSalary))
                .orElse(null);
        System.out.println("Highest Salary Employee: " + highestSalaryEmployee);
        System.out.println();
        System.out.println();

        // 2. Filter Employees with Salary Greater Than 5000

        List<Employee> highSalaryEmployees = employees.stream()
                .filter(e -> e.getSalary() > 5000)
                .collect(Collectors.toList());
        System.out.println("Employees with Salary > 5000: " + highSalaryEmployees);
        System.out.println();
        System.out.println();

        // 3. Get Employee Names and Salaries

        List<String> employeeNamesAndSalaries = employees.stream()
                .map(e -> e.getName() + " - " + e.getSalary())
                .collect(Collectors.toList());
        System.out.println("Employee Names and Salaries: " + employeeNamesAndSalaries);
        System.out.println();
        System.out.println();

        // 4. Count Employees

        long employeeCount = employees.size();
        System.out.println("Total Number of Employees: " + employeeCount);
        System.out.println();
        System.out.println();

        // 5. Group Employees by Department

        Map<String, List<Employee>> employeesByDepartment = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
        System.out.println("Employees Grouped by Department: " + employeesByDepartment);
        System.out.println();
        System.out.println();

        // 6. Calculate Average Salary

        double averageSalary = employees.stream()
                .mapToDouble(Employee::getSalary)
                .average()
                .orElse(0.0);
        System.out.println("Average Salary: " + averageSalary);
        System.out.println();
        System.out.println();

        // 7. Sort Employees by Salary

        List<Employee> sortedBySalary = employees.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary))
                .collect(Collectors.toList());
        System.out.println("Employees Sorted by Salary: " + sortedBySalary);
        System.out.println();
        System.out.println();

        // 8. Find Employee with Second Highest Salary

        Employee secondHighestSalaryEmployee = employees.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .skip(1)
                .findFirst()
                .orElse(null);
        System.out.println("Second Highest Salary Employee: " + secondHighestSalaryEmployee);
        System.out.println();
        System.out.println();

        // 9. Partition Employees by Salary Threshold (e.g., 5000)

        Map<Boolean, List<Employee>> partitionedBySalary = employees.stream()
                .collect(Collectors.partitioningBy(e -> e.getSalary() > 5000));
        System.out.println("Employees Partitioned by Salary > 5000: " + partitionedBySalary);
        System.out.println();
        System.out.println();

        // 10. Find Employee with Longest Name

        Employee longestNameEmployee = employees.stream()
                .max(Comparator.comparingInt(e -> e.getName().length()))
                .orElse(null);
        System.out.println("Employee with Longest Name: " + longestNameEmployee);
        System.out.println();
        System.out.println();
    }
}

