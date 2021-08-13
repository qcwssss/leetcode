package array_leet;


import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;


public class ValidParentheses {

  public boolean isValid(String s) {
    // first, check odd or even
    HashMap<Character, Character> brackets = new HashMap<>();
    brackets.put('(', ')');
    brackets.put('[', ']');
    brackets.put('{', '}');
    for (int i = 0; i < s.length() - 1; i++) {
      if(brackets.containsKey(s.charAt(i)) ) {
        if (s.charAt(i+1) != brackets.get(s.charAt(i))){
          return false;
        }
      } else {
        return false;
      }
    }
    return true;
  }

  @Test
  public void testAnswer() {
    String input1 = "{[]}";
    Assert.assertTrue(isValid(input1));

  }

}
