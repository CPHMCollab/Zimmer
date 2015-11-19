public class Cleanliness implements Criteria
{
   private int cleanliness;

   public Cleanliness(int cleanliness)
   {
      this.cleanliness = cleanliness;
   }
   
   public boolean equals(Object c)
   {
      if (c instanceof Cleanliness)
      {
         Cleanliness other = (Cleanliness)c;
         int high = other.cleanliness + 2;
         int low = other.cleanliness - 2;
         return cleanliness <= high && cleanliness >= low ? true : false; 
      }
      return false;
   }
   
   public int getValue()
   {
      return cleanliness;
   }
}
