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
      BufferedReader br1 = new BufferedReader(new FileReader("ckmccann.json"));
      ParsedData data1 = gson.fromJson(br1, ParsedData.class);
      BufferedReader br2 = new BufferedReader(new FileReader("eschen.json"));
      ParsedData data2 = gson.fromJson(br2, ParsedData.class);

      Person p1 = data1.createPerson();
      Person p2 = data2.createPerson();
      
      System.out.println(p1.getFullName() + " and " + p2.getFullName() + 
       " have a match factor of " + findMatchFactor(p1, p2));
   }

   public static int findMatchFactor(Person p1, Person p2) {
      int score = 1;
      if(!p1.getGender().equals(p2.getGender())) {
         return score;
      }
      score++;
      if(!p1.getMajor().equals(p2.getMajor())) {
         return score;
      }
      score += 2;
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

   public static List<PairInfo> generatePairs(List<Person> people) {
      List<PairInfo> pairs = new ArrayList<PairInfo>();
      Person p1, p2;

      for(int i = 0; i < people.size(); i++) {
         for(int j = i + 1; j < people.size(); i++) {
            p1 = people.get(i);
            p2 = people.get(j);
            pairs.add(new PairInfo(p1, p2, findMatchFactor(p1, p2)));
         }
      }
      //TODO sort   
      return pairs;
   }

   public static List<PairInfo> getBestPairSet(List<Person> people) {
      List<Person> needPairs = new ArrayList<Person>();
      List<PairInfo> finalPairs = new ArrayList<PairInfo>();
      int index = 0;
      PairInfo cur;
      List<PairInfo> allPairs = generatePairs(people);

      needPairs.addAll(people);
      while(!needPairs.isEmpty()) {
         cur = allPairs.get(index);
         if(needPairs.indexOf(cur.getPerson1()) > -1 
          && needPairs.indexOf(cur.getPerson2()) > -1) {
            finalPairs.add(cur);
            needPairs.remove(cur.getPerson1());
            needPairs.remove(cur.getPerson2());
         }
         index++;
      }

      return finalPairs;
   }
}
