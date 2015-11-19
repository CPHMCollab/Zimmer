public class SleepTime implements Criteria
{
   private int sleepTime;
   
   public SleepTime(int sleepTime)
   {
      this.sleepTime = sleepTime;
   }
   
   public boolean equals(Object s)
   {
      if (s instanceof SleepTime)
      {
         int high, low;
         SleepTime other = (SleepTime)s;
         if (other.sleepTime == 23)
            high = 0;
         else
            high = other.sleepTime + 1;
         if (other.sleepTime == 0)
            low = 23;
         else
            low = other.sleepTime - 1;
         return sleepTime <= high && sleepTime >= low ? true : false;
      }
      return false;
   }
   
   public int getValue()
   {
      return sleepTime;
   }
}
