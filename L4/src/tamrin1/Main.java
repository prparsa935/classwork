package tamrin1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Map Mp=new HashMap();
        System.out.println("shomare daneshjooi: ");
        Mp.put("Student_Number",sc.nextInt());
        System.out.println("nam:  ");
        Mp.put("Student_Name",sc.next());
        System.out.println("moadel: ");
        Mp.put("Student_A_S",sc.nextInt());
        System.out.println(Mp.get("Student_Name"));
        Student St=new Student(Mp);
        St.Show();




    }



}
