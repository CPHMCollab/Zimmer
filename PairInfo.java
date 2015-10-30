public class PairInfo implements Comparable<PairInfo>
{
   private Person person1;
   private Person person2;
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
      return this.matchScore - pInfo.getMatchScore();
   }
}
