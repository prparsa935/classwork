package kare_clasi;

public class Employee {
    private String Name;
    private String Family;
    private int Age;

    public void setPassword(String password) {
        Password = password;
    }

    private String Password;
    private String Username;
    private String Job;
    Employee(){

    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getFamily() {
        return Family;
    }

    public void setFamily(String family) {
        Family = family;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }


    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getJob() {
        return Job;
    }

    public void setJob(String job) {
        Job = job;
    }
}
