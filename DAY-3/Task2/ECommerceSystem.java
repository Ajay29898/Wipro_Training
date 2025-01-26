// This program implements an E-Commerce Product Management System in Java that provides functionality to manage products, customers, and orders. 
// Users can perform tasks such as adding/removing products, registering customers, creating orders, viewing order history, 
// and saving order details to a file.

import java.io.*;
import java.util.*;

class Product                  // Represents a product in the e-commerce system.
{
    String productId;
    String name;
    double price;

    public Product(String productId, String name, double price) 
    {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() 
    {
        return "Product ID: " + productId + ", Name: " + name + ", Price: " + price;
    }
}

class Customer                 // Represents a customer in the e-commerce system.
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

class Order                   // Represents an order placed by a customer.
{
    Customer customer;
    List<Product> products = new ArrayList<>();
    double totalCost;

    public Order(Customer customer) 
    {
        this.customer = customer;
    }

    public void addProduct(Product product) 
    {
        products.add(product);
        totalCost += product.price;
    }

    // StringBuilder avoids creating multiple string objects by modifying a single mutable object.In this case, no new object is 
    // created—StringBuilder modifies the same object, making it faster and memory-efficient.
    // The append() method of StringBuilder is used to add text or data to the existing string being built.
    @Override
    public String toString() 
    {
        String details = "Order Details:\n";
        details += "Customer: " + customer + "\n";
        details += "Products:\n";
    
        for (Product product : products) {
            details += "- " + product + "\n";
        }
    
        details += "Total Cost: " + totalCost;
        return details;
    }
}

// This class provides the core functionality of the e-commerce system, including inventory and customer management, 
// order creation, and data storage.

public class ECommerceSystem 
{
    ArrayList<Product> inventory = new ArrayList<>();         // A list of available products
    ArrayList<Customer> customers = new ArrayList<>();        // A list of registered customers.
    ArrayList<Order> orderHistory = new ArrayList<>();        //  A list of all placed orders.
    Scanner scanner = new Scanner(System.in);

    public void addProduct()                         // Prompts the user to enter product details and adds a new product to the inventory:
    {
        System.out.print("Enter Product ID: ");
        String productId = scanner.nextLine();
        System.out.print("Enter Product Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Product Price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();
        Product product= new Product(productId, name, price);
        inventory.add(product);
        System.out.println("Product added successfully.");
    }

    public void removeProduct()                       // Removes a product from the inventory by matching the product ID:
    {
        System.out.print("Enter Product ID to remove: ");
        String productId = scanner.nextLine();
        Iterator<Product> iterator = inventory.iterator();
        while (iterator.hasNext())    // It is used to check whether there are more elements available to iterate over in a collection.
        {                             // // It returns a boolean value (true or false).
            Product product = iterator.next();              // Get the next product in the list
            if (product.productId.equals(productId)) 
            {
                iterator.remove(); 
            }
        }
        System.out.println("Product removed successfully.");
    }

    public void addCustomer()                          // Prompts the user to enter customer details and registers the customer in the system:
    {
        System.out.print("Enter Customer ID: ");
        String customerId = scanner.nextLine();
        System.out.print("Enter Customer Name: ");
        String name = scanner.nextLine();
        Customer customer = new Customer(customerId, name);
        customers.add(customer);
        System.out.println("Customer added successfully.");
    }
    // Prompts the user for a customer ID and validates if the customer exists. Allows the user to add products (by product ID) to the order.
    // Calculates the total cost and adds the order to the orderHistory list:

    public void createOrder() 
    {
        System.out.print("Enter Customer ID: ");       
        String customerId = scanner.nextLine();
        Customer customer = null;
    
        for (Customer c : customers)    // Search for customer by customerId
        {
            if (c.customerId.equals(customerId)) 
            {
                customer = c;  // Customer found
                break;
            }
        }
        if (customer == null)     // If customer is not found, print message and exit
        {
            System.out.println("Customer not found.");
            return;
        }
        Order order = new Order(customer);   // Create a new order for the found customer

        while (true)    // Keep adding products to the order until user types 'done'
        {
            System.out.print("Enter Product ID to add to the order (or type 'done'): ");
            String productId = scanner.nextLine();
    
            if (productId.equalsIgnoreCase("done")) 
            {
                break;  // Exit loop if user types 'done'
            }
            Product product = null;       // Search for product by productId
            for (Product p : inventory) 
            {
                if (p.productId.equals(productId)) 
                {
                    product = p;  // Product found
                    break;
                }
            }
            if (product != null)        // If product is found, add it to the order
            {
                order.addProduct(product);
                System.out.println("Product added to order.");
            } 
            else 
            {
                System.out.println("Product not found.");
            }
        }
        orderHistory.add(order);    // Add the order to order history and display it
        System.out.println("Order created successfully.");
        System.out.println(order);
    }
    public void viewOrders() 
    {
        if (orderHistory.isEmpty()) 
        {
            System.out.println("No orders placed yet.");
        } 
        else 
        {
            for (Order order : orderHistory) 
            {
                System.out.println(order);
                System.out.println("-------------");
            }
        }
    }
    // saveOrdersToFile() is designed to save the history of all the orders (stored in the orderHistory list) to a file named order_history.txt
    //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("example.txt"));
    //bufferedWriter.write("Hello, World!");
    //bufferedWriter.close(); 

    public void saveOrdersToFile() 
    {
        try (BufferedWriter bufferedwriter = new BufferedWriter(new FileWriter("order_history.txt", true))) 
        {
            for (Order order : orderHistory) 
            {
                bufferedwriter.write(order.toString()+"\n\n");
            }
            bufferedwriter.close();
            System.out.println("Order history saved to file.");
        } 
        catch (IOException e) 
        {
            System.out.println("Error saving orders: " + e.getMessage());
        }
    }

    public void menu() 
    {
        int choice;
        do 
        {
            System.out.println("\nE-Commerce Product Management System");
            System.out.println("1. Add Product");
            System.out.println("2. Remove Product");
            System.out.println("3. Add Customer");
            System.out.println("4. Create Order");
            System.out.println("5. View Orders");
            System.out.println("6. Save Orders to File");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) 
            {
                case 1 -> addProduct();
                case 2 -> removeProduct();
                case 3 -> addCustomer();
                case 4 -> createOrder();
                case 5 -> viewOrders();
                case 6 -> saveOrdersToFile();
                case 7 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice. Try again.");
            }
        } 
        while (choice != 7);
    }
    public static void main(String[] args) 
    {
        ECommerceSystem system = new ECommerceSystem();
        system.menu();
    }
}
