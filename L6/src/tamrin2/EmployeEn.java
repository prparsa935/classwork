package tamrin2;


public class EmployeEn {
    private long id;
    private String code;
    private String name;
    private String nationalـCode;
    private String fathers_name;
    private String position;
    private String salary;
    private String workـexperience;
    //    private Connection Con= DriverManager.getConnection("jdbc:mysql://localhost:3306","root","yecgaa4825550100");
    public EmployeEn(){

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNationalـCode() {
        return nationalـCode;
    }

    public void setNationalـCode(String nationalـCode) {
        this.nationalـCode = nationalـCode;
    }

    public String getFathers_name() {
        return fathers_name;
    }

    public void setFathers_name(String fathers_name) {
        this.fathers_name = fathers_name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getWorkـexperience() {
        return workـexperience;
    }

    public void setWorkـexperience(String workـexperience) {
        this.workـexperience = workـexperience;
    }
}


