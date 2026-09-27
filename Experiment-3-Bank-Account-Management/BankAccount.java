public class Account {
    private int accountNumber;
    private String accountHolder;
    protected double balance;

    // Constructor to initialize basic account details
    public Account(int accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public void displayInitialDetails() {
        System.out.println("----- Account Detail -----");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Balance: " + balance);
        System.out.println();
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("----- Deposit -----");
            System.out.println("Deposited: " + amount);
            System.out.println();
        }
    }

    public void withdraw(double amount) {
        System.out.println("----- Withdrawal -----");
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
            System.out.println("Remaining Balance: " + balance);
        } else {
            System.out.println("Insufficient funds!");
        }
        System.out.println();
    }

    public void calculateInterest(double interestRate) {
        double interestAdded = balance * (interestRate / 100);
        balance += interestAdded;
        System.out.println("----- Interest Calculation -----");
        System.out.println("Interest Added: " + interestAdded);
        System.out.println("New Balance: " + balance);
        System.out.println();
    }

    public void displayFinalDetails() {
        System.out.println("----- Final Account Details -----");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Balance: " + balance);
    }

    // Main execution entry point for your compiler
    public static void main(String[] args) {
        // CHANGED: The account holder name is now updated to "Jayakavya"
        Account acc = new Account(101, "Jayakavya", 10000.0);
        
        acc.displayInitialDetails();
        acc.deposit(2000.0);
        acc.withdraw(5000.0);
        
        // Calculating 5% interest on the remaining 7000.0 to get exactly 350.0
        acc.calculateInterest(5.0); 
        
        acc.displayFinalDetails();
    }
}
