package Stack;

import java.util.Stack;

public class MinStack {
  Stack<Integer> stack;
  Stack<Integer> minStack;


  public MinStack() {
    stack = new Stack<>();
    minStack = new Stack<>();

  }

  public void push(int val) {
    stack.push(val);
    // add to minStack
    if (minStack.isEmpty()) {
      minStack.push(val);
    } else if (minStack.peek() > val) {
      minStack.push(val);

    }

  }

  public void pop() {
    if (!stack.isEmpty()) {
      stack.pop();
    }

  }

  public int top() {
    return stack.peek();

  }

  public int getMin() {
    return minStack.pop();
  }

}

