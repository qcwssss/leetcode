package array_leet;


import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Stack;


public class ValidParentheses {

  /* Misunderstand the problem. */
  public boolean isValidNotForThisProblem(String s) {
    // first, check odd or even
    if (s.length() % 2 != 0) return false;
    //count  1: (), 2: [], 3: {}
    int[] count = {0, 0, 0};
    int[] valid = {0, 0, 0};

    for(int i = 0; i < s.length(); i++) {
      switch (s.charAt(i)) {
        case '(':
          count[0]++;
          break;

        case ')':
          count[0]--;
          break;

        case '[':
          count[1]++;
          break;

        case ']':
          count[1]--;
          break;

        case '{':
          count[2]++;
          break;

        case '}':
          count[2]--;
          break;
      }
    }
    return Arrays.equals(count, valid);
  }

  public boolean isValid(String s) {
    /*
    if (s.length() % 2 != 0) return false;
    This line maybe unnecessary since, if the length of the string is odd, the stack can't be empty
    at the end.
     */
    Stack<Character> stack = new Stack<>();
    for(char c : s.toCharArray()) {
      if(c == '(') {
        stack.push(')');
      }
      else if(c == '[') {
        stack.push(']');
      }
      else if(c == '{') {
        stack.push('}');
      }
      // if stack is empty, there is no open parentheses.
      else if(stack.isEmpty() || c != stack.pop()) {
        return false;
      }
    }

    return stack.isEmpty();
  }

  @Test
  public void testAnswer() {
    String input1 = "{[]}";
    //Assert.assertTrue(isValidNotForThisProblem(input1));
    Assert.assertTrue(isValid(input1));

  }

}
