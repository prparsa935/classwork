package TAMRIN1;

import TAMRIN1.model.entity.UserEn;
import TAMRIN1.model.service.UserServ;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner Sc=new Scanner(System.in);
        UserEn Thisuser=null;
        System.out.println("username: ");
        try {
            for(UserEn user: UserServ.getInstance().report()){
                if(Sc.next().equals(user.getUsername())){
                    System.out.println("password: ");
                    if (Sc.next().equals(user.getPassword())){
                        System.out.println("you have been logged in");
                        Thisuser=user;
                        break;
                    }
                    else{
                        System.exit(0);
                    }
                }
            }

        } catch (Exception e) {
            System.out.println("some thing was wrong ");
            e.printStackTrace();
        }
        System.out.println("""
                ۲گیگ-۱۰۰۰ تومان-1
                ۴گیگ-۲۰۰۰ تومان-2
                ۱۰گیگ-۵۰۰۰ تومان-3
                ۲۵گیگ-۱۰۰۰۰ تومان-4""");
        switch(Sc.nextInt()) {
            case 1:
                try {
                    Thisuser.setLiability(Thisuser.getLiability()+1000);
                    Thisuser.setRDV(Thisuser.getRDV()+2);
                    UserServ.getInstance().edit(Thisuser);

                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case 2:
                try {
                    Thisuser.setLiability(Thisuser.getLiability()+2000);
                    Thisuser.setRDV(Thisuser.getLiability()+4);
                    UserServ.getInstance().edit(Thisuser);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case 3:
                try {
                    Thisuser.setLiability(Thisuser.getLiability()+5000);
                    Thisuser.setRDV(Thisuser.getLiability()+10);
                    UserServ.getInstance().edit(Thisuser);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case 4:
                try {
                    Thisuser.setLiability(Thisuser.getLiability()+10000);
                    Thisuser.setRDV(Thisuser.getLiability()+25);
                    UserServ.getInstance().edit(Thisuser);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            default:
                // code block
        }



    }
}
