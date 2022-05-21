package homework1;

import classwork.BankEnt;
import homework1.UserEn;
import classwork.BankServ;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Scanner;

public class ClientMain {
    private static void Update(UserEn prs,Scanner Sc,UserServ Us){
        System.out.println("New UserName: ");
        prs.setUsername(Sc.nextLine());
        System.out.println("new password: ");
        prs.setPassword(Sc.nextLine());
        try {
            Us.Update(prs);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
    private static void Insert(Scanner Sc,UserServ Us,int lastid) throws Exception {
        UserEn Nu=new UserEn();
        System.out.println("Name: ");
        Nu.setName(Sc.nextLine());
        System.out.println("username: ");
        Nu.setUsername(Sc.nextLine());
        System.out.println("password: ");
        Nu.setPassword(Sc.nextLine());
        System.out.println("Name: ");
        Nu.setId(lastid);
        Us.save(Nu);
    }

    public static void main(String[] args)  {
        try {
            UserServ personService = (UserServ) Naming.lookup("//localhost/DBService");
            UserEn person = new UserEn(1,"javad");
            UserEn person2 = new UserEn(2,"asghar");
            person.setUsername("javadll");
            person.setPassword("1234");
            personService.save(person);
            person2.setUsername("asghartt");
            person2.setPassword("12345");
            personService.save(person2);
            List<UserEn> personList  = personService.report ();
            Scanner Sc=new Scanner(System.in);
            System.out.println("""
                    1-login
                    2-create account""");
            if(Sc.nextInt()==2){
                Insert(Sc,personService,personList.size());
                System.exit(0);
            }
            System.out.println("username: ");
            String Input=Sc.nextLine();
            System.out.println(Input);
            for (UserEn prs : personList) {
                if(Input.equals(prs.getUsername())){
                    System.out.println("password: ");
                    if(Sc.nextLine().equals(prs.getPassword())){
                        System.out.println("you have been logged in");
                        System.out.println("""
                                1-create account
                                2-Update
                                """);
                        if(Sc.nextInt()==2){
                            Update(prs,Sc,personService);
                        }
                        else{
                            Insert(Sc,personService,personList.size());
                        }
                    }
                    else{
                        System.out.println("username or password is wrong");
                        break;
                    }
                }
            }


        } catch (RemoteException e) {
            e.printStackTrace ();
        } catch (NotBoundException e) {
            e.printStackTrace ();
        } catch (MalformedURLException e) {
            e.printStackTrace ();
        } catch (Exception e) {
            e.printStackTrace ();
        }

    }

}
