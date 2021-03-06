/* Person Object */

import java.io.*;
import java.util.*;

/**
 * A person, his contact info, and a list of both his personal evaluation of Criteria and
 * expected values from his potential roommate.
 * Note: This implementation does not require a person to fill out all Criteria. Matching pairs
 * will be judged on what two potential roommates have both filled out.
 */
public class Person 
{
   // [INSTANCE VARIABLES]
   private String first;
   private String last;
   private String email;
   private ArrayList<Criterion> criteria;
   
   // [CONSTRUCTORS]
   public Person() 
   {
      criteria = new ArrayList<Criterion>();
   }
   
   public Person(String first, String last, String email, 
    ArrayList<Criterion> crit)
   {
      this.first = first;
      this.last = last;
      this.email = email;
      this.criteria = crit;
   }
   
   // [METHODS]
   // 'Get' Methods
   public String getFirstName() { return this.first; }
   public String getLastName() { return this.last; }
   public String getEmail() { return this.email; }
   public String getFullName() { return first + " " + last; }
   public ArrayList<Criterion> getCriteria() { return this.criteria; }
   public Criterion getCriterionAt(int index) {
      return criteria.get(index);
   }
   
   // 'Set' Methods
   public void setFirstName(String fn) { this.first = fn; }
   public void setLastName(String ln) { this.last = ln; }
   public void setEmail(String e) { this.email = e; }
   
   // Checks if a criteria exists in the Personal list of Criteria
   // public boolean existsInPersonal(Criterion crit)
   // {
   //    for (Criteria c : this.personal)
   //    {
   //       if (c.getName().equalsIgnoreCase(crit.getName()))
   //       {
   //          return true;
   //       }
   //    }   
   //    return false;
   // }
   
   // Checks if a criteria exists in the Expected list of Criteria
   // public boolean existsInExpected(Criteria crit)
   // {
   //    for (Criteria c : this.expected)
   //    {
   //       if (c.getName().equalsIgnoreCase(crit.getName()))
   //       {
   //          return true;
   //       }
   //    }
   //    return false;
   // }
}










/*
public class Person
{
   /* [INSTANCE VARIABLES] * /
   private Gender gender;
   private Major major;
   private Religion religion;
   private Substances substances;
   private Noise noise;
   private Cleanliness cleanliness;
   private Organizations organizations;
   private SleepTime sleepTime;
   private String first;
   private String last;
   private String email;

   /* [CONSTRUCTOR(s)] * /
   public Person(String first, String last, String email, String gender, 
    String major, String religion, boolean substances, int noise, 
    int cleanliness, List<String> organizations, int sleepTime)
   {
      this.first = first;
      this.last = last;
      this.email = email;
      this.gender = new Gender(gender);
      this.major = new Major(major);
      this.religion = new Religion(religion);
      this.substances = new Substances(substances);
      this.noise = new Noise(noise);
      this.cleanliness = new Cleanliness(cleanliness);
      this.organizations = new Organizations(organizations);
      this.sleepTime = new SleepTime(sleepTime);
   }

   /* [METHODS] * /
   
   // Returns true/false if the person being compared is equal to this person
   // -- Overrides 'equals' for Person class
   public boolean equals(Person p)
   {
      if (this.gender.equals(p.gender) &&
          this.major.equals(p.major) &&
          this.religion.equals(p.religion) &&
          this.substances.equals(p.substances) &&
          this.noise.equals(p.noise) &&
          this.cleanliness.equals(p.cleanliness) &&
          this.organizations.equals(p.organizations) &&
          this.sleepTime.equals(p.sleepTime))
      {
         return true;
      }
      else
         return false;
          
   }

   // All 'Get' Methods - returns value of each criterion, NOT the criterion object instance
   public Gender getGender() { return gender; }
   public Major getMajor() { return major; }
   public Religion getReligion() { return religion; }
   public Substances getSubstances() { return substances; }
   public Noise getNoise() { return noise; }
   public Cleanliness getCleanliness() { return cleanliness; }
   public Organizations getOrganizations() { return organizations; }
   public SleepTime getSleepTime() { return sleepTime; }
   public String getFullName() { return first + " " + last; }
   public String getEmail() { return email; }
}
*/
