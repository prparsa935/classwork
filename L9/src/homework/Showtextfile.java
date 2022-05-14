import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Showtextfile implements Runnable{

    @Override
    public void run() {
            try {
                String filecontent ="";
                File file=new File("C:\\Users\\ASUS\\IdeaProjects\\session 10 HW1\\src\\sample.txt");

                Scanner scan = new Scanner(file);
                while (scan.hasNextLine()) {
                    filecontent=filecontent.concat(scan.nextLine() + "\n");
                }
                System.out.println(filecontent);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

        }
    }
