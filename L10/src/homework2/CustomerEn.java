package homework2;

import java.io.Serializable;

public class CustomerEn implements Serializable {
    private int id;
    private String name;
    private String Password;
    private String username;

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    private float balance;

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername (String Username) {
        this.username = username;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CustomerEn() {}

    public CustomerEn(int id, String name) {
        this.id = id;
        this.name = name;
    }
}