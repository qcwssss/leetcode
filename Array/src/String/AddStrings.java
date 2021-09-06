package String;

import org.junit.Assert;
import org.junit.Test;

public class AddStrings {

  public String addStrings(String num1, String num2) {
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

  @Test
  public void testAddStrings() {
    String num1 = "11", num2 = "123";
    Assert.assertEquals("134", addStrings(num1, num2));
  }
}
