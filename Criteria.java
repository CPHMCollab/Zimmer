/**
 * Created by evachen on 10/27/15.
 */

/**
 * Abstract class for high-level developers to create criterias for 'roommate' ,
 * e.g. cleanliness, loudness, time spent outside.
 */
public Criteria {
    /** Keyword explaining criteria. */
    private String name;
    /** Percentage a `Person` assigns Criteria, showing importance of criteria to subject. */
    private double percentageWeight;
    /** A person's self-evaluation of their criteria as a roommate. */
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
