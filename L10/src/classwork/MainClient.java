package classwork;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Scanner;

public class MainClient {
    public static void main(String[] args)  {
        try {
            BankServ personService = (BankServ) Naming.lookup("//localhost/DBService");
            BankEnt person = new BankEnt(1,"javad");
            BankEnt person2 = new BankEnt(2,"asghar");
            person.setBalance(2000);
            person.setPassword("1234");
            personService.save(person);
            person2.setBalance(4000);
            person2.setPassword("12345");
            personService.save(person2);

            List<BankEnt> personList  = personService.report ();
            Scanner Sc=new Scanner(System.in);
            System.out.println("username: ");
            String Input=Sc.nextLine();
            System.out.println(Input);
            for (BankEnt prs : personList) {
                if(Input.equals(prs.getName())){
                    System.out.println("password: ");
                    Input=Sc.nextLine();
                    if(prs.getPassword().equals(Input)){
                        float Money;
                        System.out.println("you have been logged in");
                        System.out.println("target username: ");
                        Input=Sc.nextLine();
                        for(BankEnt prs2 : personList){
                            if(prs2.getName().equals(Input)){
                                System.out.println("how much money you want transfer: ");
                                Money=Sc.nextFloat();
                                if(prs.getBalance()>=Money){
                                    prs.setBalance(prs.getBalance()-Money);
                                    prs2.setBalance(prs2.getBalance()+Money);
                                    personService.Deposit(prs,prs2);
                                    System.out.println(prs.getBalance());
                                    System.out.println(prs2.getBalance());
                                }
                                else{
                                    System.out.println("not enough money");
                                    break;
                                }
                            }
                        }
                    }
                    else{
                        System.out.println("wrong username or password");
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
