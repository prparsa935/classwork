import java.awt.*;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class Writetofile extends Thread {

    public void writetofile(String filepath,String text){
        try {
            FileWriter fileWriter=new FileWriter(filepath);
            fileWriter.write(text);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void run() {
        Readfromfile rf=new Readfromfile();
        writetofile("C:\\Users\\ASUS\\Desktop\\text7.txt",rf.getcontent());
    }
}
