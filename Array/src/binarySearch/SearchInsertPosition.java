package binarySearch;

import org.junit.Assert;
import org.junit.Test;

public class SearchInsertPosition {

  /**
   * #1.Brute force way
   * @source https://github.com/qcwssss/leetcode-master/blob/master/problems/0035.%E6%90%9C%E7%B4%A2%E6%8F%92%E5%85%A5%E4%BD%8D%E7%BD%AE.md
   */
  public static int search(int[] nums, int target) {
    int len = nums.length;

    for (int i = 0; i < len; i++) {
      if (nums[i] >= target) return i;
    }
    return len;
  }

  /** #2. Binary Search */
  public static int search2(int[] nums, int target) {
    int left = 0, right = nums.length;
    while (left < right) {
      int mid = left + (right - left) / 2;
      int midVal = nums[mid];
      if (midVal < target) left = mid + 1; // search the right half
      else if (midVal > target) right = mid;
      else return mid;
    }

    return right;
  }

  @Test
  public void testSeachInsert() {
    int[] nums1 = {1, 3, 5, 6};
    int t1 = 5;
    Assert.assertEquals(2, search(nums1, t1));

    int tar0 = 0;
    Assert.assertEquals(0, search(nums1, tar0));

    int t2 = 2;
    Assert.assertEquals(1, search2(nums1, t2));

    int t7 = 7;
    Assert.assertEquals(4, search2(nums1, t7));
  }
}
