/**
 * Zimmer.java is the main class for the roommate matching app. It contains the 
 * driver function.
 */

import java.io.*;
import java.util.*;
import com.google.gson.*;
/**
 * Main class that the best set of pairs with the goal of least deviation 
 * between all pairs.
 */
public class Zimmer
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
      TreeNode goal;

      // Add all people (JSON files) as 'People' object
      while ((line = fileListBR.readLine()) != null) {
         JsonBR = new BufferedReader(new FileReader(line));
         pd = gson.fromJson(JsonBR, ParsedData.class);
         people.add(pd.createPerson());
      }
      // Insert people into the tree
      goal = Matcher.findMatchInGroup(people);
      
      System.out.println("Roommate pairs:");
      Matcher.printBacktrace(goal);
      System.out.println("Average match score: " 
       + (int)((double)goal.getSum() / ((double)people.size() / 2)));
   }
}
