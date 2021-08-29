package binarySearch;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Stream;

public class MedianOfTwoSortedArray {
  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int[] numsAll = new int[nums1.length + nums2.length];
    int len = numsAll.length;
    System.arraycopy(nums1, 0, numsAll,0, nums1.length);
    System.arraycopy(nums2, 0, numsAll,nums1.length, nums2.length);
    Arrays.sort(numsAll);

    if (numsAll.length % 2 == 0) {
      double sum = numsAll[len / 2] +  numsAll[(len / 2) - 1];
      return sum / 2;
    } else {
      return numsAll[len / 2];
    }
  }

  @Test
  public void testMedian() {
    int[] nums1 =  {1,2}, nums2 = {3,4};
    double expected = 2.50000;
    Assert.assertEquals(expected, findMedianSortedArrays(nums1, nums2), 0.0001);
  }

}
