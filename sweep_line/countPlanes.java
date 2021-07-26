import java.awt.*;
import java.util.List;
import java.util.*;

/**
 * Definition of Interval: public classs Interval { int start, end; Interval(int start, int end) {
 * this.start = start; this.end = end; } }
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

    Collections.sort(
        timesList,
        (i1, i2) -> {
          if (i1.start == i2.start) return i1.end - i2.end;
          return i1.start - i2.start;
        });

    // scan
    int count = 0;
    int ans = 0;
    for (Interval i : timesList) {
      if (i.end == 1) {
        count++;
      } else {
        count--;
      }
      ans = Math.max(ans, count); // maintain the max value
    }
    return ans;
  }
  // use priority queue to count planes on the air at once
  public static int countPlanesByPQ(Interval[] airplanes) {
    
    Arrays.sort(airplanes, (a, b) -> (a.start - b.start));
    PriorityQueue<Interval> pq = new PriorityQueue<>((p1, p2) -> p1.end - p2.end);

    // scan schedule
    if (airplanes.length != 0) pq.add(airplanes[0]);
    for (int i = 0; i < airplanes.length; i++) {
      Interval cur = airplanes[i];
      if (pq.isEmpty() ) {
        pq.add(cur);
      } else {
        if (pq.peek().end <= cur.start) {
          pq.poll();
        } else {
          pq.add(cur);
        }
      }

    }
    return pq.size();

  }

  public static void main(String[] args) {
    Interval[] planesList = {
      new Interval(1, 10), new Interval(2, 3), new Interval(5, 8), new Interval(4, 7)
    };
    int answer = countOfAirplanes(Arrays.asList(planesList));
    System.out.println("sweep line method: " + answer);

    int answer2 = countPlanesByPQ(planesList);
    System.out.println("Priority Queue method: " + answer2);

  }
}
