package models;

public class UserData {
    private String email;
    private String password;

    public UserData() {
        this.email = "automated.testing00@gmail.com";
        this.password = "dupa1234";
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

}