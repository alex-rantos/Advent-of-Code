package lib;

import java.util.ArrayList;

// ThreadPool
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.MIN_VALUE;

public class Helpers {
    public <L,T> int isContained(ArrayList<L> genArray,Object targetElem) {
        int size = genArray.size();
        for(int i = 0 ; i < size ;i++){
            if(genArray.get(i).equals(targetElem)) return i;
        }
        return -1;
    }
    
    public <L> Boolean hasDuplicate(ArrayList<L> genericArray) {
        int size = genericArray.size();
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                if (genericArray.get(i).equals(genericArray.get(j)) ) {
                    return true;
                }
            }
        }
        return false;
    }

    public static String charRemoveAt(String str, int p) {
        return str.substring(0, p) + str.substring(p + 1);
    }

    public static String charsRemoveAt(String str, int p, int charactersToDelete) {
        return str.substring(0, p) + str.substring(p + charactersToDelete);
    }

    public static char[] removeConsecutive(char[] origArr, char remove, int size) {
        char[] charArr = new char[size];
        int i = 0;
        for(char c : origArr) {
            if(c != remove ) {
                charArr[i] = c;
                i++;
            }
        }
        return charArr;
    }

    public static String removeConsecutive(String str, char remove) {
        StringBuilder sb = new StringBuilder();
        for(char c : str.toCharArray()) {
            int length = sb.length();
            if(c != remove || length == 0 || sb.charAt(length - 1) != c) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static int findMinArray(int[] array) {
        int min = MAX_VALUE;

        for (int i : array) {
            if (i < min) min = i;
        }

        return min;
    }

    public static int findMaxArray(int[] array) {
        int max = MIN_VALUE;

        for (int i : array) {
            if (i > max) max = i;
        }

        return max;
    }

}


/*
public class Test
{
    // Maximum number of threads in thread pool
    static final int MAX_T = 3;

    public static void main(String[] args)
    {
        // creates five tasks
        Runnable r1 = new Task("task 1");
        Runnable r2 = new Task("task 2");
        Runnable r3 = new Task("task 3");
        Runnable r4 = new Task("task 4");
        Runnable r5 = new Task("task 5");

        // creates a thread pool with MAX_T no. of
        // threads as the fixed pool size(Step 2)
        ExecutorService pool = Executors.newFixedThreadPool(MAX_T);

        // passes the Task objects to the pool to execute (Step 3)
        pool.execute(r1);
        pool.execute(r2);
        pool.execute(r3);
        pool.execute(r4);
        pool.execute(r5);

        // pool shutdown ( Step 4)
        pool.shutdown();
    }
}
*/
