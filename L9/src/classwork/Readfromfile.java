import java.io.*;
import java.util.Scanner;

public class Readfromfile extends Thread{
    public void run() {
        readfile("C:\\Users\\ASUS\\Desktop\\text1.txt");
    }
    String filecontent ="";
    public String readfile(String filepath){
            try {
                File file=new File(filepath);
                Scanner scan = new Scanner(file);
                while (scan.hasNextLine()) {
                    filecontent=filecontent.concat(scan.nextLine() + "\n");
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
return filecontent;
}
   public String getcontent(){
  String copy= readfile("C:\\Users\\ASUS\\Desktop\\text1.txt");
  return copy;

}
}
