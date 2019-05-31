package sample;

import java.util.ArrayList;

public class University extends EducationalInstitution {
    private int Result=0;

    public ArrayList<Student> UniversityArrayList = new ArrayList<Student>();


    public int TakeAnExam(){
        return Result=50;
    }

    public void HoldLecture(Student student){
        student.IncreaseKnowledge();
    }

    public void HoldSeminar(Student student){
        student.IncreaseKnowledge();
        //student.IncreaseGrade();
        intermediateResult++;
    }

    public void HoldLaboratoryWork(){
       // student.IncreaseGrade();
        intermediateResult++;
    }
}
