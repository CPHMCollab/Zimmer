public class SleepTime
{
   private int sleepTime;
   
   public SleepTime(int sleepTime)
   {
      this.sleepTime = sleepTime;
   }
   
   public boolean equals(SleepTime s)
   {
      return s.sleepTime == this.sleepTime ? true : false;
   }
}