package String;

import org.junit.Assert;
import org.junit.Test;

public class CountBinarySubstrings {

  /** 696. Count Binary Substrings. */
  public int countBinarySubstrings(String s) {
    // write by myself
    int cur = 1; // current number of 1/0
    int prev = 0; // number of previous digit
    int count = 0;
    char[] arr = s.toCharArray();
    for (int i = 1; i < s.length(); i++) {
      if (arr[i] != arr[i - 1]) {
        count += Math.min(prev, cur);
        prev = cur;
        cur = 1;
      } else {
        cur++;
      }
    }
    count += Math.min(prev, cur); // add the last group
    return count;
  }

  /**
   * @source https://www.youtube.com/watch?v=MGPHPadxhtQ
   * @source
   *     https://leetcode.com/problems/count-binary-substrings/discuss/108625/JavaC%2B%2BPython-Easy-and-Concise-with-Explanation
   */
  public int countBinarySubstrings_Group(String s) {
    int count = 0, i = 1, prev = 0, curr = 1;
    while (i < s.length()) { // 11000110
      if (s.charAt(i - 1) != s.charAt(i)) {
        count += Math.min(prev, curr);
        prev = curr;
        curr = 1;
      } else {
        curr++;
      }
      i++;
    }

    return count += Math.min(prev, curr);
  }

  @Test
  public void testCountBinarySubStrs() {
    String s1 = "00110011";
    Assert.assertEquals(6, countBinarySubstrings(s1));
  }
}
