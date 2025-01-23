import java.util.ArrayList;
import java.util.Scanner;

class Book 
{
    String bookId;
    String title;
    String author;
    int copies;

    public Book(String bookId, String title, String author, int copies) 
    {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.copies = copies;
    }

    @Override
    public String toString() 
    {
        return "Book ID: " + bookId + ", Title: " + title + ", Author: " + author + ", Copies: " + copies;
    }
}

class Member 
{
    String memberId;
    String name;

    public Member(String memberId, String name) 
    {
        this.memberId = memberId;
        this.name = name;
    }

    @Override
    public String toString() 
    {
        return "Member ID: " + memberId + ", Name: " + name;
    }
}

class LibraryManagement
{
    ArrayList<Book> books = new ArrayList<>();
    ArrayList<Member> members = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public void addBook() 
    {
        System.out.print("Enter Book ID: ");
        String bookId = scanner.nextLine();
        System.out.print("Enter Title: ");
        String title = scanner.nextLine();
        System.out.print("Enter Author: ");
        String author = scanner.nextLine();
        System.out.print("Enter Number of Copies: ");
        int copies = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        books.add(new Book(bookId, title, author, copies));
        System.out.println("Book added successfully.");
    }

    public void addMember() 
    {
        System.out.print("Enter Member ID: ");
        String memberId = scanner.nextLine();
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        members.add(new Member(memberId, name));
        System.out.println("Member added successfully.");
    }

    public void issueBook() 
    {
        System.out.print("Enter Book ID: ");
        String bookId = scanner.nextLine();
        System.out.print("Enter Member ID: ");
        String memberId = scanner.nextLine();

        for (Book book : books) 
        {
            if (book.bookId.equals(bookId)) 
            {
                if (book.copies > 0) 
                {
                    book.copies--;
                    System.out.println("Book issued to Member ID: " + memberId);
                    return;
                } 
                else 
                {
                    System.out.println("No copies available.");
                    return;
                }
            }
        }
        System.out.println("Book not found.");
    }

    public void returnBook() 
    {
        System.out.print("Enter Book ID: ");
        String bookId = scanner.nextLine();

        for (Book book : books) 
        {
            if (book.bookId.equals(bookId)) 
            {
                book.copies++;
                System.out.println("Book returned successfully.");
                return;
            }
        }
        System.out.println("Book not found.");
    }

    public void viewBooks() 
    {
        System.out.println("Books:");
        for (Book book : books) 
        {
            System.out.println(book);
        }
    }

    public void viewMembers() 
    {
        System.out.println("Members:");
        for (Member member : members) 
        {
            System.out.println(member);
        }
    }

    public void menu() 
    {
        int choice;
        do 
        {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Add Member");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. View Books");
            System.out.println("6. View Members");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) 
            {
                case 1 -> addBook();
                case 2 -> addMember();
                case 3 -> issueBook();
                case 4 -> returnBook();
                case 5 -> viewBooks();
                case 6 -> viewMembers();
                case 7 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice. Try again.");
            }
        } 
        while (choice != 7);
    }
}

public class LibraryManagementApp
{
    public static void main(String[] args) 
    {
        LibraryManagement lms = new LibraryManagement();
        lms.menu();
    }
}