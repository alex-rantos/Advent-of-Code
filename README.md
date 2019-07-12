# Advent of Code Puzzle Solutions in Java Language

### Year 2018

#### Day 1
###### Part 1 : Convert each line to a number and sum all of them.
###### Part 2 : Save input to a ArrayList and distinctly save the sum to another ArrayList. Traverse the first ArrayList in order to find a matching sum.

#### Day 2
###### Part 1 : For every char of the input calculate its occurrence. Check how many chars were found 2 and 3 times.
###### Part 2 : Save each line of the input to a ArrayList<String> and check in every addition all string to find the two strings which differ by one character.

#### Day 3
###### Make use of Patter & Matcher to read input. Save each Fabric's areas as 4 set of coordinates [4 corners].(e.g.) #0 @ 1,2: 2x2 will be saved as (1,2),(1,4),(3,2),(3,4). All the data 
###### Create an int array with the biggest set of coordinates(max_X,max_Y) that was found.
Then check how many squares of each Areas are overlapping. 

#### Day 5
###### Part 1 : Save input to a char array.Traverse array to the find matching lower- and uppercase letters and replace them with '0'.When deleting the 2 chars check the next one with the then previous to see if they must be deleted.
###### Part 2 : Run the previous algorithm from part 1 26 times deleting one combination of lower- uppercase letter each time.


Puzzles descriptions can be found @ https://adventofcode.com/