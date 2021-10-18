package SingleArray;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DecodeWays {

  public int numDecodings(String s) {
    int len = s.length();
    if  (len == 0) return 0;
    int[] memo = new int[len + 1];

    // build memo for dp
    memo[0] = 1;
    memo[1] = s.charAt(0) == '0' ? 0 : 1;
    for (int i = 2; i <= len; i++) {
      int twoDigit = Integer.valueOf(s.substring(i-2, i)); // substring [i, j)
      int oneDigit = Integer.valueOf(s.substring(i-1, i));
      if (10 <= twoDigit && twoDigit <= 26) memo[i] += memo[i - 2];
      if (oneDigit != 0) memo[i] += memo[i - 1];
    }
    return memo[len];

  }

  @Test
  public void testDecode() {
    Assertions.assertEquals(2, numDecodings("12"));
    Assertions.assertEquals(3, numDecodings("226"));

  }


  public int numDecodings_3(String s) {
    int count = 1;
    for (int i = 1; i < s.length(); i++) {
      if (s.charAt(i - 1) == '0') {
        String twoChars = String.valueOf(s.charAt(i - 1) + s.charAt(i));
        int dual = Integer.parseInt(twoChars);
        if (dual <= 26) count++;
      }
    }

    return count;
  }
}
