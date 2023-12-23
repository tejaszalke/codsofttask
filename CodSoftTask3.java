import java.util.Scanner;

class BankAccount {
    private double balance;

    public  BankAccount(double initialBalance) 
{
        balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            return true;
        }
        return false;
    }
}

class ATM {
    private BankAccount account;

    public ATM(BankAccount account) {
        this.account = account;
    }

    public void displayMenu() {
        System.out.println("ATM Menu:");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
        System.out.println();
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            displayMenu();
            System.out.print("Select an option (1-4): ");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.println("Balance: Rs. " + account.getBalance());
                    System.out.println();
                    break;
                case 2:
                    System.out.print("Enter the deposit amount: Rs. ");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    System.out.println("Deposited: Rs. " + depositAmount);
                    System.out.println();
                    break;
                case 3:
                    System.out.print("Enter the withdrawal amount: Rs. ");
                    double withdrawAmount = scanner.nextDouble();
                    if (account.withdraw(withdrawAmount)) {
                        System.out.println("Withdrawn: Rs. " + withdrawAmount);
                        System.out.println();
                    } else {
                        System.out.println("Insufficient balance.");
                        System.out.println();
                    }
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please select 1-4.");
                    System.out.println();
            }
        }
    }
}

public class CodSoftTask3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your initial balance: Rs. ");
        double initialBalance = scanner.nextDouble();
        BankAccount userAccount = new BankAccount(initialBalance);
        ATM atm = new ATM(userAccount);
        atm.run();
    }
}
