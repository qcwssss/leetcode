package Stack;

import java.util.Stack;

public class ImplementQueueUsingStacks {

  class MyQueue { // O(n) time

    Stack<Integer> stack;
    Stack<Integer> reverse;

    public MyQueue() {
      stack = new Stack<>(); //
      reverse = new Stack<>();
    }

    public void push(int x) {
      if (reverse.isEmpty()) {
        reverse.push(x);
      } else {
        while (!reverse.isEmpty()) {
          stack.push(reverse.pop());
        }
        stack.push(x);
        while (!stack.isEmpty()) {
          reverse.push(stack.pop());
        }
      }
    }

    public int pop() {
      return reverse.pop();
    }

    public int peek() {
      return reverse.peek();
    }

    public boolean empty() {
      return reverse.isEmpty();
    }
  }

  class MyQueue2 { // O(1) time
    Stack<Integer> stack;
    Stack<Integer> queue;

    public MyQueue2() { // O(1) time
      stack = new Stack<>();//
      queue = new Stack<>();

    }

    public void push(int x) {
      stack.push(x);
    }

    public int pop() {
      peek();
      return queue.pop();

    }

    public int peek() {
      if (queue.isEmpty()) {
        while (!stack.isEmpty()) {
          queue.push(stack.pop());
        }
      }
      return queue.peek();
    }

    public boolean empty() {
      return queue.isEmpty() && stack.isEmpty();

    }
  }
}
