public class SleepTime implements Criteria
{
   private int sleepTime;
   
   public SleepTime(int sleepTime)
   {
      this.sleepTime = sleepTime;
   }
   
   public boolean equals(Object s)
   {
      return s instanceof SleepTime && ((SleepTime)s).sleepTime == this.sleepTime ? true : false;
   }
   
   public int getValue()
   {
      return sleepTime;
   }
}
