package tamrin3;

public class CarFactory {
    public Car CarFactory(String Company){
        try {
            if(Company.equals("Bmw")){
                return new bmw();
            }
            else if(Company.equals("Benz")){
                return new Benz();
            }
            else{
                return null;
            }
        }catch (Exception e){
            System.out.println("something is wrong");
            return null;
        }


    }

}
