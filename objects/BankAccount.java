package objects;

public class BankAccount extends Client {
    int agency;
    int account_number;

    public int getAgency() {
        return this.agency;
    }
    public void setAgency(int agency) {
        this.agency = agency;
    }

    public int getAccountNumber() {
        return this.account_number;
    }
    public void setAccountNumber(int account_number) {
        this.account_number = account_number;
    }

    BankAccount(int agency, int account_number, String name, String address, String phone, String cpf) {
        this.agency = agency;
        this.account_number = account_number;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.cpf = cpf;
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
