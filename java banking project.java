import java.util.Scanner;      // java.util package  

public class Banking { 

    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount("AVANTIKA", "S88780");
        bankAccount.showMenu();
    }
}

class BankAccount {
    int balance;  // money in bank
    int previousTransaction; // previous amount withdrawn 
    int totalDeposits; // total deposits made
    int totalWithdrawals; // total withdrawals made
    String clientName;  // client name
    String accountNumber; // client account number
    double interestRate; // interest here,5%

    BankAccount(String cname, String accNum) {  
        clientName = cname; 
        accountNumber = accNum; // account number
        interestRate = 0.05; // Default interest rate (5%)
    }

    void deposit(int amount) {     // deposit method
        if (amount != 0) {
            balance += amount;
            previousTransaction = amount;
            totalDeposits += amount;
        }
    }

    void withdraw(int amount) {     // withdraw method
        if (amount != 0) {
            balance -= amount; // decrement amount from balance
            previousTransaction = -amount;
            totalWithdrawals += amount;
        }
    }

    void getPreviousTransaction() {        //getPreviousTransaction method
        if (previousTransaction > 0) {
            System.out.println("Deposited: " + previousTransaction);
        } else if (previousTransaction < 0) {
            System.out.println("Withdrawn: " + Math.abs(previousTransaction));
        } else {
            System.out.println("No transaction occurred");
        }
    }

    double calculateInterest() {     // interset method
        return balance * interestRate;
    }

    void changeClientDetails(String newName) {           // change client name
        clientName = newName; 
        System.out.println("Client details updated successfully!"); 
    }

    void updateAccountNumber(String newAccNum) {
        accountNumber = newAccNum;
        System.out.println("Account number updated successfully!");
    }

    String getClientDetails() {
        double interestEarned = calculateInterest();
        String previousTransactionDetails;
        if (previousTransaction > 0) {
            previousTransactionDetails = "Deposited: " + previousTransaction;
        } else if (previousTransaction < 0) {
            previousTransactionDetails = "Withdrawn: " + Math.abs(previousTransaction);
        } else {
            previousTransactionDetails = "No transaction occurred";
        }

        return "Client Name: " + clientName + "\n" +
               "Account Number: " + accountNumber + "\n" +
               "Balance: " + balance + "\n" +
               previousTransactionDetails + "\n" +
               "Total Deposits: " + totalDeposits + "\n" +
               "Total Withdrawals: " + totalWithdrawals + "\n" +
               "Interest Earned: " + interestEarned;
    }

    void showMenu() {
        char option = '\0';
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome " + clientName);
        System.out.println("Your Account Number is " + accountNumber); 
        System.out.println("\n");
        System.out.println("A. Check Balance");
        System.out.println("B. Deposit");
        System.out.println("C. Withdraw");
        System.out.println("D. Previous Transaction");
        System.out.println("E. Calculate Interest"); 
        System.out.println("F. Change Client Name"); 
        System.out.println("G. Update Account Number");
        System.out.println("H. Get Client Details"); 
        System.out.println("I. Exit");

        do {
            System.out.println("=====================================================");
            System.out.println("Enter an Option");
            System.out.println("=====================================================");
            option = scanner.next().charAt(0);
            scanner.nextLine(); // consume the newline character left after next().charAt(0)

            switch (option) {
                case 'A':
                    System.out.println("----------------------------");
                    System.out.println("Balance = " + balance);
                    System.out.println("----------------------------");
                    break;

                case 'B':
                    System.out.println("----------------------------");
                    System.out.println("Enter an amount to deposit:");
                    System.out.println("----------------------------");
                    int amount = scanner.nextInt();
                    deposit(amount);
                    System.out.println("Deposited: " + amount);
                    System.out.println("----------------------------");
                    break;

                case 'C':
                    System.out.println("----------------------------");
                    System.out.println("Enter an amount to withdraw:");
                    System.out.println("----------------------------");
                    int amount2 = scanner.nextInt();
                    withdraw(amount2);
                    System.out.println("Withdrawn: " + amount2);
                    System.out.println("----------------------------");
                    break;

                case 'D':
                    System.out.println("----------------------------");
                    getPreviousTransaction();
                    System.out.println("----------------------------");
                    break;

                case 'E':
                    System.out.println("----------------------------");
                    System.out.println("Interest earned: " + calculateInterest());
                    System.out.println("----------------------------");
                    break;

                case 'F':
                    System.out.println("----------------------------");
                    System.out.println("Enter new client name:");
                    System.out.println("----------------------------");
                    String newName = scanner.nextLine();
                    changeClientDetails(newName); 
                    System.out.println("----------------------------");
                    break;

                case 'G':
                    System.out.println("----------------------------");
                    System.out.println("Enter new account number:");
                    System.out.println("----------------------------");
                    String newAccNum = scanner.nextLine();
                    updateAccountNumber(newAccNum); 
                    System.out.println("----------------------------");
                    break;

                case 'H':
                    System.out.println("----------------------------");
                    System.out.println(getClientDetails()); 
                    System.out.println("----------------------------");
                    break;

                case 'I':
                    System.out.println("*****************************************************");
                    break;

                default:
                    System.out.println("Invalid Option!!. Please enter again");
                    break;
            }

        } while (option != 'I');

        System.out.println("Thank you for using our service!");
        scanner.close();
    }
}
