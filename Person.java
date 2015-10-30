/* Person Object */

import java.io.*;

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
   public Person(String first, String last, String email, String gender, String major, String religion, 
    boolean substances, int noise, int cleanliness, String organizations, 
    int sleepTime)
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
   public String getGender() { return this.gender.getValue(); }
   public String getMajor() { return this.major.getValue(); }
   public String getReligion() { return this.religion.getValue(); }
   public boolean getSubstances() { return this.substances.getValue(); }
   public int getNoise() { return this.noise.getValue(); }
   public int getCleanliness() { return this.cleanliness.getValue(); }
   public String getOrganizations() { return this.organizations.getValue(); }
   public int getSleepTime() { return this.sleepTime.getValue(); }
   public String getFirst() { return first; }
   public String getLast() { return last; }
   public String getEmail() { return email; }
}
