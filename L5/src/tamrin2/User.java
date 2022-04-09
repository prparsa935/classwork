package tamrin2;

import java.security.Key;
import java.util.HashMap;
import java.util.Map;

public class User {
    private static User user=new User();
    public  static  User getInstance(){
        return user;
    }
    private static Map UserMap=new HashMap<>();
    private User(){}
    public void CreateUser(String Username,String Password){
        UserMap.put(Username,Password);
    }
    public void ShowUsers(){
        for(Object user:UserMap.entrySet()){
            System.out.println(user);




        }



    }


}
