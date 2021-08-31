package array_leet;

import org.junit.Test;
// #66. Plus One
public class PlusOne {

  /*
  Turn array into an integer, plus one, then convert it to an array;
  This may leads to overflow when input large integer!!
   */
  public int[] plusOne(int[] digits) {
    int len = digits.length;
    int num = 0, j = 0;
    for (int i = len -1; i >= 0; i--) {
      num += digits[i]*Math.pow(10, j);
      j++;
    }

    num += 1;
    int ansLen = (int) Math.log10(num) + 1;
    int[] ans = new int[ansLen];
    while (num > 0) {
      ansLen--;
      ans[ansLen] = num % 10;
      num = num / 10;

    }
    return ans;
  }

  /**
   * @source  https://leetcode.com/problems/plus-one/discuss/?currentPage=1&orderBy=most_votes&query=
   * @param digits
   * @return
   */
  public int[] plusOneSmart(int[] digits) {
    int n = digits.length;
    for (int i = n -1; i >= 0; i--) {
      if (digits[i] < 9) {
        digits[i] += 1;
        return digits;
      }
        digits[i] = 0;
    }

    // for the case that the whole input array is 9s.
    // For example : 99999-----> 100000
    // Any other case would return in the loop.
    int[] newDigits = new int[n + 1];
    newDigits[0] = 1;

    return newDigits;
  }

  @Test
  public void testPlusOne() {
    int[] n1 = new int[] {1, 2, 3};
    int[] actual = plusOne(n1);

    int[] n2 = new int[] {9,8,7,6,5,4,3,2,1,0};
    int[] actual2 = plusOne(n2);

    int[] n3 = new int[] {9};
    plusOneSmart(n3);
  }
}
