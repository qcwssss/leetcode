package binarySearch;

import java.util.Arrays;
import java.util.HashSet;

/** #.349 https://leetcode.com/problems/intersection-of-two-arrays/solution/ */
public class IntersectionOfTwoArrays {
  public int[] intersection(int[] nums1, int[] nums2) {
    Arrays.sort(nums1);
    Arrays.sort(nums2);
    int[] s, l;
    s = nums1.length > nums2.length ? nums2 : nums1;
    l = nums1.length > nums2.length ? nums1 : nums2;

    int left = 0, right = l.length - 1, ptr = 0, i = 0;
    int[] ans = new int[s.length];
    while (left <= right) {
      int target = s[ptr];
      int mid = left + (right - left) / 2;
      if (l[mid] == target) ans[i] = target;
      else if (l[mid] < target) left = mid + 1;
      else right = mid - 1;
    }
    return ans;
  }

  /** build-in intersection solution */
  public int[] intersection2(int[] nums1, int[] nums2) {
    HashSet<Integer> set1 = new HashSet<>();
    for (Integer i : nums1) set1.add(i);
    HashSet<Integer> set2 = new HashSet<>();
    for (Integer i : nums2) set2.add(i);

    set1.retainAll(set2);
    int[] ans = new int[set1.size()];
    int idx = 0;
    for (Integer i : set1) {
      ans[idx] = i;
      idx++;
    }

    return ans;
  }

  /**
    This is a Facebook interview question.
  They ask for the intersection, which has a trivial solution using a hash or a set.

  Then they ask you to solve it under these constraints:
  O(n) time and O(1) space (the resulting array of intersections is not taken into consideration).
  You are told the lists are sorted.

  Cases to take into consideration include:
  duplicates, negative values, single value lists, 0's, and empty list arguments.
  Other considerations might include
  sparse arrays.

  function intersections(l1, l2) {
      l1.sort((a, b) => a - b) // assume sorted
      l2.sort((a, b) => a - b) // assume sorted
      const intersections = []
      let l = 0, r = 0;
      while ((l2[l] && l1[r]) !== undefined) {
         const left = l1[r], right = l2[l];
          if (right === left) {
              intersections.push(right)
              while (left === l1[r]) r++;
              while (right === l2[l]) l++;
              continue;
          }
          if (right > left) while (left === l1[r]) r++;
           else while (right === l2[l]) l++;

      }
      return intersections;
  }

     */

}
