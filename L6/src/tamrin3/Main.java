package tamrin3;

import tamrin1.UserEn;
import tamrin2.EmployeEn;


import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        StudentRepo userrepo= new StudentRepo();

        Scanner Sc=new Scanner(System.in);
            System.out.println("""
                1-insert
                2-delete
                3-update
                """);
            int i=Sc.nextInt();
            StudentEn userEn=new StudentEn();
            if(i==1){
                userEn.setId((long) userrepo.select().size());
                System.out.println("code: ");
                userEn.setCode(Sc.nextLong());
                System.out.println("name: ");
                userEn.setName(Sc.next());
                System.out.println("year: ");
                userEn.setYear(Sc.nextInt());
                userrepo.insert(userEn);
                userrepo.commit();
                userrepo.close();
                System.out.println("done");

            }
            else if(i==2){
                System.out.println("code");
                Long code=Sc.nextLong();
                List<StudentEn> list=userrepo.select();
                for(StudentEn Student:list){
                    if(Student.getCode().equals(code)){
                        userrepo.delete(code);
                    }
                }
            }
            else if(i==3){
                System.out.println("code: ");
                Long code=Sc.nextLong();
                for(StudentEn St: userrepo.select()){
                    if(St.getCode()==code){
                        System.out.println("code: ");
                        St.setCode(Sc.nextLong());
                        System.out.println("name: ");
                        St.setName(Sc.next());
                        System.out.println("year: ");
                        St.setYear(Sc.nextInt());
                        System.out.println("average: ");
                        St.setAverage(Sc.nextFloat());
                        userrepo.update(St);
                    }
                }


    }
}
}

