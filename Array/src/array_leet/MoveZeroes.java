package array_leet;

import org.junit.Assert;
import org.junit.Test;

public class MoveZeroes {

  public void moveZeroes(int[] nums) {
    // k-> 0 index, j -> digit pointer
    int idx0 = -1, j = -1;
    for (int i = 0; i < nums.length; i++) {
      if (idx0 < 0 && nums[i] == 0) {
        idx0 = i;
      } else if (nums[i] != 0) {
        j = i;
      }
      // swap
      if (j > idx0) {
        nums[idx0] = nums[j];
        nums[j] = 0;
        idx0 = -1;
      }

    }

  }

  @Test
  public void testRemoveZeroes() {
    int[] nums1 = {0,1,0,3,12};
    int[] expected1 = {1,3,12,0,0};
    moveZeroes(nums1);
    Assert.assertTrue(expected1.equals(nums1));
  }
}
