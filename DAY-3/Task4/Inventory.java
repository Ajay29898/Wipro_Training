import java.util.ArrayList;
import java.util.Scanner;

interface SupplierOperations 
{
    void addSupplier(String supplierId, String name, String contact);
    void viewSuppliers();
}

class Product 
{
    String productId;
    String name;
    int quantity;
    double price;

    public Product(String productId, String name, int quantity, double price) 
    {
        this.productId = productId;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    @Override
    public String toString() 
    {
        return "Product ID: " + productId + ", Name: " + name + ", Quantity: " + quantity + ", Price: $" + price;
    }
}

class Supplier 
{
    String supplierId;
    String name;
    String contact;

    public Supplier(String supplierId, String name, String contact) 
    {
        this.supplierId = supplierId;
        this.name = name;
        this.contact = contact;
    }

    @Override
    public String toString() 
    {
        return "Supplier ID: " + supplierId + ", Name: " + name + ", Contact: " + contact;
    }
}

class Inventory implements SupplierOperations 
{
    ArrayList<Product> products = new ArrayList<>();
    ArrayList<Supplier> suppliers = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public void addProduct() 
    {
        System.out.print("Enter Product ID: ");
        String productId = scanner.nextLine();
        System.out.print("Enter Product Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Quantity: ");
        int quantity = scanner.nextInt();
        System.out.print("Enter Price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();

        products.add(new Product(productId, name, quantity, price));
        System.out.println("Product added successfully.");
    }

    public void updateProduct() 
    {
        System.out.print("Enter Product ID to update: ");
        String productId = scanner.nextLine();
        Product product = findProduct(productId);

        if (product != null) 
        {
            System.out.print("Enter New Quantity: ");
            int newQuantity = scanner.nextInt();
            System.out.print("Enter New Price: ");
            double newPrice = scanner.nextDouble();
            scanner.nextLine(); 

            product.quantity = newQuantity;
            product.price = newPrice;
            System.out.println("Product updated successfully.");
        } 
        else 
        {
            System.out.println("Product not found.");
        }
    }

    public void removeProduct() 
    {
        System.out.print("Enter Product ID to remove: ");
        String productId = scanner.nextLine();
        Product product = findProduct(productId);

        if (product != null) 
        {
            products.remove(product);
            System.out.println("Product removed successfully.");
        } 
        else 
        {
            System.out.println("Product not found.");
        }
    }

    public void lowStockAlert(int threshold) 
    {
        System.out.println("Products with low stock (below " + threshold + "):");
        for (Product product : products) 
        {
            if (product.quantity < threshold) 
            {
                System.out.println(product);
            }
        }
    }

    public Product findProduct(String productId) 
    {
        for (Product product : products) 
        {
            if (product.productId.equals(productId)) 
            {
                return product;
            }
        }
        return null;
    }

    @Override
    public void addSupplier(String supplierId, String name, String contact) 
    {
        suppliers.add(new Supplier(supplierId, name, contact));
        System.out.println("Supplier added successfully.");
    }

    @Override
    public void viewSuppliers() 
    {
        if (suppliers.isEmpty()) 
        {
            System.out.println("No suppliers available.");
        } 
        else 
        {
            for (Supplier supplier : suppliers) 
            {
                System.out.println(supplier);
            }
        }
    }

    public void viewProducts() 
    {
        if (products.isEmpty()) 
        {
            System.out.println("No products available.");
        } 
        else 
        {
            for (Product product : products) 
            {
                System.out.println(product);
            }
        }
    }

    public void menu() 
    {
        int choice;
        do 
        {
            System.out.println("\nInventory Management System");
            System.out.println("1. Add Product");
            System.out.println("2. Update Product");
            System.out.println("3. Remove Product");
            System.out.println("4. View Products");
            System.out.println("5. Low Stock Alert");
            System.out.println("6. Add Supplier");
            System.out.println("7. View Suppliers");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) 
            {
                case 1 -> addProduct();
                case 2 -> updateProduct();
                case 3 -> removeProduct();
                case 4 -> viewProducts();
                case 5 -> 
                {
                    System.out.print("Enter Stock Threshold: ");
                    int threshold = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    lowStockAlert(threshold);
                }
                case 6 -> 
                {
                    System.out.print("Enter Supplier ID: ");
                    String supplierId = scanner.nextLine();
                    System.out.print("Enter Supplier Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Supplier Contact: ");
                    String contact = scanner.nextLine();
                    addSupplier(supplierId, name, contact);
                }
                case 7 -> viewSuppliers();
                case 8 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice. Try again.");
            }
        } 
        while (choice != 8);
    }

    public static void main(String[] args) 
    {
        Inventory inventory = new Inventory();
        inventory.menu();
    }
}

