/**
 * Matcher.java is the main class for the roommate matching app and contains the
 * algorithm and test driver.
 */

import java.io.*;
import java.util.*;
import com.google.gson.*;
/**
 * Main class that the best set of pairs with the goal of least deviation between all pairs.
 */
public class Matcher
{
   // MAGIC NUMBERS
   /** The scale range used to calculate score */
   public static final int SCALE = 10;
   public static final int MULTIPLIER = 100;
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
      System.out.println("Sum of all match scores: " + goal.getSum());
   }
   
   /**
    * Checks if criteria keyword 'name' exists in the list p
    * @return If criteria exists in list
    */
   public boolean existsInList(String name, List<Criteria> p)
   {
      for (Criteria c : p)
      {
         if (c.getName().equalsIgnoreCase(name))
         {
            return true;
         }
      }
      return false;
   }
   
   /**
    * Gets the criteria keyword 'name' if it exists in the list p
    * @return criteria or null
    */
   public Criteria getInList(String name, List<Criteria> p)
   {
      for (Criteria c : p)
      {
         if (c.getName().equalsIgnoreCase(name))
         {
            return c;
         }
      }
      return null;
   }
   
   /** Returns list of Criteria that can be evaluated (does p1 and p2 have same criteria) */
   public ArrayList<String> getCommonCriteria(List<Criteria> p1, List<Criteria> p2) {   
      ArrayList<String> commons = new ArrayList<String>();
      for (Criteria c : p1) {
         if (existsInList(c.getName(), p2)) {
            commons.add(c.getName());
         }
      }
      return commons;
   }

   /**Given 2 'Person', find the sum score of both people, where each person's score is
    * calculated by Person1's personal evaluation to Person2's expected critera. */
   // We are currently returning the percentage of compatibility between the two people. We COULD just return the totalScore which would be a bigger number, then we would have to calculate the percentage of compatibility later which is wouldn't be a problem.
   public static int findMatchFactor(Person p1, Person p2) {
      // Given: P1, P2
      //
      // Math.abs: absolute value
      // 
      // P1CriteriaScoreN = ((SCALE - Math.abs(P1.Expected - P2.Personal)) * MULTIPLIER) * P1.CriteriaNPercentage)
      // P1Score = P1CriteriaScore1 + P1CriteriaScore2 + ... + P1CriteriaScoreN
      //      
      // P2CriteriaScoreN = ((SCALE - Math.abs(P2.Expected - P1.Personal)) * MULTIPLIER) * P2.CriteriaNPercentage)
      // P2Score = P2CriteriaScore1 + P2CriteriaScore2 + ... + P2CriteriaScoreN
      //
      // totalScore = P1Score + P2Score
      //
      // return totalScore / PERFECT_SCORE --> percentage of compatibility
      
      ArrayList<String> commonCrit1 = getCommonCriteria(p1.getExpectedCriteria(), p2.getPersonalCriteria());
      ArrayList<String> commonCrit2 = getCommonCriteria(p1.getPersonalCriteria(), p2.getExpectedCriteria());
      int p1Score = 0;
      int p2Score = 0;
      int totalScore = 0;
      
      // Calculating score - P1's expected criteria with P2's personal criteria
      for (String crit : commonCrit1)
      {
         // criteria guaranteed not to be null because common attributes were found by getCommonCriteria()
         Criteria c1 = getInList(crit, p1.getExpectedCriteria);
         Criteria c2 = getInList(crit, p2.getPersonalCriteria);
         
         p1Score += ((SCALE - Math.abs(c1.getScore() - c2.getScore())) * MULTIPLIER) * c1.getPercentageWeight();
      }
      
      // Calculating score - P2's expected criteria with P1's personal criteria
      for (String crit : commonCrit2)
      {
         // criteria guaranteed not to be null because common attributes were found by getCommonCriteria()
         Criteria c1 = getInList(crit, p1.getPersonalCriteria);
         Criteria c2 = getInList(crit, p2.getExpectedCriteria);
         
         p2Score += ((SCALE - Math.abs(c1.getScore() - c2.getScore())) * MULTIPLIER) * c2.getPercentageWeight();
      }
      
      totalScore = p1Score + p2Score;
      
      // We are currently returning the percentage of compatibility between the two people
      return totalScore / PERFECT_SCORE;
   }


   // *************************************************************
   // ***** Methods relating to Tree building & our Algorithm *****
   // *************************************************************
   //
   /**
    * Recursively builds tree while tracking the best Person to pair for the subject Person's tree.
    */
   public static TreeNode buildTree(TreeNode parent, List<Person> current) {
      TreeNode n;
      Person p = current.get(0), cur;
      List<Person> newList;
      int score;
      TreeNode goal = null, temp;
      for (int i = 1; i < current.size(); i++) {
         cur = current.get(i);
         score = findMatchFactor(p, cur);
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
   face
   
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
