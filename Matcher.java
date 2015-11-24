/**
 * Matcher.java is the main class for the roommate matching app and contains the
 * algorithm and test driver.
 */

import java.io.*;
import java.util.*;
import com.google.gson.*;
/**
 * Main class that the best set of pairs with the goal of least deviation 
 * between all pairs.
 */
public class Matcher
{
   // MAGIC NUMBERS
   /** The scale range used to calculate score */
   public static final int SCALE = 10;
   public static final int MULTIPLIER = 100;
   public static final int PERFECT_SCORE = SCALE * MULTIPLIER * 2;
   /**
    * Creates a tree with empty root node, 
    */
   public static void main(String[] args) throws IOException {
      Gson gson = new Gson();
      ArrayList<Person> people = new ArrayList<Person>();
      BufferedReader fileListBR = 
       new BufferedReader(new FileReader("FileList.txt")); 
      String line;
      BufferedReader JsonBR;
      ParsedData pd;
      
      // Initiate empty root node for tree
      TreeNode root = new TreeNode(null, null, -1, 0, null);
      TreeNode goal;
      // Add all people (JSON files) as 'People' object
      while ((line = fileListBR.readLine()) != null) {
         JsonBR = new BufferedReader(new FileReader(line));
         pd = gson.fromJson(JsonBR, ParsedData.class);
         people.add(pd.createPerson());
      }
      // Insert people into the tree
      goal = buildTree(root, people);
      
      System.out.println("Roommate pairs:");
      printBacktrace(goal);
      System.out.println("Average match score: " 
       + (int)((double)goal.getSum() / ((double)people.size() / 2)));
   }
   
   // *************************************************************************
   // ***** Methods relating to Calculating the match score of two people *****
   // *************************************************************************
   
   // [HELPER]
   // Calculate the match score of both persons for the given criteria if both 
   // have the criterion return 0 if either person A's expected score or person 
   // B's own score is null
   public static int calcScore(Criterion exp, Criterion own) {
      if (exp.getExpected() > 0 && own.getScore() > 0) {
         return ((SCALE - Math.abs(exp.getExpected() - own.getScore()))) 
          * exp.getPercentageWeight(); 
      }
      return 0;
   }
   
   // Calculates the compatibility score between the two people given
   // returns a percentage between 0-100 (e.g. 65.72% match score -> 65.72)
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
   // ***** Methods relating to Tree building & our Algorithm *****
   // *************************************************************
   //
   /**
    * Recursively builds tree while tracking the best Person to pair for the 
    * subject Person's tree.
    */
   public static TreeNode buildTree(TreeNode parent, List<Person> current) {
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
   
   public static void printBacktrace(TreeNode goal) {
      TreeNode n = goal;

      while (n.hasParent()) {
         System.out.println(n);
         n = n.getParent();
      }
   }
   
/*
 ********************** PROTOTYPE 2 *************************
 
   public static int findMatchFactor(Person p1, Person p2) {
      int score = 1;
      if(!p1.getGender().equals(p2.getGender())) {
         return score;
      }
      score ++;
      if(!p1.getMajor().equals(p2.getMajor())) {
         score += 2;
      }
      if(p1.getReligion().equals(p2.getReligion())) {
         score++;
      }
      if(p1.getSubstances().equals(p2.getSubstances())) {
         score++;
      }
      if(p1.getNoise().equals(p2.getNoise())) {
         score++;
      }
      if(p1.getCleanliness().equals(p2.getCleanliness())) {
         score++;
      }
      if(p1.getOrganizations().equals(p2.getOrganizations())) {
         score++;
      }
      if(p1.getSleepTime().equals(p2.getSleepTime())) {
         score++;
      }

      return score;
   }
 */

/*
 ********************** PROTOTYPE 1 *************************

   public static List<PairInfo> generatePairs(List<Person> people) {
      List<PairInfo> pairs = new ArrayList<PairInfo>();
      Person p1, p2;

      for(int i = 0; i < people.size(); i++) {
         for(int j = i + 1; j < people.size(); j++) {
            p1 = people.get(i);
            p2 = people.get(j);
            pairs.add(new PairInfo(p1, p2, findMatchFactor(p1, p2)));
         }
      }
      Collections.sort(pairs);
      return pairs;
   }

   public static List<PairInfo> getBestPairSet(List<Person> people) {
      List<Person> needPairs = new ArrayList<Person>();
      List<PairInfo> finalPairs = new ArrayList<PairInfo>();
      int index = 0;
      PairInfo cur;
      List<PairInfo> allPairs = generatePairs(people);

      needPairs.addAll(people);
      while(needPairs.size() > 1) {
         cur = allPairs.get(index);
         if(needPairs.indexOf(cur.getPerson1()) > -1 
          && needPairs.indexOf(cur.getPerson2()) > -1) {
            finalPairs.add(cur);
            needPairs.remove(cur.getPerson1());
            needPairs.remove(cur.getPerson2());
         }
         index++;
      }
      if(!needPairs.isEmpty()) {
         System.out.println("There were an odd number of applicants. " + 
          "No roommate found for user " + needPairs.get(0).getFullName() + ".");
      }

      return finalPairs;
   }
   */
}
