package sample;

public abstract class Learner {
    private int ratings=0;

    protected String status="nikto";
    protected String name="Fedor";
    private int knowledge=0;
    private int grade=0;
    protected int level=0;
    protected int examResult=0;

    public String getName() {
        return name;
    }

    public int getRatings() {
        return ratings;
    }

    public int getLevel() {
        return level;
    }

    public int getGrade() {
        return grade;
    }

    public int getKnowledge() {
        return knowledge;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public void setKnowledge(int knowledge) {
        this.knowledge = knowledge;
    }

    public void IncreaseKnowledge(){
        knowledge++;
    }



    public void study(){
        ratings++;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
