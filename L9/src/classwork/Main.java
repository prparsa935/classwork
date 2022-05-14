import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main  {
    public static void main(String[] args) {
        Writetofile writetofile=new Writetofile();
        Readfromfile readfromfile=new Readfromfile();
        readfromfile.start();
        writetofile.start();


    }
}
