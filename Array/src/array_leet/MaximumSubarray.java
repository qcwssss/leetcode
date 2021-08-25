package array_leet;

import org.junit.Assert;
import org.junit.Test;

// #53. Maximum Subarray
public class MaximumSubarray {

  public static int maxSubArray(int[] nums) {
    int res = nums[0];
    for (int i = 0; i < nums.length; i++) {
      int sum = 0;
      for (int j = i; j < nums.length; j++) {
        sum += nums[j];
        res = Math.max(sum, res);
      }
    }
    return res;
  }

  /**
   * Kadane's Algorithm
   * @source https://leetcode.com/problems/maximum-subarray/discuss/20211/Accepted-O(n)-solution-in-java
   * @param A
   * @return
   */
  public static int maxSubArrayON(int[] A) {
    int maxSoFar=A[0], maxEndingHere=A[0];
    for (int i=1;i<A.length;++i){
      maxEndingHere= Math.max(maxEndingHere+A[i],A[i]);
      maxSoFar=Math.max(maxSoFar, maxEndingHere);
    }
    return maxSoFar;
  }

  @Test
  public void testMaxSubarray() {
    int[] nums1 = {-2,1,-3,4,-1,2,1,-5,4 };
    int expected1 = 6;
    Assert.assertEquals(expected1, maxSubArray(nums1));
  }
}
