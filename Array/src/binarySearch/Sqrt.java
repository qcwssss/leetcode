package binarySearch;

import org.junit.Assert;
import org.junit.Test;

public class Sqrt {

  /**
   * Look for the critical point: i * i <= x && (i+1)(i+1) > x A little trick is using i <= x / i
   * for comparison, instead of i * i <= x, to avoid exceeding integer upper limit.
   * @source https://leetcode.com/problems/sqrtx/discuss/25198/3-JAVA-solutions-with-explanation
   */
  public static int mySqrt(int x) {
    if (x==0) return 0;
    int left = 1, right = x;
    while (left < right) {
      int mid = left + (right - left) / 2;
      if (mid <= x/mid && mid + 1 > x/(mid + 1)) return mid;
      else if (mid > x/mid) right = mid;
      else left = mid + 1;
    }
    return left;

  }

  @Test
  public void testMySqrt() {
    Assert.assertEquals(2, Sqrt.mySqrt(8));
  }
}
