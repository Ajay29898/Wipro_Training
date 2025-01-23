import java.util.ArrayList;
import java.util.Scanner;

class Employee 
{
    String empId;
    String name;
    String department;
    double basicSalary;

    public Employee(String empId, String name, String department, double basicSalary) 
    {
        this.empId = empId;
        this.name = name;
        this.department = department;
        this.basicSalary = basicSalary;
    }

    public double calculateSalary() 
    {
        return basicSalary;
    }

    @Override
    public String toString() 
    {
        return "ID: " + empId + ", Name: " + name + ", Department: " + department + ", Salary: " + calculateSalary();
    }
}

class PermanentEmployee extends Employee 
{
    double bonus;

    public PermanentEmployee(String empId, String name, String department, double basicSalary, double bonus) 
    {
        super(empId, name, department, basicSalary);
        this.bonus = bonus;
    }

    @Override
    public double calculateSalary() 
    {
        return basicSalary + bonus;
    }
}

class ContractualEmployee extends Employee 
{
    int hoursWorked;
    double hourlyRate;

    public ContractualEmployee(String empId, String name, String department, double hourlyRate, int hoursWorked) 
    {
        super(empId, name, department, 0);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double calculateSalary() 
    {
        return hourlyRate * hoursWorked;
    }
}

class PayrollSystem 
{
    ArrayList<Employee> employees = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public void addPermanentEmployee() 
    {
        System.out.print("Enter Employee ID: ");
        String empId = scanner.nextLine();
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Department: ");
        String department = scanner.nextLine();
        System.out.print("Enter Basic Salary: ");
        double basicSalary = scanner.nextDouble();
        System.out.print("Enter Bonus: ");
        double bonus = scanner.nextDouble();
        scanner.nextLine(); 

        employees.add(new PermanentEmployee(empId, name, department, basicSalary, bonus));
        System.out.println("Permanent employee added successfully!");
    }

    public void addContractualEmployee() 
    {
        System.out.print("Enter Employee ID: ");
        String empId = scanner.nextLine();
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Department: ");
        String department = scanner.nextLine();
        System.out.print("Enter Hourly Rate: ");
        double hourlyRate = scanner.nextDouble();
        System.out.print("Enter Hours Worked: ");
        int hoursWorked = scanner.nextInt();
        scanner.nextLine();

        employees.add(new ContractualEmployee(empId, name, department, hourlyRate, hoursWorked));
        System.out.println("Contractual employee added successfully!");
    }

    public void viewEmployees() 
    {
        if (employees.isEmpty()) 
        {
            System.out.println("No employees to display.");
        } 
        else 
        {
            System.out.println("\nEmployee Details:");
            for (Employee employee : employees) 
            {
                System.out.println(employee);
            }
        }
    }

    public void generatePayrollReport() 
    {
        if (employees.isEmpty()) 
        {
            System.out.println("No employees to generate payroll report.");
        } 
        else 
        {
            System.out.println("\nPayroll Report:");
            double totalSalary = 0;
            for (Employee employee : employees) 
            {
                totalSalary += employee.calculateSalary();
                System.out.println(employee);
            }
            System.out.println("Total Payroll Cost: " + totalSalary);
        }
    }

    public void menu() 
    {
        int choice;
        do 
        {
            System.out.println("\nPayroll Management System");
            System.out.println("1. Add Permanent Employee");
            System.out.println("2. Add Contractual Employee");
            System.out.println("3. View All Employees");
            System.out.println("4. Generate Payroll Report");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) 
            {
                case 1 -> addPermanentEmployee();
                case 2 -> addContractualEmployee();
                case 3 -> viewEmployees();
                case 4 -> generatePayrollReport();
                case 5 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice. Try again.");
            }
        } 
        while (choice != 5);
    }
}

public class EmployeePayrollSystem 
{
    public static void main(String[] args) 
    {
        PayrollSystem payrollSystem = new PayrollSystem();
        payrollSystem.menu();
    }
}

