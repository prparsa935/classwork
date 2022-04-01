package tamrin2;

import javax.naming.Name;

public class User<name,family,username,password> implements Cloneable {
    private name name;
    private family family;
    private username username;
    private password password;

    public name getName() {
        return name;
    }

    public void setName(name name) {
        this.name = name;
    }

    public family getFamily() {
        return family;
    }

    public void setFamily(family family) {
        this.family = family;
    }

    public username getUsername() {
        return username;
    }

    public void setUsername(username username) {
        this.username = username;
    }

    public password getPassword() {
        return password;
    }

    public void setPassword(password password) {
        this.password = password;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
    //    User(){
//
//    }
//    User(name name,family family,username username,password password){
//        this.name=name;
//        this.family=family;
//        this.username=username;
//        this.password=password;
//
//    }

}


