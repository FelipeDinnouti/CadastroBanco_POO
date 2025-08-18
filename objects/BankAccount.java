package objects;

import java.rmi.UnexpectedException;

import functions.AccountStore;

public class BankAccount extends Client {
    int agency;
    int account_number;

    int getAgency() {
        return this.agency;
    }
    void setAgency(int agency) {
        this.agency = agency;
    }

    int getAccountNumber() {
        return this.account_number;
    }
    void setAccountNumber(int account_number) {
        this.account_number = account_number;
    }

    BankAccount() {
        try {
            AccountStore.StoreAccount(this);
        } catch (UnexpectedException e) {
            System.err.println("Tried to create invalid bank account.");
        }
    }

    // Main methods
    void initializeAccount(int agency, int account_number, String name, String address, String phone, String cpf) {
        // Bank account attributes
        this.agency = agency;
        this.account_number = account_number;
        
        // Person attributes
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.cpf = cpf;
    }
}
