package dcit50_finals.main;

import java.text.DecimalFormat;

/**
 *
 * @author Bernard Sapida
 */
public class BankModel extends BankDatabase {
    private int accountIndex = -1;
    
    /**
     * This function takes the balance of the account and formats it to a currency format
     */
    public void viewBalance() {
        String balance = super.getBalance(accountIndex);
        DecimalFormat df = new DecimalFormat("##,###");
        String formattedBalance = df.format(Integer.parseInt(balance));
        
        System.out.println("\nBalance Information:");
        System.out.println("Available balance: $" + String.valueOf(formattedBalance));
    }
    
    /**
     * The function checks if the amount the user wants to withdraw is less than or equal to the user's
     * balance. If it is, the user's balance is updated and the user is notified of the transaction. If
     * it isn't, the user is notified that the amount they want to withdraw is too large
     * 
     * @param amount the amount the user wants to withdraw
     * @return A boolean value.
     */
    public boolean withdraw(int amount) {
        int userBalance = Integer.parseInt(super.getBalance(accountIndex));
        
        if(amount <= userBalance) {
            super.setBalance(accountIndex, userBalance - amount);
            System.out.println("\nSuccessful transaction!");
            System.out.println("Amount withdrawn: " + amount);
            System.out.println("Remaining balance: " + super.getBalance(accountIndex));
            System.out.println("You may now claim your money.");
            return true;
        } else {
            System.out.println("The standard withdrawal amount: $20, $40, $60, $100, $200.");
            System.out.println("Please choose a smaller amount.\n");
            return false;
        }
    }
    
    /**
     * This function takes an integer amount and adds it to the current balance of the account
     * 
     * @param amount the amount of money to deposit
     */
    public void depositFunds(int amount) {
        int currentBalance = Integer.parseInt(super.getBalance(accountIndex));
        
        super.setBalance(accountIndex, currentBalance + amount);
        System.out.println("Please insert a deposit envelope containing $" + String.valueOf(amount));
        System.out.println("Your envelope has been received.");
    }
    
    /**
     * This function sets the account index
     * 
     * @param accountIndex The index of the account in the accounts array.
     */
    public void setAccountIndex(int accountIndex) {
        this.accountIndex = accountIndex;
    }
}