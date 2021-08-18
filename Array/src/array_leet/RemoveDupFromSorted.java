package array_leet;

import org.junit.Test;

public class RemoveDupFromSorted {
  public int removeDuplicates(int[] nums) {
    int size = nums.length;
    for (int i = 0; i < size; i++) {
      if (nums[i] == nums[i + 1]) {
        nums[i] = Integer.MIN_VALUE;
        moveFoward(nums, i);
        size--;
      }
    }
    return size;
  }

  private void moveFoward(int[] nums, int x) {
    for (int i = x; i < nums.length; i++) {
      if (i == nums.length - 1) {
        nums[i] = Integer.MIN_VALUE;
      } else {
        nums[x] = nums[x + 1];
      }
    }
  }

  @Test
  public void testRemoveDupFromSortedArray() {
    int[] nums1 = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
    int actual = removeDuplicates(nums1);
    System.out.println(actual);
  }
}
