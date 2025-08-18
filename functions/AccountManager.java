// Create, edit or update an existing account
package functions;

public class AccountManager {
    public enum AccountType {
        CHECKING,
        SAVINGS    
    }

    // Check if an account with this agency and number exists
    public boolean queryAccount(int agency, int account_number) {
        return false;
    }
    public void createAccount(int agency, int account_number, String name, String address, String phone, String cpf, AccountType account_type) {
        
    }
    public void updateAccount(int agency, int account_number, String name, String address, String phone, String cpf, AccountType account_type) {
        
    }
}
