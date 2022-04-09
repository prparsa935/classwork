package tamrin1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String Username;
        String Name;
        String Password;
        String Address;
        String EducatinRate;
        int Age;
        Long PhoneNumber;
        Scanner Sc=new Scanner(System.in);
        System.out.println("UserName: ");
        Username=Sc.next();
        System.out.println("Password: ");
        Password=Sc.next();
        System.out.println("Name: ");
        Name=Sc.next();
        System.out.println("Age: ");
        Age=Sc.nextInt();
        System.out.println("PhoneNumber: ");
        PhoneNumber=Sc.nextLong();
        System.out.println("EducatinRate: ");
        EducatinRate=Sc.next();
        System.out.println("Address: ");
        Address=Sc.next();
        User user=new User();
        user.setName(Name).setAddress(Address).setAge(Age).setPassword(Password).setUsername(Username).setEducatinRate(EducatinRate).setPhoneNumber(PhoneNumber);
        System.out.println("UserName: "+user.getUsername());
        System.out.println("Address: "+user.getAddress());
        System.out.println("Name: "+user.getName());
        System.out.println("Age: "+user.getAge());
        System.out.println("Password: "+user.getPassword());
        System.out.println("EducatinRate: "+user.getEducatinRate());
        System.out.println("PhoneNumber: "+user.getPhoneNumber());


    }


}
