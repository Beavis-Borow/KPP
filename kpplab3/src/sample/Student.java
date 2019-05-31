package sample;

public class Student extends Learner {

    public Student(Enrollee enrollee){
        this.name=enrollee.name;
        this.status="Студент";
    }



}
