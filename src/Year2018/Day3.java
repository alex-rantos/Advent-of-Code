package Year2018;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day3 {

    int totalClaims = 0;
    ArrayList<Integer> uniqueIds = new ArrayList<>();

    public void solution3() {

        try {
            File file = new File("src/Year2018/input3.txt");

            BufferedReader br = new BufferedReader(new FileReader(file));

            String line;
            ArrayList<FabricArea> elvenPlans = new ArrayList<>();
            int maxX = 0,
                    maxY = 0;

            while ((line = br.readLine()) != null) {
                Pattern p = Pattern.compile("(\\d+)");
                Matcher m = p.matcher(line);
                m.find(); // skip number of fabric
                int id = Integer.valueOf(m.group());
                m.find();
                int x = Integer.valueOf(m.group());
                m.find();
                int y = Integer.valueOf(m.group());
                m.find();
                int width = Integer.valueOf(m.group());
                m.find();
                int height = Integer.valueOf(m.group());

                FabricArea FA = new FabricArea(id,x, y, width, height);
                elvenPlans.add(FA);
                maxX = (maxX < x + width) ? x + width : maxX;
                maxY = (maxY < y + height) ? y + width : maxY;
            }

            int[][] mapArray = new int[maxX+1][maxY+1];

            int size = elvenPlans.size();
            for (int i = 0 ; i < size ; i++) {
                FabricArea indexArea = elvenPlans.get(i);
                indexArea.claimArea(mapArray);
            }
            System.out.println("Total claims : " + totalClaims);
            size = uniqueIds.size();
            for (int i = 0 ; i < size ; i++) {
                int id = uniqueIds.get(i);
                FabricArea indexArea = elvenPlans.get(id-1);
                if (!indexArea.isOverlapping(mapArray)) {
                    System.out.println("Unique ID : " + id);
                }
            }
        /*
        System.out.println(Arrays.deepToString(mapArray));

        for (int[] x : mapArray)
        {
           for (int y : x)
           {
                System.out.print(y + " ");
           }
           System.out.println();
        } */

            br.close();

        } catch (Exception e) {
            System.out.println("Working Directory = " +
                    System.getProperty("user.dir") + " ERROR : " + e );
        }




    }

    private class FabricArea {
        private int id,x,y,width,height;
        private boolean overlaps;

        FabricArea(int _id,int _x,int _y,int w,int h) {
            id = _id;
            x = _x;
            y = _y;
            width = w;
            height = h;
            overlaps = false;
        }

        void claimArea(int[][] mapArray) {
            for (int i = 0 ; i < width; i++) {
                for (int j = 0 ; j < height; j++) {
                    mapArray[x+i][y+j]++;
                    if (mapArray[x+i][y+j] == 2) totalClaims++;
                    if (mapArray[x+i][y+j] >= 2) overlaps = true;
                }
            }
            if (!overlaps) {
                uniqueIds.add(id);
            }
        }

        boolean isOverlapping(int[][] mapArray) {
            for (int i = 0 ; i < width; i++) {
                for (int j = 0 ; j < height; j++) {
                    if (mapArray[x+i][y+j] >= 2) {
                        overlaps = true;
                        return true;
                    }
                }
            }
            return false;
        }
    }
}
