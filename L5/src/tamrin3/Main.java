package tamrin3;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner Sc=new Scanner(System.in);
        Student<String,String,String> s=new Student();
        System.out.println("name: ");
        s.setName(Sc.next());
        System.out.println("StudentNum: ");
        s.setStudentNum(Sc.next());
        System.out.println("your father's name: ");
        s.setFatherName(Sc.next());
        List Ls=new ArrayList();
        for(int i=1;i<6;i++){
            System.out.println("enter grade"+i+": ");
            Ls.add(Sc.next());

        }
        s.setGrades(Ls);
        s.ShowGrades();

    }

}
