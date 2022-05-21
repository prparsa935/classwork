package homework2;


import homework1.UserEn;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Scanner;

public class ClientMain {
    private static CustomerEn Login(List<CustomerEn> personList){
        Scanner Sc=new Scanner(System.in);
        System.out.println("username: ");
        String Input=Sc.nextLine();
        System.out.println(Input);
        for(CustomerEn Cs:personList){
            if(Input.equals(Cs.getName())){
                System.out.println("password: ");
                if(Cs.getPassword().equals(Sc.nextLine())){
                    System.out.println("you have been logged in");
                    return Cs;

                }
                else{
                    System.out.println("username or password is wring");
                    System.exit(0);

                }
            }
        }
        return null;


    }

    public static void main(String[] args)  {
        try {
            customerServ personService = (customerServ) Naming.lookup("//localhost/DBService");
            List<CustomerEn> personList  = personService.report ();
            Scanner Sc=new Scanner(System.in);
            CustomerEn thisuser=Login(personList);
            System.out.println("""
                    1-قرمه سبزی
                    2-قیمه""");
            if(Sc.nextInt()==1){
                if(thisuser.getBalance()>=90000){
                    thisuser.setBalance(thisuser.getBalance()-90000);
                    personService.Update(thisuser);
                    System.out.println("سفارش شما با موفقیت ثبت شد.");

                }
            }
            else{
                if(thisuser.getBalance()>=80000){
                    thisuser.setBalance(thisuser.getBalance()-80000);
                    personService.Update(thisuser);
                    System.out.println("سفارش شما با موفقیت ثبت شد.");

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