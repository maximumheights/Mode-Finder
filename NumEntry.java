//Max Hite
/*On my honor as a student I have not given nor recieved any unauthorized assitance on this assignment*/

public class NumEntry
{

   private int value;
   private int frequency;
  
   public NumEntry(int v)
   {
      value = v;
      frequency = 1;
   }
   public void recordCopy()
   {
      frequency += 1;
   }
   
   public int getValue()
   {
      return value;
   }
   
   public int getFrequency()
   {
      return frequency;
   }
   
   public String toString()
   {
      return "{Value: " + value + ", Freq: " + frequency +"}";
   }
   
  
}
