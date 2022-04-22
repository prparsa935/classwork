package kareclasi;

import kareclasi.model.entity.UserEn;
import kareclasi.model.repo.UserRepo;
import kareclasi.model.service.UserServ;

import javax.naming.Name;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        UserEn user=new UserEn();
        UserRepo repo=new UserRepo();
        List<UserEn> UserList=repo.select();
        Scanner Sc=new Scanner(System.in);
        System.out.println("1-Login");
        System.out.println("2-Register");
        int i=Sc.nextInt();
        String input=Sc.next();
        boolean f=true;
        if(i==1){
            System.out.println("Username: ");

            for(UserEn UserEn:UserList){
                if(UserEn.getUsername().equals(input)){
                    System.out.println("password: ");
                    input=Sc.next();
                    if(UserEn.getPassword().equals(input)){
                        System.out.println("you have been logged in");
                        break;
                    }
                }
            }
        }
        else if(i==2){
            while (true){
                UserEn User=new UserEn();
                User.setId(UserList.size());
                System.out.println("UserName: ");
                User.setUsername(Sc.next());
                System.out.println("Email: ");
                User.setEmail(Sc.next());
                System.out.println("Name: ");
                User.setName(Sc.next());
                System.out.println("Password: ");
                User.setPassword(Sc.next());
                for (UserEn UserEn:UserList){
                    if(UserEn.getUsername().equals(User.getUsername())||UserEn.getEmail().equals(User.getEmail())){
                        f=false;
                        break;
                    }
                }
                if(f==false){
                    continue;
                }
                UserServ.getInstance().save(User);


            }

        }
    }
    }