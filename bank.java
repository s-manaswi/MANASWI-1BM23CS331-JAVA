import java.util.Scanner;


class Account {
    protected String customerName;
    protected String accountNumber;
    protected double balance;
    protected String accountType;

   
    public Account(String customerName, String accountNumber, String accountType, double initialBalance) {
        this.customerName = customerName;
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.balance = initialBalance;
    }

   
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposit successful! Current balance: " + balance);
    }

   
    public void displayBalance() {
        System.out.println("Account balance: " + balance);
    }

   
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawal successful! Current balance: " + balance);
        } else {
            System.out.println("Insufficient balance! Withdrawal failed.");
        }
    }

   
    public String getAccountType() {
        return accountType;
    }
}


class SavAcct extends Account {
    private static final double interestRate = 0.04; 

   
    public SavAcct(String customerName, String accountNumber, double initialBalance) {
        super(customerName, accountNumber, "Savings", initialBalance);
    }

   
    public void computeInterest() {
        double interest = balance * interestRate;
        balance += interest;
        System.out.println("Interest of " + interest + " has been added to your account. New balance: " + balance);
    }
}


class CurAcct extends Account {
    private static final double MIN_BALANCE = 500; 
    private static final double PENALTY = 50; 

   
    public CurAcct(String customerName, String accountNumber, double initialBalance) {
        super(customerName, accountNumber, "Current", initialBalance);
    }

   
    public void checkMinimumBalance() {
        if (balance < MIN_BALANCE) {
            balance -= PENALTY;
            System.out.println("Balance is below minimum. A penalty of " + PENALTY + " has been charged. New balance: " + balance);
        }
    }
}

public class Bank {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
       
       
        System.out.print("Enter customer name: ");
        String customerName = scanner.nextLine();

        System.out.print("Enter account type (1 for Savings, 2 for Current): ");
        int accountChoice = scanner.nextInt();
       
        scanner.nextLine();
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();
       
        Account account = null;
       
        if (accountChoice == 1) {
            System.out.print("Enter initial deposit for Savings account: ");
            double initialDeposit = scanner.nextDouble();
account = new SavAcct(customerName, accountNumber, initialDeposit);
        } else if (accountChoice == 2) {
            System.out.print("Enter initial deposit for Current account: ");
            double initialDeposit = scanner.nextDouble();
            account = new CurAcct(customerName, accountNumber, initialDeposit);
        } else {
            System.out.println("Invalid choice! Exiting program.");
            return;
        }

       
        boolean running = true;
        while (running) {
            System.out.println("\nBank Operations Menu:");
            System.out.println("1. Deposit \n 2.withdraw \n 3.Display Balance 4.  Compute Interest (Savings account only) 5.       Check and apply minimum balance penalty (Current account only) 6.Exit ");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 2:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawAmount = scanner.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;
                case 3:
                    account.displayBalance();
                    break;
                case 4:
                    if (account instanceof SavAcct) {
                        ((SavAcct) account).computeInterest();
                    } else {
                        System.out.println("Interest can only be computed for Savings account.");
                    }
                    break;
                case 5:
                    if (account instanceof CurAcct) {
                        ((CurAcct) account).checkMinimumBalance();
                    } else {
                        System.out.println("Minimum balance check can only be applied to Current account.");
                    }
                    break;
                case 6:
                    System.out.println("Exiting program.");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice! Please select a valid option.");
            }
        }
       
        scanner.close();
    }
}