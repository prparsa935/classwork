package tamrin1;

public class UserEn {
    private long id;
    private String email;
    private String education;
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

    public String getemail() {
        return email;

    }

    public UserEn setemail(String name) {
        this.email = email;
        return this;
    }

    public String geteducation() {
        return education;
    }

    public UserEn seteducation(String education) {
        this.education = education;
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
