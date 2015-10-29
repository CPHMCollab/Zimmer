public class Cleanliness implements Criteria
{
   private int cleanliness;

   public Cleanliness(int cleanliness)
   {
      this.cleanliness = cleanliness;
   }
   
   public boolean equals(Cleanliness c)
   {
      return c instanceof Cleanliness && (Cleanliness c).cleanliness == this.cleanliness ? true : false;
   }
   
   public int getValue()
   {
      return cleanliness;
   }
}
