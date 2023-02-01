package dcit50_finals.main;

/**
 *
 * @author Bernard Sapida
 */
public abstract class Database {
    /**
     * This function returns an integer that represents whether or not the account number and pin are
     * valid.
     * 
     * @param accountNumber The account number of the account to check.
     * @param pin The pin of the account
     * @return An integer.
     */
    abstract int hasAccount(String accountNumber, String pin);
}