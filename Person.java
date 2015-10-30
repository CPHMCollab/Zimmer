/* Person Object */

import java.io.*;
import java.util.*;

public class Person
{
   /* [INSTANCE VARIABLES] */
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

   /* [CONSTRUCTOR(s)] */
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

   /* [METHODS] */
   
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
