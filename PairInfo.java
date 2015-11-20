public class PairInfo implements Comparable<PairInfo>
{
   private Person person1;
   private Person person2;
   /** 
    * Score who's range is from 0 to 
    * SCALE * # roommates * 100 (to keep the weightpercentage from becoming a double)
    * I.e.  a criteria based on scale of 0-10 and 2 roommates has a max of 200 
    */
   private int matchScore;
   
   public PairInfo(Person p1, Person p2, int score)
   {
      person1 = p1;
      person2 = p2;
      matchScore = score;
   }
   
   /* Get methods */
   public Person getPerson1() { return person1; }
   public Person getPerson2() { return person2; }
   public int getMatchScore() { return matchScore; }
   
   // CompareTo
   public int compareTo(PairInfo pInfo)
   {
      return pInfo.getMatchScore() - this.matchScore;
   }
   
   // toString
   public String toString()
   {
      return person1.getFullName() + ", " + person2.getFullName() + ", " + this.matchScore;
   }
}
