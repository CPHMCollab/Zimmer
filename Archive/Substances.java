/**
 * Substances.java class used to hold the values for the substance usage
 * tendencies of a user. Values are true and false for user and nonuser,
 * repectively.
 */

public class Substances implements Criteria {
   private boolean value;

   public Substances(boolean s) {
      value = s;
   }

   public boolean getValue() {
      return value;
   }

   @Override public boolean equals(Object o) {
      return o instanceof Substances && 
       ((Substances)o).getValue() == this.value;
   }
}
