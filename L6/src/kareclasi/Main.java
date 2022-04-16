package kareclasi;

import tamrin1.UserEn;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        UserEn user=new UserEn();
        UserRepo repo=new UserRepo();
        List<kareclasi.UserEn> UserList=repo.select();
        Scanner Sc=new Scanner(System.in);
        System.out.println("1-Login");
        System.out.println("2-Logout");
        int i=Sc.nextInt();
        if(i==1){
            System.out.println("Username: ");

            System.out.println("Username: ");
        }
    }
}
