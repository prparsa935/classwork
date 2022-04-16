package tamrin1;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        userrepo userrepo=new userrepo();
        Scanner Sc=new Scanner(System.in);
        System.out.println("""
                1-insert
                2-update
                """);
        int i=Sc.nextInt();
        UserEn userEn=new UserEn();
        if(i==1){

            userEn.setId(userrepo.select().size()+1);
            System.out.println("email: ");
            userEn.setemail(Sc.next());
            System.out.println("username: ");
            userEn.setUsername(Sc.next());
            System.out.println("password: ");
            userEn.setPassword(Sc.next());
            System.out.println("education: ");
            userEn.seteducation(Sc.next());
            userrepo.insert(userEn);
            userrepo.commit();
            userrepo.close();

        }
        else if(i==2){
            System.out.println("username: ");
            String username=Sc.next();
            System.out.println("password: ");
            String pasword=Sc.next();
            List<UserEn> list =userrepo.select();
            for(UserEn u:list){
                if(u.getUsername().equals(username)){
                    if(u.getPassword().equals(pasword)){
                        userEn.setId(list.size()+1);
                        System.out.println("email: ");
                        userEn.setemail(Sc.next());
                        System.out.println("username: ");
                        userEn.setUsername(Sc.next());
                        System.out.println("password: ");
                        userEn.setPassword(Sc.next());
                        System.out.println("education: ");
                        userEn.seteducation(Sc.next());
                        userrepo.insert(userEn);
                        userrepo.commit();
                        userrepo.close();
                        System.out.println("done");

                    }
                }

            }
        }


    }
}
