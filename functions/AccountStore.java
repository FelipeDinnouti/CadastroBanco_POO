// Stores and retrieves account data
// Is static, should not be instantiated

package functions;

import java.rmi.UnexpectedException;
import java.util.ArrayList;

import objects.*;

public class AccountStore {
    ArrayList<CheckingAccount> checking_accounts;
    ArrayList<SavingsAccount> savings_accounts;

    public static void StoreAccount(CheckingAccount ca) {

    }

    public static void StoreAccount(SavingsAccount sa) {

    }

    public static void StoreAccount(BankAccount ba) throws UnexpectedException {
        throw new UnexpectedException("Trying to create a generic bank account. Can only create either savings or checking account.");
    }
}
