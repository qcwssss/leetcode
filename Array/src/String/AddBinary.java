package String;

import org.junit.Assert;
import org.junit.Test;

public class AddBinary {

  public String addBinary(String a, String b) {
    StringBuilder sb = new StringBuilder();
    int n1 = a.length() - 1, n2 = b.length() - 1;
    int carry = 0;

    for (int i = 0, j = 0; i <= n1 || j <= n2; i++, j++) {
      int sum = carry;
      int x = n1 - i >= 0 ? a.charAt(n1 - i) - '0' : 0;
      int y = n2 - j >= 0 ? b.charAt(n2 - j) - '0' : 0;
      sum += x + y;
      carry = sum / 2;
      sb.append(sum % 2);

    }
    if (carry != 0) sb.append(carry);
    return sb.reverse().toString();

  }

  @Test
  public void testAddBinary() {
    String num1 = "11", num2 = "1";
    Assert.assertEquals("100", addBinary(num1, num2));
  }


  @Test
  public void testAddBinary2() {
    String num1 = "1010", num2 = "1011";
    Assert.assertEquals("10101", addBinary(num1, num2));
  }

}
