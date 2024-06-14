import java.util.*;
class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance=initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount>0) {
            balance+=amount;
        }
    }

    public boolean withdraw(double amount) {
        if (amount>0 && amount<=balance) {
            balance-=amount;
            return true;
        }
        return false;
    }
}

class ATM{
    private BankAccount account;

    public ATM(BankAccount account) {
        this.account=account;
    }

    public void start() {
        Scanner sc=new Scanner(System.in);
        boolean exit=false;

        while (!exit) {
            System.out.println("\nATM Menu:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice=sc.nextInt();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    deposit(sc);
                    break;
                case 3:
                    withdraw(sc);
                    break;
                case 4:
                    exit=true;
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please choose again.");
            }
        }
        sc.close();
    }

    private void checkBalance() {
        System.out.printf("Your current balance is: $%.2f%n", account.getBalance());
    }

    private void deposit(Scanner scanner) {
        System.out.print("Enter amount to deposit: ");
        double amount=scanner.nextDouble();
        account.deposit(amount);
        System.out.printf("$%.2f has been deposited. Your new balance is: $%.2f%n", amount, account.getBalance());
    }

    private void withdraw(Scanner scanner) {
        System.out.print("Enter amount to withdraw: ");
        double amount=scanner.nextDouble();
        if (account.withdraw(amount)) {
            System.out.printf("$%.2f has been withdrawn. Your new balance is: $%.2f%n", amount, account.getBalance());
        }
        else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    public static void main(String[] args) {
        BankAccount userAccount=new BankAccount(500); // Initial balance
        ATM atm=new ATM(userAccount);
        atm.start();
    }
}