import java.util.Arrays;
import java.util.Collections;

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
         int avgOrgs = (organizations.length() + orgs2.length()) / 2;
         
         // Count the number of matched organizations between both lists
         for (int i = 0; i < organizations.length(); i++)
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
         
      /*   
         if (organizations.length() == orgs2.length())
         {
            // Just for good measure in case they weren't sorted already (WHICH THEY SHOULD BE)
            Collections.sort(organizations);
            Collections.sort(orgs2);
            
            // Iterate through each of the strings and check for equality
            //  NOTE: both lists are equal length which is why this loop takes shortcuts
            for (int i = 0; i < organizations.length(); i++)
            {
               if (organizations.get(i).equals(orgs2.get(i)) == false)
               {
                  return false;
               }
            }
            
            return true;
         }
      }
      
      return false;
      
      //return o instanceof Organizations && ((Organizations)o).organizations.equals(this.organizations);
      */
   }
   
   public String getValue()
   {
      return organizations;
   }
}
