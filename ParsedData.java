import java.util.*;

public class ParsedData {

   private String timestamp;
   private String firstname;
   private String lastname;
   private String email;
   private String gender;
   private String major;
   private String religion;
   private boolean substances;
   private int noise;
   private List<String> organizations;
   private int cleanliness;
   private int sleeptime;

   public Person createPerson() {
      return new Person(firstname, lastname, email, gender, major, religion,
       substances, noise, cleanliness, organizations, sleeptime);
   }
   
   @Override
   public String toString() {
      return "DataObject [fn=" + firstname + ", ln=" + lastname + ", email="
       + email + "]";
   }

}
