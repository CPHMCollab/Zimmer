public class Cleanliness
{
   private int cleanliness;

   public Cleanliness(int cleanliness)
   {
      this.cleanliness = cleanliness;
   }
   
   public boolean equals(Cleanliness c)
   {
      return c.cleanliness == this.cleanliness ? true : false;
   }
   
}