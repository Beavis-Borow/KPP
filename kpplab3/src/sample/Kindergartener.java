package sample;

public class Kindergartener extends Learner {
    private int growth=0;
    public void eat(){
        growth++;
    }

    public int getGrowth() {
        return growth;
    }
}
