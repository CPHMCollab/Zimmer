public class Noise
{
   private int noise;

   public Noise(int noise)
   {
      this.noise = noise;
   }
   
   public boolean equals(Noise n)
   {
      return n.noise == this.noise ? true : false;
   }
}