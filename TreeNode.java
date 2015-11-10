import java.util.*;

public class TreeNode {
   private Person p1;
   private Person p2;
   private int score;
   private int sum;
   private TreeNode parent;
   ArrayList<TreeNode> children;

   public TreeNode(Person person1, Person person2, int mf, int curSum, 
    TreeNode parentNode) {
      p1 = person1;
      p2 = person2;
      score = mf;
      sum = curSum;
      parent = parentNode;
      children = new ArrayList<TreeNode>();
   }

   public void addChild(TreeNode n) {
      children.add(n);
   }

   public int getMatchScore() { return score; }

   public int getSum() { return sum; }

   public Person getP1() { return p1; }

   public Person getP2() { return p2; }

   public TreeNode getParent() { return parent; }

   public boolean hasParent() { return parent == null ? false : true; }

   @Override public String toString() {
      return p1.getFullName() + ", " + p2.getFullName() + ", " + score;
   }
}
