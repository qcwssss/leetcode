package array_leet;

import org.junit.Assert;
import org.junit.Test;

public class SearchInsertPosition {

  public int searchInsert(int[] nums, int target) {
    // brute force
    int len = nums.length;
    int returnVal = 0;
    if (target < nums[0]) return 0;
    if (target > nums[len - 1]) return len;

    for (int i = 0; i < len; i++) {
      if (target == nums[i]) return i;
      if (target > nums[i] && target < nums[i + 1]) return i + 1;
    }

    return len;
  }

  /**
   * @source https://github.com/qcwssss/leetcode-master/blob/master/problems/0035.%E6%90%9C%E7%B4%A2%E6%8F%92%E5%85%A5%E4%BD%8D%E7%BD%AE.md
   */
  public static int search(int[] nums, int target) {
    int len = nums.length;

    for (int i = 0; i < len; i++) {
      if (nums[i] >= target) return i;
    }
    return len;
  }

  @Test
  public void testSeachInsert() {
    int[] nums1 = { 1,3,5,6};
    int t1 = 5;
    Assert.assertEquals(2, search(nums1, t1));

    int[] nums0 = {1,3,5,6};
    int tar0 = 0;
    int ex0 = 0;
    Assert.assertEquals(ex0, search(nums0, tar0));
  }
}
