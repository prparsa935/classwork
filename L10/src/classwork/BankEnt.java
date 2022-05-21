package classwork;

import java.io.Serializable;
import java.security.PrivateKey;

public class BankEnt implements Serializable {
    private int id;
    private String name;
    private String Password;
    private float balance;

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
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

    public BankEnt() {}

    public BankEnt(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
