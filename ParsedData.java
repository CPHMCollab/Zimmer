import java.util.*;

public class ParsedData {

   private String timestamp;
   private String firstname;
   private String lastname;
   private String email;
   private ArrayList<Criterion> criteria;
   // private String gender;
   // private String major;
   // private String religion;
   // private boolean substances;
   // private int noise;
   // private List<String> organizations;
   // private int cleanliness;
   // private int sleeptime;

   public Person createPerson() {
      return new Person(firstname, lastname, email, criteria);
   }
   
   @Override
   public String toString() {
      String str = "fn=" + firstname + "\nln=" + lastname + "\nemail=" + email;
      for (Criterion c : criteria) {
         str += "\n   criterion [" + c.getName() + "]\n      score: " 
          + c.getScore() + "\n      expected: " + c.getExpected() 
          + "\n      percentageWeight: " + c.getPercentageWeight();
      }
      return str;
   }

}
