public class Noise implements Criteria
{
   private int noise;

   public Noise(int noise)
   {
      this.noise = noise;
   }
   
   public boolean equals(Object n)
   {
      return n instanceof Noise && ((Noise)n).noise == this.noise ? true : false;
   }
   
   public int getValue()
   {
      return noise;
   }
}
