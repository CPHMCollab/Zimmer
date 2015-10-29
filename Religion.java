/**
 * Religion.java is used to hold the religious preference of a user. Initial
 * values only indicate RELIGIOUS or NONRELIGIOUS. Values to represent actual
 * Religions may be added in a later prototype
 */

public class Religion {
   private String value;

   public Religion(String s) {
      value = s;
   }

   public void setValue(String s) {
      value = s;
   }

   public String getValue() {
      return value;
   }

   @Override public boolean equals(Object o) {
      return o instanceof Religion && 
       ((Religion)o).getValue().equals(this.value);
   }
}
