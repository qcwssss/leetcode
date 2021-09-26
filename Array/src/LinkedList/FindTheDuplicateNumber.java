package LinkedList;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class FindTheDuplicateNumber {

  /*
  Approach1: set
  2: sort array
  3:
   */
  public int findDuplicate1(int[] nums) {
    // space O(n), time O(n)
    Set<Integer> seen = new HashSet<>();
    for (int num : nums) {
      if (!seen.add(num)) return num;
    }
    return -1;
  }

  //  2: sort array
  public int findDuplicate2(int[] nums) {
    Arrays.sort(nums);
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] == nums[i-1]) return nums[i];
    }
    return -1;
  }
}
