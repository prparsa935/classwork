package TAMRIN1.model.entity;

public class UserEn {
    private long id;
    private String Username;
    private String password;
    private double RDV;
    private double Liability;

    public double getLiability() {
        return Liability;
    }

    public void setLiability(double liability) {
        Liability = liability;
    }

    public double getRDV() {
        return RDV;
    }

    public void setRDV(double RDV) {
        this.RDV = RDV;
    }


    public UserEn(){

    }

    public long getId() {
        return id;
    }

    public UserEn setId(long id) {
        this.id = id;
        return this;
    }


    public String getUsername() {
        return Username;
    }

    public UserEn setUsername(String username) {
        Username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserEn setPassword(String password) {
        this.password = password;
        return this;
    }
}



