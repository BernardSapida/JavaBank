package dcit50_finals.main;

import java.util.Scanner;

/**
 *
 * @author Bernard Sapida
 */
public class Terminal {
    private BankModel bankModel = new BankModel();;
    
    // A constructor that prints "Welcome!" when the program is run.
    Terminal() {
        System.out.println("Welcome!");
    }
    
    /**
     * This function is a menu that allows the user to view their balance, withdraw cash, deposit
     * funds, or exit the program
     */
    public void menu() {
        while(true) {
            Scanner sc = new Scanner(System.in);

            System.out.println("\n1 - View my balance");
            System.out.println("2 - Withdraw cash");
            System.out.println("3 - Deposit funds");
            System.out.println("4 - Exit");
            System.out.print("Enter a choice: ");
            String option = sc.nextLine();

            if(option.equals("1")) bankModel.viewBalance();
            else if(option.equals("2")) this.withdraw();
            else if(option.equals("3")) this.deposit();
            else if(option.equals("4")) {
                System.out.println("\nThank you!");
                break;
            }
            else System.out.println("Invalid input! Please try again.");
        }
    }
    
    /**
     * The function withdraw() is a method of the class BankView. It is a void function that takes no
     * parameters. It is a function that allows the user to withdraw money from their account
     */
    public void withdraw() {
        Scanner sc = new Scanner(System.in);
        
        while(true) {
            System.out.println("\nWithdrawal Amounts:");
            System.out.println("[1] $20");
            System.out.println("[2] $40");
            System.out.println("[3] $60");
            System.out.println("[4] $100");
            System.out.println("[5] $200");
            System.out.println("[6] Cancel");
            
            System.out.print("Option: ");
            String option = sc.nextLine();
            
            if(option.equals("1") && bankModel.withdraw(20)) break;
            else if(option.equals("2") && bankModel.withdraw(40)) break;
            else if(option.equals("3") && bankModel.withdraw(60)) break;
            else if(option.equals("4") && bankModel.withdraw(100)) break;
            else if(option.equals("5") && bankModel.withdraw(200)) break;
            else if(option.equals("6")) break;
            else System.out.println("Invalid withdrawal amount! Please try again.\n");
        }
    }
    
    /**
     * The deposit function asks the user for an amount to deposit, and if the amount is valid, it
     * deposits the amount into the bank account
     */
    public void deposit() {
        Scanner sc = new Scanner(System.in);
        
        try {
            System.out.print("\nPlease enter a deposit amount (or 0 to cancel): ");
            int amount = sc.nextInt();
            
            if(amount < 0) throw new Exception();
            if(amount > 0) bankModel.depositFunds(amount);
        } catch(Exception e) {
            System.out.println("Invalid input! Please try again.");
            deposit();
        }
    }
    
    /**
     * This function prompts the user to enter their account number and pin. If the account number and
     * pin are correct, the function breaks out of the loop and returns the index of the account in the
     * array. If the account number and pin are incorrect, the function prints an error message and
     * prompts the user to enter their account number and pin again
     */
    public void login() {
        Scanner sc = new Scanner(System.in);
        
        while(true) {
            System.out.print("\nPlease enter your account number: ");
            String accountNumber = sc.nextLine();

            System.out.print("Enter your PIN: ");
            String pin = sc.nextLine();
            
            int accountIndex = bankModel.hasAccount(accountNumber, pin);
            
            if(accountIndex != -1) {
                bankModel.setAccountIndex(accountIndex);
                break;
            }
            
            System.out.println("The account number or pin is incorrect! Please try again.");
        }
    }
}