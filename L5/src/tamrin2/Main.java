package tamrin2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
//        User<String, String, String, String> user=new User<>("parsa","rajabi","prparsa","yecgaa");
//        User user1=null;
//        user1=(User) user.clone();
        User<String,String,String,String> user=new User<>();
        User user1=null,user2=null,user3=null;
        Scanner Sc=new Scanner(System.in);
        System.out.println("name: ");
        user.setName(Sc.next());
        System.out.println("family: ");
        user.setFamily(Sc.next());
        System.out.println("username: ");
        user.setUsername(Sc.next());
        System.out.println("password");
        user.setPassword(Sc.next());
        user1=(User)user.clone();
        user2=(User)user.clone();
        user3=(User)user.clone();




    }
}
