public class Noise implements Criteria
{
   private int noise;

   public Noise(int noise)
   {
      this.noise = noise;
   }
   
   public boolean equals(Object n)
   {
      if (n instanceof Noise)
      {
         Noise other = (Noise)n;
         int high = other.noise + 2;
         int low = other.noise - 2;
         return noise <= high && noise >= low ? true : false; 
      }
      return false;
   }
   
   public int getValue()
   {
      return noise;
   }
}
