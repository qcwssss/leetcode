package array_leet;

import java.util.Arrays;

public class MergeSortedArray {



  /** Two pointers, adding from the tail.
   * @source https://www.youtube.com/watch?v=0PHGaGma6j8
   * @source https://github.com/ojasmaru/LetsAlgoTogether/blob/master/Merge%20Sorted%20Array/Java/QuickStart.java
   *
   * */
  public static void merge2(int[] nums1, int m, int[] nums2, int n) {

    int i = m - 1, j = n - 1, k = m + n - 1;
    while ( i >=0 && j >= 0) {
      if (nums1[i] < nums2[j]) {
        nums1[k] = nums2[j];
        j--;
      } else {
        nums1[k] = nums1[i];
        i--;
      }
      k--;
    }

    while (j >= 0) {
      nums1[k] = nums2[j];
      k--;
      j--;
    }
  }


  public static void main(String[] args) {

    var nums1 = new int[] { 1, 3, 5, 0, 0, 0, 0, 0 };
    var nums2 = new int[] { 2, 4, 6, 8, 10 };
    System.out.println("Nums1 = " + Arrays.toString(nums1));
    System.out.println("Nums2 = " + Arrays.toString(nums2));

    merge2(nums1, 3, nums2, 5);

    System.out.println("Merged Array = " + Arrays.toString(nums1));

    System.out.println("****************************************");

    nums1 = new int[] { 11, 12, 0, 0, 0, 0, 0 };
    nums2 = new int[] { 2, 4, 6, 8, 10 };
    System.out.println("Nums1 = " + Arrays.toString(nums1));
    System.out.println("Nums2 = " + Arrays.toString(nums2));

    merge2(nums1, 2, nums2, 5);

    System.out.println("Merged Array = " + Arrays.toString(nums1));

  }


}
