package String;

import org.junit.Assert;
import org.junit.Test;

public class CountBinarySubstrings {

  public int countBinarySubstrings(String s) {
    // two pointer, brute force
    int cnt1 = 0, cnt0 = 0, res = 0; // cnt1 is count the char of head
    int n = s.length();

    int j = 0;
    while (j < n) {
      char head = s.charAt(j);
      for (int i = j + 1; i < s.length(); i++) {
        if (cnt1 == cnt0 && cnt1 != 0) {
          res++;
          break;
        }

        if (s.charAt(i) != head) {
          cnt0++;
          continue;
        }
        if (s.charAt(i) == head) {
          if (cnt0 == 0) {
            cnt1++;
          } else {
            break;
          }
        }
      }
      j++;
    }

    return res;
  }

  /**
   * @source https://www.youtube.com/watch?v=MGPHPadxhtQ
   */
  public int countBinarySubstrings_Group(String s) {
    int count = 0, i = 1, prev = 0, curr = 1;
    while(i < s.length()) {
      //11000110
      if(s.charAt(i-1) != s.charAt(i)) {
        count+=Math.min(prev, curr);
        prev = curr;
        curr = 1;
      }
      else {
        curr++;
      }
      i++;
    }

    return count+=Math.min(prev, curr);
  }

  @Test
  public void testCountBinarySubStrs() {
    String s1 = "00110011";
    Assert.assertEquals(6, countBinarySubstrings_Group(s1));

  }
}
