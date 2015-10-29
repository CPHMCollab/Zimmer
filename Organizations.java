public class Organizations implements Criteria
{
   private String organizations;
   
   public Organizations(String organizations)
   {
      this.organizations = organizations;
   }
   
   public boolean equals(Object o)
   {
      return o instanceof Organizations && o.organizations.equals(this.organizations);
   }
   
   public String getValue()
   {
      return organizations;
   }
}
