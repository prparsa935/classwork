package tamrin1;

import java.util.HashMap;
import java.util.Map;

public class Student {
    int Student_Number,Student_A_S;
    String Student_Name;
    public Student(Map Mp){
        this.Student_A_S= (int) Mp.get("Student_A_S");
        this.Student_Name= (String) Mp.get("Student_Name");
        this.Student_Number= (int) Mp.get("Student_Number");
    }
    public void Show(){
        System.out.println("shomare daneshjoi: "+this.Student_Number);
        System.out.println("nam: "+this.Student_Name);
        System.out.println("moadel : "+this.Student_A_S);

    }
}
