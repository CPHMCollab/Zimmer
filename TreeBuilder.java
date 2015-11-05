import java.util.*;

public class TreeBuilder {
   
   public static void main(String[] args) {
      System.out.println("hello is this the krusty krab");
      //TreeNode root = new TreeNode(null, null, -1, 0);
      //buildTree(root, people);
   }
   
   public static void buildTree(TreeNode parent, List<Person> current) {
      TreeNode n;
      Person p = current.get(0), cur;
      List<Person> newList;
      int score;

      for(int i = 1; i < current.size(); i++) {
         cur = current.get(i);
         score = findMatchFactor(p, cur);
         n = new TreeNode(p, cur, score, parent.getSum() + score, parent);
         parent.addChild(n);
         newList = new ArrayList<Person>(current);
         newList.remove(p);
         newList.remove(cur);
         if(!newList.isEmpty()) {
            buildTree(n, newList);
         }
      }
   }

   public static int findMatchFactor(Person p1, Person p2) { return 0; } /* replace with actual function */
}
