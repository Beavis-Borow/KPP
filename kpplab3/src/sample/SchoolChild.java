package sample;

public class SchoolChild extends Learner {

    public SchoolChild(Enrollee enrollee){
        this.name=enrollee.name;
        this.status="Школьник";
    }




    public void DropOutOfSchool(School school){
        school.DeductLearner(SchoolChild.this,school);
    }
}
