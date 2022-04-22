package tamrin2;

import TAMRIN1.model.service.UserServ;
import tamrin2.model.Entity.CarEn;
import tamrin2.model.service.CarSer;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner Sc=new Scanner(System.in);
        System.out.println("""
                which car?
                1-pride""");

        if(Sc.nextInt()==1){
            try {
                List<CarEn> list=CarSer.getInstance().report();
                for(CarEn carEn:list){
                    if(carEn.getName().equals("pride")){
                        carEn.setBought(true);
                        CarSer.getInstance().edit(carEn);
                        System.out.println("pride has been bought successfully");
                        System.exit(0);
                    }
                }
                System.out.println("no pride found");

            } catch (Exception e) {
                e.printStackTrace();
            }





//            CarSer.getInstance().edit();
        }


    }
}
