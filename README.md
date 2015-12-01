#Project Zimmer

#####Contributors:
######Kevin Tsui
######Anusha Praturu
######Eva Chen
######Daniel Shu
######Kyle Cornelison



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

###ParsedData.java

###Person.java

###Criterion.java



