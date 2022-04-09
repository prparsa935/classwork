package tamrin1;

public class User {
    private String Username;
    private String Name;
    private String Password;
    private String Address;
    private String EducatinRate;
    private int Age;
    private Long PhoneNumber;

    public String getUsername() {
        return Username;
    }

    public User setUsername(String username) {
        this.Username = username;
        return this;
    }

    public String getName() {
        return Name;
    }

    public User setName(String name) {
        this.Name = name;
        return this;
    }

    public String getPassword() {
        return Password;
    }

    public User setPassword(String password) {
        this.Password = password;
        return this;
    }

    public String getAddress() {
        return Address;
    }

    public User setAddress(String address) {
        this.Address = address;
        return this;
    }

    public String getEducatinRate() {
        return EducatinRate;
    }

    public User setEducatinRate(String educatinRate) {
        this.EducatinRate = educatinRate;
        return this;
    }

    public int getAge() {
        return Age;
    }

    public User setAge(int age) {
        this.Age = age;
        return this;
    }

    public Long getPhoneNumber() {
        return PhoneNumber;
    }

    public User setPhoneNumber(Long phoneNumber) {
        this.PhoneNumber = phoneNumber;
        return this;
    }
    public User(){

    }

    public User(String Username,String Name,String Password,int Age,String Address,Long PhoneNumber,String EducatinRate){
        this.Username=Username;
        this.Name=Name;
        this.Password=Password;
        this.Age=Age;
        this.Address=Address;
        this.PhoneNumber=PhoneNumber;
        this.EducatinRate=EducatinRate;


    }
}
