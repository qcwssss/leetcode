package array_leet;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class MoveZeroes {

  /**
   * Place all non-zero digits in the front, and fill the rest with 0s.
   * @source https://www.youtube.com/watch?v=1PEncepEIoE
   */
  public void moveZeroes(int[] nums) {
    int idx = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != 0) {
        nums[idx] = nums[i];
        idx++;
      }
    }
    for (int i = idx; i < nums.length; i++) {
      nums[i] = 0;
    }
  }

  @Test
  public void testRemoveZeroes() {
    int[] nums1 = {0,1,0,3,12};
    int[] expected1 = {1,3,12,0,0};
    moveZeroes(nums1);
    Assert.assertArrayEquals(expected1, nums1);
  }
}
