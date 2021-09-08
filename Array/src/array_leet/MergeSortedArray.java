package array_leet;

import java.util.Arrays;

public class MergeSortedArray {


  public void merge(int[] nums1, int m, int[] nums2, int n) {
    if (nums2.length == 0) return;

    int[] res = new int[m + n];
    int i = 0, j = 0, k = 0;
    while (k < m + n - 1) {
      int cur1 = nums1[i], cur2 = nums2[j];
      if (cur1 > cur2) {
        res[k] = cur2;
        j++;
      } else {
        res[k] = cur1;
      }
      k++;
    }

    nums1 = res;
  }

  /** Two pointers, adding from the tail. */
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
