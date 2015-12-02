#Project Zimmer

######Contributors:
* Kevin Tsui
* Anusha Praturu
* Eva Chen
* Daniel Shu
* Kyle Cornelison

##How to Run Zimmer (test driver)

1. Make sure that `gson-2.4.jar` is in the directory in which you intend to
   run the driver as well as all `.java` files in this repository.
2. Also ensure that your directory contains a folder labeled `json` and that
   all user `.json` files are contained within this folder.
3. Make sure that there is a file called `FileList.txt` in your directory
   that contains all the file names that are contained in the `json` folder.
4. Set the `$CLASSPATH` variable by running the following command:
  > `export CLASSPATH=gson-2.4.jar`
5. Compile the `.java` files:
  > `javac *.java`
6. Run the program with the following command:
  > `java -cp gson-2.4.jar:./ Zimmer`

##Creating your own driver that uses this Matching library
If you create your own program that utilizes this Matching library, there are a
few things to keep in mind, most of which are outlined in the class descriptions
below.
However you decide to gather user data, it is important that the data structures
fed into the Matcher methods follow the conventions below. We found that JSON
parsing worked for us, so we used it in our Zimmer program, but it is by no
means the only way of creating a list of Person objects to use.
Take note of the conventions listed in the **bulleted lists** below (under the
Person.java and Criterion.java subheaders). These conventions are essential to
the Matching library functioning properly.

##Class Descriptions

###Matcher.java
The matcher class contains the bulk of the Matching algorithm, which consists
of two main functions that are described below.
#####findMatchScore(Person p1, Person p2) [returns int]
This function will take two Person objects and return an integer "match score"
between them. The score will be most accurate when both Person objects have
all Criteria filled out for themselves and their expected match.
#####findMatchInGroup(List<Person> people) [returns TreeNode]
This function will take a list of people, and call a recursive tree-building
function to find the optimal solution. The "optimal solution" refers to the set
of pairs for which the average match score is the highest possible value. The
return value is the TreeNode that represents the end of the optimal path. This
node only contains one pair, but it contains a reference to its parent node, 
which respectively has a link to its own parent node, and so on and so forth
until the root of the tree. Each node along this path represents a pair that is
part of the optimal solution.
#####printBacktrace(TreeNode goal)
While this method can technically take any node and print its "ancestry" until
the root of the tree, its purpose is to take the goal node (found with the
findMatchInGroup method) and print each node along the path that leads to it,
thus printing the optimal solution to the problem. For each node along the
path, the method will print the names of the two people in the pair, as well
as their match score. This can be easily modified to print more or less
information as needed. Additionally, this method prints the output to stdout,
but can esily be redirected to a file if necessary.

###Zimmer.java
Zimmer.java is a driver that we created that uses our matching library to find
an optimal set of roommates among a list of made-up people. It provides an 
example of how our matching library can be used.
In our example, we represented people as JSON files, and listed them in a File
called FileList.txt. We go through this list of people represented as JSON
files, and we convert them into a list of Person objects, which is used in our
library. To parse the JSON files, we use Google's JSON parsing library, called
Gson. We also utilize a class called ParsedData in order to assist in converting
the JSON into Java Objects.

###ParsedData.java
ParsedData is used by the Gson JSON parser, and it allows the parser to convert
a JSON object into a Java object. We have included a function called 
createPerson that will allow us to convert a ParsedData Object into a Person 
object, which is our goal, since Person objects are what is used by the Matching
library. It also contains a toString method that was used for testing purposes,
to ensure that the JSON parsing was working correctly.

###Person.java
Person is the class we use to represent an individual that needs to be matched 
using our algorithm. A Person object is relatively simple; it contains a 
first name, last name, email, and a list of Criteria objects. This list is the
most important part because it is used in calculating a match score between this
Person and another Person. The details of the Criterion object are below, but
there are a few important aspects of the list of Criteria that must be followed
in order for the Matching algorithm to function properly.
   - However many criteria are represented in your application/front-end, that
     must be the length of the list of criteria for each Person object. For 
     example, if the app allows the user to input information for 6 Criteria, 
     each Person must have a list of Criteria of exactly length 6. Even if the
     a specific user does not fill in any information besides their name and
     email, the list must still have 6 Criterion objects and their information
     will be empty (described below). In our Zimmer example, we have 3 Criteria
     (noise, cleanliness, and sleepTime). Therefore, every single Person object
     and every single JSON file has exactly 3 Criteria, even if they left some
     fields blank.
   - While the order of the Criteria does not matter for the *overall* library,
     it is important that for each Person, the order is the **same**. For 
     example, in our Zimmer app, we decided, arbitrarily, that the order of the
     Criterion objects in the list would be noise, then cleanliness, then 
     sleepTime. Therefore, every single Person object has their list of Criteria
     in that exact order. The app still would have worked just fine if the 
     order had been cleanliness, then noise, then sleepTime, as long as every
     single Person object followed that same convention.
     
###Criterion.java
A Criterion object holds all the information for one Criterion for a Person.
Specifically, it hold the name of the Criterion, the percentageWeight that the
user assigns to it (i.e. how important this Criterion is to the user), the
user's self-evaluation for their score on this particular Criterion, and the
user's desired score in a partner. There are a few important notes about these
fields that are worth noting:
   - None of the fields are strictly required, except the name of the Criterion
     which should be semi-automatically generated in the front-end. However,
     percentageWeight is tied to the expected field. This means that if the user
     enters a score in the expected field, they are required to also enter a
     percentageWeight for that score. They *cannot* enter a percentageWeight
     if they do not enter an expected score.
   - If a user does not enter a value for one of the fields, -1 value should be
     used, rather than a positive value.
   - All values are numerical and on a scale of 1-10. Unfortunately, string,
     boolean, and other values are not yet supported. If you want to represent
     Gender, for example, you will have to hard-code Male=1 and Female=10 on
     the front-end. As stated previously, -1 is to be used for non-values 
     (values that the user did not enter).
   - The percentageWeights of all the Criterion in a list of Criteria in a 
     Person **must** add up to 100. This is not enforced in the library, but
     it is essential in order for the library to work properly. This will, 
     unfortunately, have to be enforced in the front-end for now, until we can
     support in the back-end.



