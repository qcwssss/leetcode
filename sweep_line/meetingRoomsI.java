import java.util.Arrays;

// leetcode 252. meeting rooms I
public class meetingRoomsI {
    // determine if a person could attend all meetings
    public static boolean countAttend(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
        int count = 1;
        for (int i = 0; i < intervals.length - 1; i++) {
            if (intervals[i][1] > intervals[i+1][0]) {
                return false; // if overlapping, return false
            }
        }
        return true;
    }

    public static void testCountAttend(int[][] intervals) {
        String strInterval = String.valueOf(intervals);
        if (countAttend(intervals)) {
            System.out.println(strInterval + ": true");
        } else {
            System.out.println(strInterval + ": false");
        }

    }

    // run test
    public static void main(String[] args) {
        int[][] intervals1= {{0, 30}, {5, 10}, {15, 20}};
        int[][] intervals2= {{7, 10}, {2, 4}};

        testCountAttend(intervals1);
        testCountAttend(intervals2);

            
    }
}