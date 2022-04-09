package kareclasi;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner Sc=new Scanner(System.in);
        String Sign;
        int FirstNum,SecondNum;
        try {
            System.out.println("enter FirstNum: ");
            FirstNum=Sc.nextInt();
            System.out.println("enter SecondNum: ");
            SecondNum=Sc.nextInt();
            System.out.println("enter sign: ");
            Sign=Sc.next();
            calculate calcFactory=new calcFactory().calculateFactory(Sign);
            calcFactory.calc(FirstNum,SecondNum);

        }
        catch (Exception e){
            System.out.println("something is wrong");
        }





//        calcFactory.calculateFactory(alamat);


//        calcFactory.calculateFactory();

    }
}
