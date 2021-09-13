package String;

import org.junit.Assert;
import org.junit.Test;

public class AddBinary {

  public String addBinary(String a, String b) {
    StringBuilder sum = new StringBuilder();
    int n1 = a.length(), n2 = b.length();
    for (int i = 0, j = 0; i < n1 || j < n2; i++, j++) {
      int carry = 0;

      int x = i < n1 ? a.charAt(n1 - 1 - i) - '0' : 0;
      int y = j < n2 ? a.charAt(n2 - 1 - j) - '0' : 0;
      if (x + y > 1) {
        carry = 1;
        sum.append(0);
      } else {
        sum.append(x + y);
      }
      sum.append(carry);
    }
    return sum.toString();

  }

  @Test
  public void testAddBinary() {
    String num1 = "11", num2 = "1";
    Assert.assertEquals("100", addBinary(num1, num2));
  }

}
