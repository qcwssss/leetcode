package SlidingWindow;

import org.junit.Assert;
import org.junit.Test;

public class LongestSubstring {

  public int lengthOfLongestSubstring(String s) {
    int n = s.length();

    if (n < 2) return n;
    int cnt = 0, ans = 0;

    int j = 0;
    while (j < n) {
      for (int i = 1; i < n; i++) {
        if (s.charAt(i) != s.charAt(j)) {
          cnt++;
          ans = Math.max(cnt, ans);
        } else {
          j++;
          cnt = 0;
          //i = j + 1;
        }
      }
    }
    return ans;

  }

  @Test
  public void testLengthOfSubstring() {
    String s = "abcabcbb";
    Assert.assertEquals(3, lengthOfLongestSubstring(s));
  }

}
