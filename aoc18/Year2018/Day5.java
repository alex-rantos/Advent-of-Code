package Year2018;

import lib.Helpers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Day5 {


    private lib.Helpers helpers = new lib.Helpers();

    public void solution5() {

        try {
            File file = new File("src/Year2018/input5.txt");

            BufferedReader br = new BufferedReader(new FileReader(file));

            String line;

            int[] shortestPolymer = new int[26];

            while ((line = br.readLine()) != null) {

                int length = solution5_1(line);

                System.out.println("Part 1 : Final length of string is [" + length + "]");

                for (int i = 65 ; i <= 90 ;i++) {
                    String newInstance = line.replace(Character.toString ((char) i),"");
                    newInstance = newInstance.replace(Character.toString((char) (i + 32)),"");
                    //System.out.println(newInstance);
                    shortestPolymer[i-65] = solution5_1(newInstance);
                }

            }
            System.out.println("Part 2 : Shortest polymer has length [" + helpers.findMinArray(shortestPolymer)+"]");
            br.close();

        } catch (Exception e) {
            System.out.println("Working Directory = " +
                    System.getProperty("user.dir") + " ERROR : " + e );
            e.printStackTrace();
        }
    }

    private int solution5_1(String line) {

        int found = 1;
        char[] array = line.toCharArray();
        int i = 1, j;//k=0;

        while( i < array.length) {
            j = 1;

            while ((int) array[i-j] + 32 == (int) array[i] ||
                    (int) array[i-j] - 32 == (int) array[i]) {


                array[i-j] = '0';
                array[i] = '0';

                line = helpers.charsRemoveAt(line,i - found,2);

                if (found == 1) found = 0;

                found += 2;
                i++;
                j+=2;

                while ( ((i-j) > 0) && (array[i-j] == '0') ) {
                    j++;
                    //k++;
                }

                if ( i - j < 0) break;
            }
            /* Unsuccessful optimization
            if (k > 1500000) {
                array = helpers.removeConsecutive(array,'0',line.length());
                i = 0;
                found = 1;
                k = 0;
            }*/
            i++;
        }
        /* Validate result.
        for (char ch : array) {
            if (ch != '0') System.out.print(ch);
        }
        System.out.print('\n');*/
/*
        System.out.println("Final string after reactions [" + line + "] \n " +
                "Deleted " + found + " chars. Final length of string is [" + (line.length()) + "]");*/
        return line.length();
    }
}
