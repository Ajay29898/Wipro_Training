import java.util.ArrayList;
import java.util.Scanner;

abstract class Vehicle 
{
    String vehicleId;
    String brand;
    boolean isRented;

    public Vehicle(String vehicleId, String brand) 
    {
        this.vehicleId = vehicleId;
        this.brand = brand;
        this.isRented = false;
    }

    public abstract double calculateRentalCost(int days);

    @Override
    public String toString() 
    {
        return "Vehicle ID: " + vehicleId + ", Brand: " + brand + ", Rented: " + (isRented ? "Yes" : "No");
    }
}

// Car Class
class Car extends Vehicle 
{
    double dailyRate;

    public Car(String vehicleId, String brand, double dailyRate) 
    {
        super(vehicleId, brand);
        this.dailyRate = dailyRate;
    }

    @Override
    public double calculateRentalCost(int days) 
    {
        return days * dailyRate;
    }
}

class Bike extends Vehicle 
{
    double hourlyRate;

    public Bike(String vehicleId, String brand, double hourlyRate) 
    {
        super(vehicleId, brand);
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculateRentalCost(int days) 
    {
        return days * 24 * hourlyRate; // Convert days to hours
    }
}

class Customer 
{
    String customerId;
    String name;

    public Customer(String customerId, String name) 
    {
        this.customerId = customerId;
        this.name = name;
    }

    @Override
    public String toString() 
    {
        return "Customer ID: " + customerId + ", Name: " + name;
    }
}

// Rental Management System
class RentalSystem 
{
    ArrayList<Vehicle> vehicles = new ArrayList<>();
    ArrayList<Customer> customers = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public void addVehicle() 
    {
        System.out.println("Add Vehicle:");
        System.out.print("Enter Vehicle Type (Car/Bike): ");
        String type = scanner.nextLine();
        System.out.print("Enter Vehicle ID: ");
        String vehicleId = scanner.nextLine();
        System.out.print("Enter Brand: ");
        String brand = scanner.nextLine();

        if (type.equalsIgnoreCase("Car")) 
        {
            System.out.print("Enter Daily Rate: ");
            double dailyRate = scanner.nextDouble();
            scanner.nextLine(); // Consume newline
            vehicles.add(new Car(vehicleId, brand, dailyRate));
        } 
        else if (type.equalsIgnoreCase("Bike")) 
        {
            System.out.print("Enter Hourly Rate: ");
            double hourlyRate = scanner.nextDouble();
            scanner.nextLine(); // Consume newline
            vehicles.add(new Bike(vehicleId, brand, hourlyRate));
        } 
        else 
        {
            System.out.println("Invalid vehicle type.");
        }
    }

    public void addCustomer() 
    {
        System.out.println("Add Customer:");
        System.out.print("Enter Customer ID: ");
        String customerId = scanner.nextLine();
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        customers.add(new Customer(customerId, name));
    }

    public void rentVehicle() 
    {
        System.out.print("Enter Customer ID: ");
        String customerId = scanner.nextLine();
        Customer customer = findCustomer(customerId);

        if (customer != null) 
        {
            System.out.print("Enter Vehicle ID: ");
            String vehicleId = scanner.nextLine();
            Vehicle vehicle = findVehicle(vehicleId);

            if (vehicle != null && !vehicle.isRented) 
            {
                System.out.print("Enter Number of Days to Rent: ");
                int days = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                double cost = vehicle.calculateRentalCost(days);
                vehicle.isRented = true;
                System.out.println("Vehicle rented successfully. Total Cost: $" + cost);
            } 
            else 
            {
                System.out.println("Vehicle is not available for rent.");
            }
        }
    }

    public void returnVehicle() 
    {
        System.out.print("Enter Vehicle ID: ");
        String vehicleId = scanner.nextLine();
        Vehicle vehicle = findVehicle(vehicleId);

        if (vehicle != null && vehicle.isRented) 
        {
            vehicle.isRented = false;
            System.out.println("Vehicle returned successfully.");
        } 
        else 
        {
            System.out.println("Vehicle is not currently rented.");
        }
    }

    public void viewVehicles() 
    {
        System.out.println("Available Vehicles:");
        for (Vehicle vehicle : vehicles) 
        {
            System.out.println(vehicle);
        }
    }

    public void viewCustomers() 
    {
        System.out.println("Registered Customers:");
        for (Customer customer : customers) 
        {
            System.out.println(customer);
        }
    }

    private Vehicle findVehicle(String vehicleId) 
    {
        for (Vehicle vehicle : vehicles) 
        {
            if (vehicle.vehicleId.equals(vehicleId)) 
            {
                return vehicle;
            }
        }
        System.out.println("Vehicle not found.");
        return null;
    }

    private Customer findCustomer(String customerId) 
    {
        for (Customer customer : customers) 
        {
            if (customer.customerId.equals(customerId)) 
            {
                return customer;
            }
        }
        System.out.println("Customer not found.");
        return null;
    }

    public void menu() 
    {
        int choice;
        do 
        {
            System.out.println("\nVehicle Rental System");
            System.out.println("1. Add Vehicle");
            System.out.println("2. Add Customer");
            System.out.println("3. Rent Vehicle");
            System.out.println("4. Return Vehicle");
            System.out.println("5. View Vehicles");
            System.out.println("6. View Customers");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) 
            {
                case 1 -> addVehicle();
                case 2 -> addCustomer();
                case 3 -> rentVehicle();
                case 4 -> returnVehicle();
                case 5 -> viewVehicles();
                case 6 -> viewCustomers();
                case 7 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice. Try again.");
            }
        } 
        while (choice != 7);
    }
}

public class VehicleRentalApplication 
{
    public static void main(String[] args) 
    {
        RentalSystem system = new RentalSystem();
        system.menu();
    }
}

