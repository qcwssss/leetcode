import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Definition of Interval:
 * public classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

public class countPlanes {
     public static class Interval {
      int start, end;

      public Interval(int start, int end) {
          this.start = start;
          this.end = end;
      }
  }
    /**
    * @param airplanes: An interval array
    * @return: Count of airplanes are in the sky.
    */
    public static int countOfAirplanes(List<Interval> airplanes) {
        // write your code here
        List<Interval> timesList = new ArrayList<>(airplanes.size());
        for (Interval i : airplanes) {
            timesList.add(new Interval(i.start, 1));
            timesList.add(new Interval(i.end, -1));
        }

        Collections.sort(timesList, (i1, i2) -> {
            if (i1.start == i2.end) return i1.end - i2.end;
            return i1.start - i2.start;
        });

        // scan
        int count = 0;
        for (Interval i : timesList) {
            if (i.end == 1) {
                count++;
            } else {
                count--;
            }
        }
        return count;
}

   public static void main(String[] args) {
       Interval[] planesList = {new Interval(1, 10),new Interval (2, 3), new Interval(5, 8),new Interval (4, 7)};
       int answer = countOfAirplanes(Arrays.asList(planesList));
       System.out.println(answer);
   } 
    


}