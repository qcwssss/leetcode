package array_leet;


import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;


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

  @Test
  public void testAnswer() {
    String input1 = "{[]}";
    Assert.assertTrue(isValidNotForThisProblem(input1));

  }

}
