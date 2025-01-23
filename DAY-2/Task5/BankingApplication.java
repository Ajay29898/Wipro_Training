import java.util.ArrayList;
import java.util.Scanner;

// Base class: Account
abstract class Account {
    String accountNumber;
    String customerName;
    double balance;

    public Account(String accountNumber, String customerName, double balance) {
        this.accountNumber = accountNumber;
        this.customerName = customerName;
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount + ". New balance: " + balance);
    }

    public abstract void withdraw(double amount);

    @Override
    public String toString() {
        return "Account Number: " + accountNumber + ", Name: " + customerName + ", Balance: " + balance;
    }
}

// Subclass: SavingsAccount
class SavingsAccount extends Account {
    double interestRate = 0.03; // 3% interest

    public SavingsAccount(String accountNumber, String customerName, double balance) {
        super(accountNumber, customerName, balance);
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew: " + amount + ". New balance: " + balance);
        } else {
            System.out.println("Insufficient funds in Savings Account.");
        }
    }

    public void addInterest() {
        double interest = balance * interestRate;
        balance += interest;
        System.out.println("Interest added: " + interest + ". New balance: " + balance);
    }
}

// Subclass: CurrentAccount
class CurrentAccount extends Account {
    double overdraftLimit = 5000;

    public CurrentAccount(String accountNumber, String customerName, double balance) {
        super(accountNumber, customerName, balance);
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= balance + overdraftLimit) {
            balance -= amount;
            System.out.println("Withdrew: " + amount + ". New balance: " + balance);
        } else {
            System.out.println("Overdraft limit exceeded.");
        }
    }
}

// Class: BankingSystem
class BankingSystem {
    ArrayList<Account> accounts = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public void createSavingsAccount() {
        System.out.print("Enter Account Number: ");
        String accountNumber = scanner.nextLine();
        System.out.print("Enter Customer Name: ");
        String customerName = scanner.nextLine();
        System.out.print("Enter Initial Deposit: ");
        double balance = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        accounts.add(new SavingsAccount(accountNumber, customerName, balance));
        System.out.println("Savings Account created successfully.");
    }

    public void createCurrentAccount() {
        System.out.print("Enter Account Number: ");
        String accountNumber = scanner.nextLine();
        System.out.print("Enter Customer Name: ");
        String customerName = scanner.nextLine();
        System.out.print("Enter Initial Deposit: ");
        double balance = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        accounts.add(new CurrentAccount(accountNumber, customerName, balance));
        System.out.println("Current Account created successfully.");
    }

    public Account findAccount(String accountNumber) {
        for (Account account : accounts) {
            if (account.accountNumber.equals(accountNumber)) {
                return account;
            }
        }
        System.out.println("Account not found.");
        return null;
    }

    public void deposit() {
        System.out.print("Enter Account Number: ");
        String accountNumber = scanner.nextLine();
        Account account = findAccount(accountNumber);
        if (account != null) {
            System.out.print("Enter Amount to Deposit: ");
            double amount = scanner.nextDouble();
            scanner.nextLine(); // Consume newline
            account.deposit(amount);
        }
    }

    public void withdraw() {
        System.out.print("Enter Account Number: ");
        String accountNumber = scanner.nextLine();
        Account account = findAccount(accountNumber);
        if (account != null) {
            System.out.print("Enter Amount to Withdraw: ");
            double amount = scanner.nextDouble();
            scanner.nextLine(); // Consume newline
            account.withdraw(amount);
        }
    }

    public void transferFunds() {
        System.out.print("Enter Source Account Number: ");
        String sourceAccountNumber = scanner.nextLine();
        System.out.print("Enter Destination Account Number: ");
        String destinationAccountNumber = scanner.nextLine();

        Account sourceAccount = findAccount(sourceAccountNumber);
        Account destinationAccount = findAccount(destinationAccountNumber);

        if (sourceAccount != null && destinationAccount != null) {
            System.out.print("Enter Amount to Transfer: ");
            double amount = scanner.nextDouble();
            scanner.nextLine(); // Consume newline

            if (sourceAccount.balance >= amount) {
                sourceAccount.withdraw(amount);
                destinationAccount.deposit(amount);
                System.out.println("Funds transferred successfully.");
            } else {
                System.out.println("Insufficient funds in source account.");
            }
        }
    }

    public void viewAccounts() {
        if (accounts.isEmpty()) {
            System.out.println("No accounts to display.");
        } else {
            for (Account account : accounts) {
                System.out.println(account);
            }
        }
    }

    public void menu() {
        int choice;
        do {
            System.out.println("\nBanking System");
            System.out.println("1. Create Savings Account");
            System.out.println("2. Create Current Account");
            System.out.println("3. Deposit");
            System.out.println("4. Withdraw");
            System.out.println("5. Transfer Funds");
            System.out.println("6. View Accounts");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> createSavingsAccount();
                case 2 -> createCurrentAccount();
                case 3 -> deposit();
                case 4 -> withdraw();
                case 5 -> transferFunds();
                case 6 -> viewAccounts();
                case 7 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 7);
    }
}

// Main class
public class BankingApplication {
    public static void main(String[] args) {
        BankingSystem bankingSystem = new BankingSystem();
        bankingSystem.menu();
    }
}
