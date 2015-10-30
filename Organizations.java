import java.util.Arrays;
import java.util.*;

public class Organizations implements Criteria
{
   public static final double MATCH_PERCENTAGE = 0.5;
   private List<String> organizations;
   
   public Organizations(List<String> organizations)
   {
      this.organizations = organizations;
   }
   
   public boolean equals(Object o)
   {
      if (o instanceof Organizations)
      {
         List<String> orgs2 = ((Organizations)o).organizations;
         int matchedOrgs = 0;
         int avgOrgs = (organizations.size() + orgs2.size()) / 2;
         
         // Count the number of matched organizations between both lists
         for (int i = 0; i < organizations.size(); i++)
         {
            if (orgs2.contains(organizations.get(i)))
            {
               matchedOrgs++;
            }
         }
         
         // Check if the number of matched organizations reaches the threshold of what is a "match"
         if ((double)matchedOrgs / avgOrgs > MATCH_PERCENTAGE)
         {
            return true;
         }
         return false;
      }
      return false;         
   }
   
   public List<String> getValue()
   {
      return organizations;
   }
}
