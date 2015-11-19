/**
 * Created by evachen on 10/27/15.
 */

public Criteria {
    private String name;
    private double percentageWeight; // weight percentage of the criterion (e.g. 0.65 = 65% weight)
    private int score;
    
    public Criteria(String name, int weight, int score)
    {
        this.name = name;
        this.weight = weight;
        this.score = score;
    }
    
    public String getName() { return this.name; }
    public void setName(String name) { this.name = name; }
    public int getScore() { return score; }
    public void setScore(int score) { this.score = score; }
    public double getPercentageWeight() { return percentageWeight; }
    public void setWeight(int weight) { this.weight = weight; }
}
