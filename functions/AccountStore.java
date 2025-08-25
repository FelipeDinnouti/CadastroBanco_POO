// Stores and retrieves account data
// Is static, should not be instantiated

package functions;

import java.rmi.UnexpectedException;
import java.util.ArrayList;

import objects.*;

public class AccountStore {
    static ArrayList<BankAccount> accounts = new ArrayList<BankAccount>();

    public static boolean AccountExists(int agency, int account_number) {
        boolean found = false;

        //  Search for every account and check if the agency number and account numbers match.
        for (int i = 0; i < accounts.size(); i++) {
            BankAccount acc = accounts.get(i);
            if (acc.getAgency() == agency && acc.getAccountNumber() == account_number) {
                // If found, break the loop
                found = true;
                break;
            }
        }

        // And then finally return the result
        return found;
    }

    public static BankAccount GetAccount(int agency, int account_number) {

        //  Similar to checking existance of an account, searches for an account
        for (int i = 0; i < accounts.size(); i++) {
            BankAccount acc = accounts.get(i);

            if (acc.getAgency() == agency && acc.getAccountNumber() == account_number) {
                // If it matches return the account
                return acc;
            }
        }

        // If it did not find, return null.
        return null;
    }

    // A simple warning so someone else wouldn't try storing the wrong type.
    public static void StoreAccount(CheckingAccount ca) throws UnexpectedException {
        throw new UnexpectedException("Trying to save a checking bank account. Can only save as a generic bank account.");
    }

    public static void StoreAccount(SavingsAccount sa) throws UnexpectedException {
        throw new UnexpectedException("Trying to save a savings bank account. Can only save as a generic bank account.");
    }

    // The correct way to store (generic type)
    public static void StoreAccount(BankAccount ba) {
        accounts.add(ba);
        System.out.println(accounts);
    }
}
