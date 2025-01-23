
public class BankAccount 
{
    private String accountHolderName;
    private String accountNumber;
    private double balance;

    public BankAccount(String accountHolderName, String accountNumber, double initialBalance)
    {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }
    public void deposit(double amount) 
    {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount");
        }
    }
    public void withdraw(double amount) 
    {
        if (amount > 0 && amount <= balance) 
        {
            balance -= amount;
            System.out.println("Withdrew: " + amount);
        } 
        else if (amount > balance) 
        {
            System.out.println("Insufficient funds");
        } 
        else 
        {
            System.out.println("Invalid withdrawal amount");
        }
    }
    public void checkBalance() 
    {
        System.out.println("Current Balance: " + balance);
    }
    public void getAccountDetails() 
    {
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Account Number: " + accountNumber);
    }
    public static void main(String[] args) 
    {
        BankAccount account = new BankAccount("Ajay", "123456789", 1000.0);

        account.getAccountDetails();

        account.checkBalance();

        account.deposit(500.0);

        account.withdraw(200.0);

        account.checkBalance();
    }
}