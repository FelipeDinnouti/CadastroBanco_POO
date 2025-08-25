package objects;

public class Person {
    String name;
    String address;

    String phone;
    String cpf;

    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return this.address;
    }
    public void setAddress(String address){
        this.address = address;
    }

    public String getPhone() {
        return this.phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCpf() {
        return this.cpf;
    }  
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
