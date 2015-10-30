import java.util.*;

public class ParsedData {

   private String FirstName;
   private String LastName;
   private String Email;
   private String Gender;
   private String Major;
   private String Religion;
   private boolean Substances;
   private int Noise;
   private List<String> Organizations;
   private int SleepTime;
   private int Cleanliness;

   public Person createPerson() {
      return new Person(FirstName, LastName, Email, Gender, Major, Religion,
       Substances, Noise, Cleanliness, Organizations, SleepTime);
   }

   @Override
   public String toString() {
      return "DataObject [fn=" + FirstName + ", ln=" + LastName + ", email="
       + Email + "]";
   }
}
