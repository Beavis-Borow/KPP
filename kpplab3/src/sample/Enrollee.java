package sample;

public class Enrollee extends Learner{
    public Enrollee(Kindergartener kindergartener)
    {
        this.name=kindergartener.name;
        this.level=1;
        this.status="Дошкольник";
    }

    public Enrollee(SchoolChild schoolChild){
        this.name=schoolChild.name;
        this.level=2;
        this.status="Абитуриент";
        this.examResult=schoolChild.examResult;
    }


    public void PassExam(University university){
        examResult=university.TakeAnExam();
    }

    public int getExamResult() {
        return examResult;
    }






}
