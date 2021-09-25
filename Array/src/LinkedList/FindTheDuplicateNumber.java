package LinkedList;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class FindTheDuplicateNumber {

  /*
  Approach1: set
  2: sort array
  3:
   */
  public int findDuplicate(int[] nums) {
    Set<Integer> seen = new HashSet<>();
    for (int num : nums) {
      if (!seen.add(num)) return num;
    }
    return -1;
  }
}
