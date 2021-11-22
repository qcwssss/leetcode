package binarySearch;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class MedianOfTwoSortedArray {
  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int[] numsAll = new int[nums1.length + nums2.length];
    int len = numsAll.length;
    System.arraycopy(nums1, 0, numsAll, 0, nums1.length);
    System.arraycopy(nums2, 0, numsAll, nums1.length, nums2.length);
    Arrays.sort(numsAll);

    if (numsAll.length % 2 == 0) {
      double sum = numsAll[len / 2] + numsAll[(len / 2) - 1];
      return sum / 2;
    } else {
      return numsAll[len / 2];
    }
  }

  public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
    int i = 0, j = 0, k = 0;
    int n1 = nums1.length, n2 = nums2.length;
    int len = n1 + n2;
    int[] res = new int[len];
    while (k < len) {
      if (i < n1 && j < n2) {
        if (nums1[i] < nums2[j]) {
          res[k] = nums1[i];
          i += 1;
        } else {
          res[k] = nums2[j];
          j += 1;
        }
      } else {
        if (j < n2) {
          res[k] = nums2[j];
          j += 1;
        }
        else if (i < n1) {
          res[k] = nums1[i];
          i += 1;
        }
      }

      k++;
    }

    if (res.length % 2 == 0) {
      double sum = res[len / 2] + res[(len / 2) - 1];
      return sum / 2;
    } else {
      return res[len / 2];
    }
  }

  @Test
  public void testMedian() {
    int[] nums1 = {1, 2}, nums2 = {3, 4};
    double expected = 2.50000;
    // Assert.assertEquals(expected, findMedianSortedArrays(nums1, nums2), 0.0001);
    Assert.assertEquals(expected, findMedianSortedArrays2(nums1, nums2), 0.0001);
  }

  @Test
  public void testMedian2() {
    int[] nums1 = {1, 3}, nums2 = {2};
    double expected = 2;
    // Assert.assertEquals(expected, findMedianSortedArrays(nums1, nums2), 0.0001);
    Assert.assertEquals(expected, findMedianSortedArrays2(nums1, nums2), 0.0001);
  }
}
