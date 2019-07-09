package Year2018;

import src.lib.Helpers;
import java.io.*;
import java.util.ArrayList;

public class Day2 {
    public void solution2_1(){
        // We need to provide file path as the parameter:
        // double backquote is to avoid compiler interpret words
        // like \test as \t (ie. as a escape sequence)
        try {
            File file = new File("src/Year2018/input2.txt");

            BufferedReader br = new BufferedReader(new FileReader(file));

            String line;
            int[] checksumArray = new int[] {0,0}; // [0] : 2 char & [1] : 3 char occurencies

            while ((line = br.readLine()) != null) {
                ArrayList<Integer> occurenciesArr = new ArrayList<>();
                ArrayList<Character> charArr = new ArrayList<>();

                Helpers H = new Helpers();

                for (char ch: line.toCharArray()) {
                    int res = H.isContained(charArr,ch);
                    if (res == -1) {
                        charArr.add(ch);
                        occurenciesArr.add(1);
                    } else {
                        occurenciesArr.set(res,occurenciesArr.get(res) + 1);
                    }
                }

                boolean foundTwoChars = false,
                        foundThreeChars = false;
                for (int occ : occurenciesArr) {
                    if (occ == 2) {
                        foundTwoChars = true;
                    } else if (occ == 3) {
                        foundThreeChars = true;
                    }
                    if (foundThreeChars && foundTwoChars) break;
                }
                if (foundTwoChars) checksumArray[0]++;
                if (foundThreeChars) checksumArray[1]++;

            }

            System.out.println("Checksum is " + checksumArray[0]*checksumArray[1]);

            br.close();

        } catch (Exception e) {
            System.out.println("Working Directory = " +
                    System.getProperty("user.dir"));
        }

    }

    public void solution2_2(){
        // We need to provide file path as the parameter:
        // double backquote is to avoid compiler interpret words
        // like \test as \t (ie. as a escape sequence)
        try {
            File file = new File("src/Year2018/input2.txt");

            BufferedReader br = new BufferedReader(new FileReader(file));

            String line;
            ArrayList<String> linesArr = new ArrayList<>();

            while ((line = br.readLine()) != null) {
                for (String s: linesArr) {
                    int length = s.length(),
                            charDiff = 0, index = 0;
                    for (int i = 0 ; i < length;i++) {
                        if (s.charAt(i) != line.charAt(i)) {
                            charDiff++;
                            index=i;
                            if (charDiff >= 2) break;
                        }
                    }
                    if (charDiff == 1) System.out.println("Requested character sequence : "+charRemoveAt(s, index));
                }
                linesArr.add(line);
            }
            br.close();

        } catch (Exception e) {
            System.out.println("Working Directory = " +
                    System.getProperty("user.dir"));
        }

    }

    public static String charRemoveAt(String str, int p) {
        return str.substring(0, p) + str.substring(p + 1);
    }
}
