package tamrin3;

import java.util.ArrayList;
import java.util.List;

public class Student<Name,StudentNum,FatherName> {
    private Name Name;
    private StudentNum StudentNum;
    private FatherName FatherName;
    private List Grades=new ArrayList<>();

    public Name getName() {
        return Name;
    }

    public void setName(Name name) {
        Name = name;
    }

    public StudentNum getStudentNum() {
        return StudentNum;
    }

    public void setStudentNum(StudentNum studentNum) {
        StudentNum = studentNum;
    }

    public FatherName getFatherName() {
        return FatherName;
    }

    public void setFatherName(FatherName fatherName) {
        FatherName = fatherName;
    }

    public List getGrades() {
        return Grades;
    }

    public void setGrades(List grades) {
        Grades = grades;
    }
    public void ShowGrades(){
        for(int i=0;i<Grades.size();i++){
            System.out.println((i+1)+": "+Grades.get(i));
        }
    }

    Student(){


    }


}
