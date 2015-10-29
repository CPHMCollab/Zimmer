public class Organizations
{
   private String organizations;
   
   public Organizations(String organizations)
   {
      this.organizations = organizations;
   }
   
   public boolean equals(Organizations o)
   {
      return o.organizations.equals(this.organizations);
   }
}