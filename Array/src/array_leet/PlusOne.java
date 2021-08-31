package array_leet;

import org.junit.Assert;
import org.junit.Test;

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

  @Test
  public void testPlusOne() {
    int[] n1 = new int[] {1, 2, 3};
    int[] ex1 = new int[] {1, 2, 4};
    int[] actual = plusOne(n1);
    //Assert.assertTrue(ex1.equals(actual));
    int[] n2 = new int[] {9,8,7,6,5,4,3,2,1,0};
    int[] actual2 = plusOne(n2);
  }
}
