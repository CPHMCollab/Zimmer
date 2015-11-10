/**
 * Matcher.java is the main class for the roommate matching app and contains the
 * algorithm and test driver.
 */

import java.io.*;
import java.util.*;
import com.google.gson.*;

public class Matcher {
   public static void main(String[] args) throws IOException {
      Gson gson = new Gson();
      ArrayList<Person> people = new ArrayList<Person>();
      BufferedReader fileListBR = 
       new BufferedReader(new FileReader("FileList.txt")); 
      String line;
      BufferedReader JsonBR;
      ParsedData pd;
      TreeNode root = new TreeNode(null, null, -1, 0, null);
      TreeNode goal;

      while ((line = fileListBR.readLine()) != null) {
         JsonBR = new BufferedReader(new FileReader(line));
         pd = gson.fromJson(JsonBR, ParsedData.class);
         people.add(pd.createPerson());
      }

      goal = buildTree(root, people);
      
      System.out.println("Roommate pairs:");
      printBacktrace(goal);
      System.out.println("Sum of all match scores: " + goal.getSum());
   }

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
            System.out.println(n.getSum());
            return n;
         }
      }
      return goal;
   }

   public static void printBacktrace(TreeNode goal) {
      TreeNode n = goal;

      while (n.hasParent()) {
         n = n.getParent();
      }
   }

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
