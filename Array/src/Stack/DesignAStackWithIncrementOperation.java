package Stack;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DesignAStackWithIncrementOperation {
  // non-lazy operation
  class CustomStack {
    int[] stack;
    int size = 0;
    int top;
    int capacity;

    public CustomStack(int maxSize) {
      stack = new int[maxSize];
      capacity = maxSize;
      top = 0;
    }

    public void push(int x) {
      if (size < capacity) {
        stack[top] = x;
        size += 1;
        top += 1;
      }
    }

    public int pop() {
      if (size != 0) {
        size--;
        int val = stack[--top];
        // top = top < 1 ? 0 : --top; // edge
        return val;
      } else {
        return -1;
      }
    }

    public void increment(int k, int val) {
      k = Math.min(size, k);
      for (int i = 0; i < k; i++) stack[i] += val;
    }
  }

  /**
   * Your CustomStack object will be instantiated and called as such: CustomStack obj = new
   * CustomStack(maxSize); obj.push(x); int param_2 = obj.pop(); obj.increment(k,val);
   */
  @Test
  public void testIncreStack() {
    CustomStack customStack = new CustomStack(3); // Stack is Empty []
    customStack.push(1); // stack becomes [1]
    customStack.push(2); // stack becomes [1, 2]
    customStack.pop(); // return 2 --> Return top of the stack 2, stack becomes [1]
    customStack.push(2); // stack becomes [1, 2]
    customStack.push(3); // stack becomes [1, 2, 3]
    customStack.push(4); // stack still [1, 2, 3], Don't add another elements as size is 4
    customStack.increment(5, 100); // stack becomes [101, 102, 103]
    customStack.increment(2, 100); // stack becomes [201, 202, 103]
    assertEquals(
        103,
        customStack.pop()); // return 103 --> Return top of the stack 103, stack becomes [201, 202]
    customStack.pop(); // return 202 --> Return top of the stack 102, stack becomes [201]
    customStack.pop(); // return 201 --> Return top of the stack 101, stack becomes []
    customStack.pop(); // return -1 --> Stack is empty return -1.
  }
}
