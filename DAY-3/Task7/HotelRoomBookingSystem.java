import java.util.ArrayList;

class Room 
{
    int roomNumber;
    String roomType;
    double price;
    boolean isAvailable;

    public Room(int roomNumber, String roomType, double price) 
    {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.price = price;
        this.isAvailable = true; // Default: Room is available
    }

    public void bookRoom() 
    {
        if (isAvailable) 
        {
            isAvailable = false;
            System.out.println("Room " + roomNumber + " booked successfully.");
        } 
        else 
        {
            System.out.println("Room " + roomNumber + " is not available.");
        }
    }

    public void checkOutRoom() 
    {
        if (!isAvailable) 
        {
            isAvailable = true;
            System.out.println("Room " + roomNumber + " is now available.");
        } else 
        
        {
            System.out.println("Room " + roomNumber + " is already available.");
        }
    }

    @Override
    public String toString() 
    {
        return "Room Number: " + roomNumber + ", Type: " + roomType + ", Price: $" + price + ", Available: " + isAvailable;
    }
}

class StandardRoom extends Room 
{
    public StandardRoom(int roomNumber, double price) 
    {
        super(roomNumber, "Standard", price);
    }
}

class DeluxeRoom extends Room 
{
    public DeluxeRoom(int roomNumber, double price) 
    {
        super(roomNumber, "Deluxe", price);
    }
}

class Customer 
{
    String name;
    String contact;
    int customerId;

    public Customer(int customerId, String name, String contact) 
    {
        this.customerId = customerId;
        this.name = name;
        this.contact = contact;
    }

    @Override
    public String toString() 
    {
        return "Customer ID: " + customerId + ", Name: " + name + ", Contact: " + contact;
    }
}

class Booking 
{
    Customer customer;
    Room room;
    int nights;

    public Booking(Customer customer, Room room, int nights) 
    {
        this.customer = customer;
        this.room = room;
        this.nights = nights;
        room.bookRoom();
    }

    public double calculateTotal() 
    {
        return room.price * nights;
    }

    @Override
    public String toString() 
    {
        return customer + "\nRoom Details: " + room + "\nNights: " + nights + "\nTotal Cost: $" + calculateTotal();
    }
}

public class HotelRoomBookingSystem 
{
    ArrayList<Room> rooms = new ArrayList<>();
    ArrayList<Customer> customers = new ArrayList<>();
    ArrayList<Booking> bookings = new ArrayList<>();

    public HotelRoomBookingSystem() 
    {
        rooms.add(new StandardRoom(101, 100.0));
        rooms.add(new StandardRoom(102, 100.0));
        rooms.add(new DeluxeRoom(201, 200.0));
        rooms.add(new DeluxeRoom(202, 200.0));
    }

    public void bookRoom(Customer customer, String roomType, int nights) 
    {
        for (Room room : rooms) 
        {
            if (room.isAvailable && room.roomType.equalsIgnoreCase(roomType)) 
            {
                Booking booking = new Booking(customer, room, nights);
                bookings.add(booking);
                customers.add(customer);
                System.out.println("Booking successful!\n" + booking);
                return;
            }
        }
        System.out.println("No available rooms of type: " + roomType);
    }

    public void checkOutRoom(int roomNumber) 
    {
        for (Room room : rooms) 
        {
            if (room.roomNumber == roomNumber && !room.isAvailable) 
            {
                room.checkOutRoom();
                return;
            }
        }
        System.out.println("Room not found or already available.");
    }

    public void viewAvailableRooms() 
    {
        System.out.println("Available Rooms:");
        for (Room room : rooms) 
        {
            if (room.isAvailable) 
            {
                System.out.println(room);
            }
        }
    }

    public static void main(String[] args) 
    {
        HotelRoomBookingSystem system = new HotelRoomBookingSystem();

        Customer customer1 = new Customer(1, "Alice", "1234567890");
        system.bookRoom(customer1, "Standard", 3);

        Customer customer2 = new Customer(2, "Bob", "0987654321");
        system.bookRoom(customer2, "Deluxe", 2);

        system.viewAvailableRooms();
        system.checkOutRoom(101);
        system.viewAvailableRooms();
    }
}
