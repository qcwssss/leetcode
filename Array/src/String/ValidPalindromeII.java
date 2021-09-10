package String;

import org.junit.Assert;
import org.junit.Test;

public class ValidPalindromeII {

  public boolean validPalindrome(String s) {
    int n = s.length();
    int i = 0, j = n -1;

    while (i <= j) {
      if (s.charAt(i) != s.charAt(j)) {
        if (!isPalindrome(s, i+1, j) && !isPalindrome(s, i, j - 1)) {
          return false;
        }
      }
      i++;
      j--;
    }
    return true;

  }

  private boolean isPalindrome(String s, int start, int end) {
    while (start <= end) {
      if (s.charAt(start) != s.charAt(end)) {
        return false;
      }
      start++;
      end--;
    }
    return true;
  }

  @Test
  public void testPalindromeII() {
    String s1 = "aba";
    String s2 = "abca";
    String s3 = "abc";

    Assert.assertTrue(validPalindrome(s1));
    Assert.assertTrue(validPalindrome(s2));
    Assert.assertFalse(validPalindrome(s3));
  }

  @Test
  public void testPalindrome3() {
    String s1 = "deeee";

    Assert.assertTrue(validPalindrome(s1));
  }

}
