package objects;

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
}
