package kareclasi;

public class calcPlus implements calculate {
    @Override
    public void calc(int FirstNum, int SecondNum) {
        try{
            System.out.println(FirstNum+SecondNum);

        }
        catch (Exception e){
            System.out.println("something is wrong");
        }

    }
}
