package objects;

public class Person {
    String name;
    String address;

    String phone;
    String cpf;

    String getName() {
        return this.name;
    }
    void setName(String name) {
        this.name = name;
    }

    String getAddress() {
        return this.address;
    }
    void setAddress(String address){
        this.address = address;
    }

    String getPhone() {
        return this.phone;
    }
    void setPhone(String phone) {
        this.phone = phone;
    }

    String getCpf() {
        return this.cpf;
    }  
    void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
