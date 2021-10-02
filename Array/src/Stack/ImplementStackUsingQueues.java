package Stack;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueues {

  // pop time O(n)
  class MyStack {
    int top;
    Queue<Integer> q1;
    Queue<Integer> q2;

    public MyStack() {
      q1 = new LinkedList<>();
      q2 = new LinkedList<>();

    }

    public void push(int x) {
      q1.offer(x);
      top = x;
    }

    public int pop() {
      while(q1.size() > 1) {
        top = q1.poll();
        q2.offer(top);
      }
      int val = q1.poll(); // the last element in q1
      Queue<Integer> tmp = q2;
      q2 = q1;
      q1 = tmp;
      return val;

    }

    public int top() {
      return top;

    }

    public boolean empty() {
      return q1.isEmpty() && q2.isEmpty();
    }
  }
}
