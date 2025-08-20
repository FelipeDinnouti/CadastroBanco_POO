// Stores and retrieves account data
// Is static, should not be instantiated

package functions;

import java.rmi.UnexpectedException;
import java.util.ArrayList;

import objects.*;

public class AccountStore {
    static ArrayList<BankAccount> accounts = new ArrayList<BankAccount>();

    public static void StoreAccount(CheckingAccount ca) throws UnexpectedException {
        throw new UnexpectedException("Trying to save a checking bank account. Can only save as a generic bank account.");
    }

    public static void StoreAccount(SavingsAccount sa) throws UnexpectedException {
        throw new UnexpectedException("Trying to save a savings bank account. Can only save as a generic bank account.");
    }

    public static void StoreAccount(BankAccount ba) {
        accounts.add(ba);
    }
}
