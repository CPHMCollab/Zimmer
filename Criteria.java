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
    /** A person's expectation for this criteria in a roommate */
    private int expected;
    
    public Criteria(String name, double weight, int score, int expected)
    {
        this.name = name;
        this.percentageWeight = weight;
        this.score = score;
        this.expected = expected;
    }
    
    public String getName() { return this.name; }
    public void setName(String name) { this.name = name; }
    public int getScore() { return score; }
    public void setScore(int score) { this.score = score; }
    public int getExpected() { return expected; }
    public void setExpected(int expected) { this.expected = expected; }
    public double getPercentageWeight() { return percentageWeight; }
    public void setPercentageWeight(double weight) { this.percentageWeight = weight; }
}
