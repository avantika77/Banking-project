import java.util.Scanner;

public class Banking {

    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount("AVANTIKA", "S88780");
        bankAccount.showMenu();
    }
}

class BankAccount {
    int balance; // money in bank
    int previousTransaction; // previous amount withdraw
    String clientName;  
    String clientID; 
    double interestRate; 
    BankAccount(String cname, String cid) 
    {
        clientName = cname; 
        clientID = cid; 
        interestRate = 0.05; // Default interest rate (5%)
    }

    void deposit(int amount) {
        if (amount != 0) {
            balance = balance + amount;
            previousTransaction = amount;
        }
    }

    void withdraw(int amount) {
        if (amount != 0) {
            balance = balance - amount; // increment amount
            previousTransaction = -amount;
        }
    }

    void getPreviousTransaction() // transaction method
    {
        if (previousTransaction > 0) {
            System.out.println("Deposited: " + previousTransaction);
        } else if (previousTransaction < 0) {
            System.out.println("Withdrawn: " + Math.abs(previousTransaction));
        } else {
            System.out.println("No transaction occurred");
        }
    }

    // Calculate interest earned
    double calculateInterest() {
        return balance * interestRate;
    }

    // Method to change client details
    void changeClientDetails(String newName) {
        clientName = newName; 
        System.out.println("Client details updated successfully!"); 
    }

    // Method to update client ID
    void updateClientID(String newID) {
        clientID = newID;
        System.out.println("Client ID updated successfully!");
    }

    // Method to get client details
    String getClientDetails() {
        return "Client Name: " + clientName + "\nClient ID: " + clientID; 

    void showMenu() {
        char option = '\0';
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome " + clientName);
        System.out.println("Your ID is " + clientID); 
        System.out.println("\n");
        System.out.println("A. Check Balance");
        System.out.println("B. Deposit");
        System.out.println("C. Withdraw");
        System.out.println("D. Previous Transaction");
        System.out.println("E. Calculate Interest"); 
        System.out.println("F. Change Client Name"); 
       System.out.println("G. Update Client ID");
        System.out.println("H. Get Client Details"); 
         // New option
        System.out.println("I. Exit");

        do {
            System.out.println("=====================================================");
            System.out.println("Enter an Option");
            System.out.println("=====================================================");
            option = scanner.next().charAt(0);
           // System.out.println("\n");

            
            switch (option) {
                case 'A':
                    System.out.println("----------------------------");
                    System.out.println("Balance = " + balance);
                    System.out.println("----------------------------");
                    //System.out.println("\n");
                    break;

                case 'B':
                    System.out.println("----------------------------");
                    System.out.println("Enter an amount to deposit:");
                    System.out.println("----------------------------");
                    int amount = scanner.nextInt();
                    deposit(amount);
                    //System.out.println("\n");
                    break;

                case 'C':
                    System.out.println("----------------------------");
                    System.out.println("Enter an amount to withdraw:");
                    System.out.println("----------------------------");
                    int amount2 = scanner.nextInt();
                    withdraw(amount2);
                    //System.out.println("\n");
                    break;

                case 'D':
                    System.out.println("----------------------------");
                    getPreviousTransaction();
                    System.out.println("----------------------------");
                   // System.out.println("\n");
                    break;

                case 'E':
                    System.out.println("----------------------------");
                    System.out.println("Interest earned: " + calculateInterest());
                    System.out.println("----------------------------");
                   // System.out.println("\n");
                    break;

                case 'F':
                    System.out.println("----------------------------");
                    System.out.println("Enter new client name:");
                    System.out.println("----------------------------");
                    String newName = scanner.next();
                    changeClientDetails(newName); 
                    //System.out.println("\n");
                    break;
case 'G':
                    System.out.println("----------------------------");
                    System.out.println("Enter new client ID:");
                    System.out.println("----------------------------");
                    String newID = scanner.next();
                    updateClientID(newID); // New method to update client ID
                    //System.out.println("\n");
                    break;
                case 'H':
                    System.out.println("----------------------------");
                    System.out.println(getClientDetails()); 
                    System.out.println("----------------------------");
                    //System.out.println("\n");
                    break;

                

                case 'I':
                    System.out.println("**************************************************");
                    break;

                default:
                    System.out.println("Invalid Option!!. Please enter again");
                    break;
            }

        } while (option != 'I');

        System.out.println("Thank you for using our service");
    }
}

