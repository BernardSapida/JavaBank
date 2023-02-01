package dcit50_finals.main;

/**
 *
 * @author Bernard Sapida
 */
public class Main {

    public static void main(String[] args) {
        startTransaction();
    }
    
    /**
     * > The function starts a transaction by creating a new terminal object and then calling the login
     * and menu functions
     */
    public static void startTransaction() {
        Terminal terminal = new Terminal();
        
        while(true) {
            terminal.login();
            terminal.menu();
        }
    }
}