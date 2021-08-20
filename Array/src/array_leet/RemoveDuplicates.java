package array_leet;

import org.junit.Test;

public class RemoveDuplicates {

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

  /* Remove duplicates with the given value. */
  // official solution using two pointers
  public int removeElement(int[] nums, int val) {
    int i = 0;
    for (int j = 0; j < nums.length; j++) {
      if (nums[j] != val) {
        nums[i] = nums[j];
        i++;
      }
    }
    return i;
  }



  @Test
  public void testRemoveDupFromSortedArray() {
    int[] nums1 = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
    int[] nums2 = new int[] {3,2,2,3};
    //int actual = removeDuplicates(nums1);
    int actual = removeDuplicatesMine(nums1);
    int actual2 = removeElement(nums2, 3);

    System.out.println(actual);
    System.out.println(actual2);

  }
}
