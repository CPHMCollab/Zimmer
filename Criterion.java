/**
 * Abstract class for high-level developers to create criterion for 'roommate' ,
 * e.g. cleanliness, loudness, time spent outside.
 */
public class Criterion {
    /** Keyword explaining criterion. */
    private String name;
    /** Percentage a `Person` assigns Criterion, showing importance of criteria to subject. */
    private int percentageWeight;
    /** A person's self-evaluation of their criterion as a roommate. */
    private int score;
    /** A person's expectation for this criterion in a roommate */
    private int expected;
    
    public Criterion(String name, int weight, int score, int expected)
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
    public int getPercentageWeight() { return percentageWeight; }
    public void setPercentageWeight(int weight) { this.percentageWeight = weight; }
}
