// Create, edit or update an existing account
package functions;

import functions.AccountStore;

import objects.BankAccount;
import objects.CheckingAccount;
import objects.SavingsAccount;

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
        BankAccount acc;

        if (account_type == AccountType.CHECKING) {
            acc = new CheckingAccount();
        } else if (account_type == AccountType.SAVINGS) {
            acc = new SavingsAccount(); 
        } else {
            acc = null;
        }

        if (acc == null) {
            System.err.println("Invalid Account Type Passed as Paramemeter");
        } else {
            AccountStore.StoreAccount(acc);
        }
        
    }
    public void updateAccount(int agency, int account_number, String name, String address, String phone, String cpf, AccountType account_type) {
        
    }
}
