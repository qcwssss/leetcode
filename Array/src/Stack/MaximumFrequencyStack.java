package Stack;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;

public class MaximumFrequencyStack {

  class FreqStack {
    PriorityQueue<int[]> pq; // [val, freq, insert seq]
    Map<Integer, Integer> map; // <val, freq>
    int pushCount = 0; // insert sequence
    public FreqStack() {
      pq = new PriorityQueue<>( (a, b) -> a[1] == b[1] ? b[2] - a[2] : b[1] - a[1]);
      map = new HashMap<>();
    }

    public void push(int val) {
      map.put(val, map.getOrDefault(val, 0) + 1);
      pq.offer(new int[] {val, map.get(val), pushCount});
      pushCount++;
    }

    public int pop() {
      int res = pq.poll()[0];
      map.put(res, map.get(res) - 1);
      return res;
    }
  }

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */
}
