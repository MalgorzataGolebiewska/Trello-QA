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

    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
