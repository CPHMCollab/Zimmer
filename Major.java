/*
 * Major.java class used to hold the values for the major of a user. Initial
 * values are each of the colleges at Cal Poly. Values to reflect actual majors
 * will be added in later prototypes.
 */

public class Major {
   private String value;

   public Major(String s) {
      value = s;
   }

   public void setValue(String s) {
      value = s;
   }

   public String getValue() {
      return value;
   }

   @Override public boolean equals(Object o) {
      return o instanceof Major && ((Major)o).getValue().equals(this.value);
   }
}
