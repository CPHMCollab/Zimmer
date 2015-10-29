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
   private SleepTimes sleepTimes;

   /* [CONSTRUCTOR(s)] */
   public Person()
   {
      this.gender = new Gender();
      this.major = new Major();
      this.religion = new Religion();
      this.substances = new Substances();
      this.noise = new Noise();
      this.cleanliness = new Cleanliness();
      this.organizations = new Organizations();
      this.sleepTimes = new sleepTimes();
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
          this.sleepTimes.equals(p.sleepTimes))
      {
         return true;
      }
      else
         return false;
          
   }

   // All 'Get' Methods
   public Gender getGender() { return this.gender.getValue(); }
   public Major getMajor() { return this.major; }
   public Religion getReligion() { return this.religion; }
   public Substance getSubstances() { return this.substances; }
   public Noise getNoise() { return this.noise; }
   public Cleanliness getCleanliness() { return this.cleanliness; }
   public Organizations getOrganizations() { return this.organizations; }
   public SleepTimes getSleepTimes() { return this.sleepTimes; }

   // All 'Set' Methods
   public void setGender(Gender g) { this.gender.setValue(g); }
   public void setMajor(Major m) { this.major = m; }
   public void setReligion(Religion r) { this.religion = r; }
   public void setSubstances(Substances s) { this.substances = s; }
   public void setNoise(Noise n) { this.noise = n; }
   public void setCleanliness(Cleanliness c) { this.cleanliness = c; }
   public void setOrganizations(Organizations o) { this.organizations = o; }
   public void setSleepTimes(SleepTimes st) { this.sleepTimes = st; }
}
