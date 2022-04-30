package tamrin2.model.Entity;

public class UserEn {
    private long id;
    private String name;
    private String Email;
    private String Username;
    private String password;
    //    private Connection Con= DriverManager.getConnection("jdbc:mysql://localhost:3306","root","yecgaa4825550100");
    public UserEn(){

    }

    public long getId() {
        return id;
    }

    public UserEn setId(long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;

    }

    public UserEn setName(String name) {
        this.name = name;
        return this;
    }

    public String getEmail() {
        return Email;
    }

    public UserEn setEmail(String family) {
        this.Email = family;
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

