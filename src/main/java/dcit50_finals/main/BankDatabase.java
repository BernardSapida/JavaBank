package dcit50_finals.main;

/**
 *
 * @author Bernard Sapida
 */
public class BankDatabase extends Database {
    private String[][] accounts = {
        { "Account 1", "201511032", "88888", "80500" },
        { "Account 2", "201563244", "12345", "3000" },
        { "Account 3", "201410230", "54321", "27450" },
        { "Account 4", "201596427", "98765", "6500" },
        { "Account 5", "201456329", "65432", "13200" },
    };
    
    /**
     * This function takes in a string account number and a string pin number and returns the index of
     * the account in the accounts array if the account exists, otherwise it returns -1
     * 
     * @param accountNumberInput The account number the user entered
     * @param pinInput The pin the user entered
     * @return The index of the account in the accounts array.
     */
    public int hasAccount(String accountNumberInput, String pinInput) {
        String accountNumber, pin;
        
        for(int i = 0; i < accounts.length; i++) {
            accountNumber = accounts[i][1];
            pin = accounts[i][2];
            
            if(accountNumber.equals(accountNumberInput) && pin.equals(pinInput)) {
                return i;
            }
        }
        
        return -1;
    }
    
    /**
     * This function takes in an index and a balance and sets the balance of the account at the given
     * index to the given balance
     * 
     * @param index the index of the account in the accounts array
     * @param balance The new balance of the account
     */
    public void setBalance(int index, int balance) {
        this.accounts[index][3] = String.valueOf(balance);
    }
    
    /**
     * This function returns the balance of the account at the given index
     * 
     * @param index the index of the account in the accounts array
     * @return The balance of the account at the given index.
     */
    public String getBalance(int index) {
        return this.accounts[index][3];
    }
}