import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

// leetcode 253
public class meetingRoomsII {
    // sweep line
    public static int findMinNumRooms(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
        //int[][] weights = new int[intervals.length*2][2];
        ArrayList<Point> weights = new ArrayList<>(intervals.length * 2);
        for (int[] i : intervals) {
            // use Point replace (new int[]{i[0], 1})
            weights.add(new Point(i[0], 1));
            weights.add(new Point(i[1], -1));
        }
        Collections.sort(weights, (a, b) -> (a.x - b.x)); // sort by time(start or end)
        int count = 0;
        int res = 0;
        for (Point i : weights) {
            if (i.y == 1) {
                count++;
            } else {
                count--;
            }
            res = Math.max(count, res);
        }
        return res;

    }

    public static void testCountMin(int[][] intervals) {
        String strInterval = intervals.toString();
        System.out.println(strInterval + ": " + findMinNumRooms(intervals));
    }

    public static void main(String[] args) {
        int[][] intervals1= {{0, 30}, {5, 10}, {15, 20}};
        int[][] intervals2= {{7, 10}, {2, 4}};
        int[][] intervals3= {{1, 10}, {2, 7}, {3, 19}, {8, 12}, {10, 20}, {11, 30}};

        testCountMin(intervals1);
        testCountMin(intervals2);
        testCountMin(intervals3);


    }


}