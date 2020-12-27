import Year2018.*;

public class Main {

    public static void main(String[] args) {
        final long startTime = System.currentTimeMillis();
       /* System.out.println("Day1 Solutions : ");
        Day1 day1solutions = new Day1();
        day1solutions.solution1_1();
        day1solutions.solution1_2();

        System.out.println(" ");
        System.out.println("Day2 Solutions : ");
        Day2 day2solutions = new Day2();
        day2solutions.solution2_1();
        day2solutions.solution2_2();

        System.out.println(" ");
        System.out.println("Day3 Solutions : ");
        Day3 day3Solutions = new Day3();
        day3Solutions.solution3();*/

        System.out.println(" ");
        System.out.println("Day5 Solutions : ");
        Day5 day5Solutions = new Day5();
        day5Solutions.solution5();

        final long endTime = System.currentTimeMillis();

        System.out.println("Total execution time: " + (endTime - startTime) + "ms");
    }
}
