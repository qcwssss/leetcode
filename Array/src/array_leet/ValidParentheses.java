package array_leet;


import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;


public class ValidParentheses {

  public boolean isValid(String s) {
    // first, check odd or even
    //count  1: (), 2: [], 3: {}
    int[] count = {0, 0, 0};
    int[] valid = {0, 0, 0};

    String res = count.toString();
    for(int i = 0; i < s.length(); i++) {
      if(s.charAt(i) == '(') {
        count[0]++;
      }
      else if (s.charAt(i) == ')') {
        count[0]--;
      }
      else if(s.charAt(i) == '[') {
        count[1]++;
      }
      else if(s.charAt(i) == ']') {
        count[1]--;
      }

      else if(s.charAt(i) == '{') {
        count[2]++;
      }

      else if(s.charAt(i) == '}') {
        count[2]--;
      }

    }
    return Arrays.equals(count, valid);
  }

  @Test
  public void testAnswer() {
    String input1 = "{[]}";
    Assert.assertTrue(isValid(input1));

  }

}
