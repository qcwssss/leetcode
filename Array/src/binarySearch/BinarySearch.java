package binarySearch;

import org.junit.Assert;
import org.junit.Test;

public class BinarySearch {
  public int search(int[] nums, int target) {
    int left = 0, right = nums.length;
    while (left < right) {
      int mid = left + (right - left) / 2; // avoid overflow
      if (target == nums[mid]) return mid;
      else if (target < nums[mid]) right = mid;
      else left = mid + 1;
    }
    return -1;
  }

  @Test
  public void testSeachInsert() {
    int[] nums1 = {-1, 0, 3, 5, 9, 12};
    int t1 = 9;
    Assert.assertEquals(4, search(nums1, t1));
  }
}
