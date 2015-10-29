/**
 * Substances.java class used to hold the values for the substance usage
 * tendencies of a user. Initial values are USER and NONUSER. More specific 
 * values may be added in later prototypes.
 */

public class Substances {
   private String value;

   public Substances(String s) {
      value = s;
   }

   public void setValue(String s) {
      value = s;
   }

   public String getValue() {
      return value;
   }

   @Override public boolean equals(Object o) {
      return o instanceof Substances && 
       ((Substances)o).getValue().equals(this.value);
   }
}
