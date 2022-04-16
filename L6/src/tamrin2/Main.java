package tamrin2;


import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        EmployeRepo userrepo=new EmployeRepo();
        Scanner Sc=new Scanner(System.in);
        System.out.println("""
                1-insert
                2-delete
                """);
        int i=Sc.nextInt();
        EmployeEn userEn=new EmployeEn();
        if(i==1){

            userEn.setId(userrepo.select().size()+1);
            System.out.println("code: ");
            userEn.setCode(Sc.next());
            System.out.println("name: ");
            userEn.setName(Sc.next());
            System.out.println("nationalـCode: ");
            userEn.setNationalـCode(Sc.next());
            System.out.println("fathers_name: ");
            userEn.setFathers_name(Sc.next());
            System.out.println("position: ");
            userEn.setPosition(Sc.next());
            System.out.println("salary: ");
            userEn.setSalary(Sc.next());
            System.out.println("workـexperience: ");
            userEn.setWorkـexperience(Sc.next());
            userrepo.insert(userEn);
            userrepo.commit();
            userrepo.close();

        }
        else if(i==2){
            System.out.println("code");
            String code=Sc.next();
            List<EmployeEn> list=userrepo.select();
            for(EmployeEn Employee:list){
                if(Employee.getCode().equals(code)){
                    userrepo.delete(code);
                }



            }





        }


    }
}
