package sample;

public abstract class EducationalInstitution {


    private String name=" ";
    protected int intermediateResult=0;

    public void EnrollLearner(SchoolChild schoolChild, School school){
        school. SchoolArrayList.add(schoolChild);
        schoolChild.setStatus("Школьник");
    }

    public void EnrollLearner(Student student,University university){
        university.UniversityArrayList.add(student);
        student.setStatus("Студент");
    }

    public void EnrollLearner(Kindergartener kindergartener, Kindergarten kindergarten){
        kindergarten.KindergartenerArrayList.add(kindergartener);
        kindergartener.setStatus("Детсадовец");
    }



    public void DeductLearner(SchoolChild schoolChild, School school){
        school.SchoolArrayList.remove(schoolChild);
        //schoolChild.setStatus("Абитуриент");
    }

    public void DeductLearner(Kindergartener kindergartener, Kindergarten kindergarten){
        kindergarten.KindergartenerArrayList.remove(kindergartener);
    }

    public void DeductLearner(Student student,University university){
        university.UniversityArrayList.remove(student);
    }

    public void rate(Student student) {
        student.setGrade(intermediateResult);
    }
    public void rate(SchoolChild schoolChild){schoolChild.setGrade(intermediateResult);}

    public void setIntermediateResult(int intermediateResult) {
        this.intermediateResult = intermediateResult;
    }


}
