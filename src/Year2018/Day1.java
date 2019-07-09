package Year2018;
import src.lib.Helpers;

import java.io.*;
import java.util.ArrayList;

public class Day1 {

    public void solution1_1(){

        try {
            File file = new File("src/Year2018/input1.txt");

            BufferedReader br = new BufferedReader(new FileReader(file));

            String line;
            Integer sum = 0, numberRead;

            while ((line = br.readLine()) != null) {
                numberRead = Integer.valueOf(line);
                sum += numberRead;
            }
            br.close();
            System.out.println("Requested number is " + sum);

        } catch (Exception e) {
            System.out.println("Working Directory = " +
                    System.getProperty("user.dir") + " [" + e);
        }

    }

    public void solution1_2(){

        try {
            File file = new File("src/Year2018/input1.txt");

            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            long sum = 0, numberRead;
            ArrayList<Long> numberSequence = new ArrayList<>(), sumArray = new ArrayList<>();

            Helpers H = new Helpers();
            boolean found = false;

            while ((line = br.readLine()) != null) {
                numberRead = Long.valueOf(line);
                numberSequence.add(numberRead);
                sum += numberRead;
                if (H.isContained(sumArray, sum) == -1) {
                    sumArray.add(sum);
                } else {
                    found = true;
                    break;
                }
            }
            br.close();

            while (!found) {
                for (long i : numberSequence) {
                    sum += i;
                    if ((H.isContained(sumArray, sum)) == -1) {
                        sumArray.add(sum);
                    } else {
                        found = true;
                        break;
                    }
                }
            }
            System.out.println("This number was found twice : " + sum);
        } catch (Exception e) {
            System.out.println("Working Directory = " + System.getProperty("user.dir") + " " + e);
        }
    }
}
