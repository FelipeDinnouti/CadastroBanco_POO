// Create, edit or update an existing account
package functions;

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
        return AccountStore.AccountExists(agency, account_number);
    }

    public BankAccount getAccount(int agency, int account_number) {
        return AccountStore.GetAccount(agency, account_number);
    }

    public void createAccount(int agency, int account_number, String name, String address, String phone, String cpf, AccountType account_type) {
        BankAccount acc;

        if (account_type == AccountType.CHECKING) {
            acc = new CheckingAccount(agency, account_number, name, address, phone, cpf);
        } else if (account_type == AccountType.SAVINGS) {
            acc = new SavingsAccount(agency, account_number, name, address, phone, cpf); 
        } else {
            acc = null;
        }

        if (acc == null) {
        } else {
            AccountStore.StoreAccount(acc);
        }
        
    }
    public void updateAccount(int agency, int account_number, String name, String address, String phone, String cpf, AccountType account_type) {
        boolean account_exists = queryAccount(agency, account_number);

        if (!account_exists) {
            return;
        }

        BankAccount acc = getAccount(agency, account_number);

        // Can only update these fields.
        acc.setName(name);
        acc.setAddress(address);
        acc.setPhone(phone);
        acc.setCpf(cpf);
    }
}
