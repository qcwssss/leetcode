package String;

import org.junit.Assert;
import org.junit.Test;

public class AddStrings {

  /**
   * Not working for large numbers. How to deal with overflow?
   */
  public String addStringsMine(String num1, String num2) {
    if (num1.equals("0")) return num2;
    if (num2.equals("0")) return num1;

    int len1 = num1.length(), len2 = num2.length();
    int size = Math.max(len1, len2);

    int ans = 0;
    for (int i = 0; i < size; i++) {
      int idx1 = len1 - i - 1 >=0 ? num1.charAt(len1 - i - 1) - '0' : 0;
      int idx2 = (len2 - i -1) >= 0 ? num2.charAt(len2 - i -1) - '0': 0;
      ans += (idx1 + idx2) * Math.pow(10, i);
    }
    return Integer.toString(ans);

  }

  /**
   * Super smart solution.
   * @source https://leetcode.com/problems/add-strings/discuss/90436/Straightforward-Java-8-main-lines-25ms
   */
  public String addStrings(String num1, String num2) {
    StringBuilder sb = new StringBuilder();
    int carry = 0;
    for(int i = num1.length() - 1, j = num2.length() - 1; i >= 0 || j >= 0 || carry == 1; i--, j--){
      int x = i < 0 ? 0 : num1.charAt(i) - '0';
      int y = j < 0 ? 0 : num2.charAt(j) - '0';
      sb.append((x + y + carry) % 10);
      carry = (x + y + carry) / 10;
    }
    return sb.reverse().toString();
  }

  public String addStringsM2(String num1, String num2) {
    StringBuilder sb = new StringBuilder();
    int len1 = num1.length(), len2 = num2.length();

    int carry = 0;
    for (int i = 0; i < len1 || i < len2 || carry == 1; i++) {
      int x = i > len1 - 1 ? 0 : num1.charAt(len1 - i - 1) - '0';
      int y = i > len2 - 1 ? 0 : num2.charAt(len2 - i - 1) - '0';
      sb.append((x + y + carry) % 10);
      carry = (x + y + carry) / 10; // 99 + 109 =208

    }

    return sb.reverse().toString();


  }


  @Test
  public void testAddStrings() {
    String num1 = "11", num2 = "123";
    Assert.assertEquals("134", addStringsM2(num1, num2));
  }
}
