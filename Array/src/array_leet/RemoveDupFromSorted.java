package array_leet;

import org.junit.Test;

public class RemoveDupFromSorted {

  // official solution, using two pointers
  public int removeDuplicates(int[] nums) {
    if (nums.length == 0) return 0;
    int i = 0;
    for (int j = 1; j < nums.length; j++) {
      if (nums[j] != nums[i]) {
        i++;
        nums[i] = nums[j];
      }
    }
    return i + 1;
  }

  public int removeDuplicatesMine(int[] nums) {
    if (nums.length == 0) return 0;
    int ptr = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[ptr] != nums[i]) {
        ptr++;
        nums[ptr] = nums[i];
      }
    }
    return ptr + 1;

  }



  @Test
  public void testRemoveDupFromSortedArray() {
    int[] nums1 = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
    //int actual = removeDuplicates(nums1);
    int actual = removeDuplicatesMine(nums1);

    System.out.println(actual);
  }
}
