package String;

import org.junit.Assert;
import org.junit.Test;

public class ValidPalindrome {

  /* Doesn't work for "ab_a" input.    */
  public boolean isPalindrome(String s) {
    // to lower case, remove ','
    // two pointer
    // \W:  A non-word character: [^\w]
    s = s.toLowerCase().replaceAll("\\W+", ""); // can't remove '_'
    int i = 0, j = s.length() - 1;
    while (i < j) {
      if (s.charAt(i) != s.charAt(j)) {
        return false;
      }
      i++;
      j--;
    }
    return true;
  }

  /**
   * @source https://leetcode.com/problems/valid-palindrome/discuss/40029/Accepted-pretty-Java-solution(271ms)
   *
   */
  public boolean isPalindrome2(String s) {
    if (s.length() == 0) return true;

    // two pointer
    int i = 0, j = s.length() - 1;
    char head, tail;
    while (i < j) {
      head = s.charAt(i);
      tail = s.charAt(j);

      if (!Character.isLetterOrDigit(head)) {
        i++;
      } else if (!Character.isLetterOrDigit(tail)) {
        j--;
      } else {
        if (Character.toLowerCase(head) != Character.toLowerCase(tail)) {
          return false;
        }
        i++;
        j--;
      }
    }
    return true;
  }


  /**
   * Super concise solution.
   */
  public boolean isPalindrome3(String s) {
    char[] c = s.toCharArray();
    for (int i = 0, j = c.length - 1; i < j; ) {
      if (!Character.isLetterOrDigit(c[i])) i++;
      else if (!Character.isLetterOrDigit(c[j])) j--;
      else if (Character.toLowerCase(c[i++]) != Character.toLowerCase(c[j--]))
        return false;
    }
    return true;
  }

  @Test
  public void testAddStrings() {
    String s1 = "A man, a plan, a canal: Panama";
    String s2 = "ab_a";
    Assert.assertTrue(isPalindrome2(s1));
  }
}
