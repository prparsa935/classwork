package tamrin1.model.Entity;

public class UserEn {
    private long id;
    private String name;
    private String Email;
    private String Address;
    private String Education;
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

    public String getAddress() {
        return Address;
    }

    public UserEn setAddress(String Address) {
        this.Address = Address;
        return this;
    }

    public String getEducation() {
        return Education;
    }

    public UserEn setEducation(String Education) {
        this.Education = Education;
        return this;
    }
}

