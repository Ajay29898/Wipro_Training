import java.io.*;
import java.util.*;

class Product              
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

class Order               
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

public class ECommerceSystem 
{
    ArrayList<Product> inventory = new ArrayList<>();        
    ArrayList<Customer> customers = new ArrayList<>();        
    ArrayList<Order> orderHistory = new ArrayList<>();        
    Scanner scanner = new Scanner(System.in);

    public void addProduct()                        
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

    public void removeProduct()                       
    {
        System.out.print("Enter Product ID to remove: ");
        String productId = scanner.nextLine();
        Iterator<Product> iterator = inventory.iterator();
        while (iterator.hasNext())    
        {                             
            Product product = iterator.next();             
            if (product.productId.equals(productId)) 
            {
                iterator.remove(); 
            }
        }
        System.out.println("Product removed successfully.");
    }

    public void addCustomer()                          
    {
        System.out.print("Enter Customer ID: ");
        String customerId = scanner.nextLine();
        System.out.print("Enter Customer Name: ");
        String name = scanner.nextLine();
        Customer customer = new Customer(customerId, name);
        customers.add(customer);
        System.out.println("Customer added successfully.");
    }

    public void createOrder() 
    {
        System.out.print("Enter Customer ID: ");       
        String customerId = scanner.nextLine();
        Customer customer = null;
    
        for (Customer c : customers)    
        {
            if (c.customerId.equals(customerId)) 
            {
                customer = c;  
                break;
            }
        }
        if (customer == null)     
        {
            System.out.println("Customer not found.");
            return;
        }
        Order order = new Order(customer);   

        while (true)    
        {
            System.out.print("Enter Product ID to add to the order (or type 'done'): ");
            String productId = scanner.nextLine();
    
            if (productId.equalsIgnoreCase("done")) 
            {
                break;  
            }
            Product product = null;       
            for (Product p : inventory) 
            {
                if (p.productId.equals(productId)) 
                {
                    product = p; 
                    break;
                }
            }
            if (product != null)      
            {
                order.addProduct(product);
                System.out.println("Product added to order.");
            } 
            else 
            {
                System.out.println("Product not found.");
            }
        }
        orderHistory.add(order);   
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
