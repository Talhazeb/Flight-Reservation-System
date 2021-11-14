package frs;

public class Passenger {

    String login_username;
    String password;

    String name;
    String phone_number;
    String address;
    char gender;
    int age;
    String cnic;
    String passport_number;

    public void setLogin_username(String username) {
        this.login_username = username;
    }

    public String getLogin_username() {
        return login_username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public char getGender() {
        return gender;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setCNIC(String cnic) {
        this.cnic = cnic;
    }

    public String getCNIC() {
        return cnic;
    }

    public void setPassport_number(String passport_number) {
        this.passport_number = passport_number;
    }

    public String getPassport_number() {
        return passport_number;
    }

    public void setAll(String name, String phone_number, String address, char gender, int age, String cnic,
            String passport_number) {
        this.name = name;
        this.phone_number = phone_number;
        this.address = address;
        this.gender = gender;
        this.age = age;
        this.cnic = cnic;
        this.passport_number = passport_number;
    }

}
