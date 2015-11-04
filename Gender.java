/**
 * Gender.java class used to hold the values for the gender of a user. Initial
 * values are MALE and FEMALE. More values may be added in later prototypes.
 */

public class Gender implements Criteria {
   private String value;

   public Gender(String s) {
      value = s;
   }

   public String getValue() {
      return value;
   }

   @Override public boolean equals(Object o) {
      return o instanceof Gender && ((Gender)o).value.equals(this.value);
   }
}
