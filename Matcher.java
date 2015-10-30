/**
 * Matcher.java is the main class for the roommate matching app and contains the
 * algorithm and test driver.
 */

import java.io.*;
import com.google.gson.*;

public class Matcher {
   public static void main(String[] args) throws IOException {
      Gson gson = new Gson();
      BufferedReader br1 = new BufferedReader(new FileReader("ckmccann.json"));
      ParsedData data1 = gson.fromJson(br1, ParsedData.class);
      BufferedReader br2 = new BufferedReader(new FileReader("eschen.json"));
      ParsedData data2 = gson.fromJson(br2, ParsedData.class);

      Person p1 = data1.createPerson();
      Person p1 = data2.createPerson();
   }
}
