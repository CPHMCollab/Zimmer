/**
 * Matcher.java contains the two main components of the matching algorithm.
 * It findss the match score between two people and it find the overall best set
 * of roommates.
 */

import java.io.*;
import java.util.*;

public class Matcher
{
   // MAGIC NUMBERS
   /** The scale range used to calculate score */
   public static final int SCALE = 10;
   public static final int MULTIPLIER = 100;
   public static final int PERFECT_SCORE = SCALE * MULTIPLIER * 2;
   
   // *************************************************************************
   // ***** Methods relating to Calculating the match score of two people *****
   // *************************************************************************
   
   /**
    * Calculate the match score of both persons for the given criteria if both 
    * have the criterion. return 0 if either person A's expected score or person
    * B's own score is null
    */
   private static int calcScore(Criterion exp, Criterion own) {
      if (exp.getExpected() > 0 && own.getScore() > 0) {
         return ((SCALE - Math.abs(exp.getExpected() - own.getScore()))) 
          * exp.getPercentageWeight(); 
      }
      return 0;
   }
   
   /**
    * Calculates the compatibility score between the two people given
    * returns a percentage between 0-100 (e.g. 65.72% match score -> 65.72)
    */
   public static int findMatchScore(Person p1, Person p2)
   {
      int p1Score = 0;
      int p2Score = 0;
      int numCriteria = p1.getCriteria().size();
      
      // Loop through every criterion to calculate the match score between the 
      //  two people
      for (int i = 0; i < numCriteria; i++) {
         p1Score += calcScore(p1.getCriterionAt(i), p2.getCriterionAt(i));
         p2Score += calcScore(p2.getCriterionAt(i), p1.getCriterionAt(i));
      }
      
      // return the percent compatibility between the two people
      return (int)(((double)(p1Score + p2Score) / PERFECT_SCORE) * 100);
   }


   // *************************************************************
   // * Methods related to Tree building/finding optimal solution *
   // *************************************************************
   //
   
   public static TreeNode findMatchInGroup(List<Person> people) {
      return buildTree(new TreeNode(null, null, -1, 0, null), people);
   }
   
   /**
    * Recursively builds tree while tracking the best Person to pair for the 
    * subject Person's tree.
    */
   private static TreeNode buildTree(TreeNode parent, List<Person> current) {
      TreeNode n;
      Person p = current.get(0), cur;
      List<Person> newList;
      int score;
      TreeNode goal = null, temp;
      for (int i = 1; i < current.size(); i++) {
         cur = current.get(i);
         score = findMatchScore(p, cur);
         n = new TreeNode(p, cur, score, parent.getSum() + score, parent);
         parent.addChild(n);
         newList = new ArrayList<Person>(current);
         newList.remove(p);
         newList.remove(cur);
         if (!newList.isEmpty()) {
            temp = buildTree(n, newList);
            if (goal == null || temp.getSum() > goal.getSum()) {
               goal = temp;
            }
         }
         else {
            return n;
         }
      }
      return goal;
   }
   
   /**
    * Given a terminal/leaf node, this method will trace back to the root
    * and print out every pair and its score along the way.
    */
   public static void printBacktrace(TreeNode goal) {
      TreeNode n = goal;

      while (n.hasParent()) {
         System.out.println(n);
         n = n.getParent();
      }
   }
}
