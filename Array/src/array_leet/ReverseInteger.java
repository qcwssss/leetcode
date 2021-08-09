package array_leet;

public class ReverseInteger {
  public static int reverse(int x) {
    String xStr = Integer.toString(x);
    String revStr = new StringBuilder(xStr).reverse().toString();
    //int ans = Integer.parseInt(revStr);

    if (x >= 0) {
      int ans = Integer.parseInt(revStr);
      if (ans <= Math.pow(2, 31) - 1) {
        return ans;
      } else {
        return 0;
      }

    } else { // x < 0
      int ans = -Integer.parseInt(revStr.substring(0, revStr.length() -1));

      if (ans <= - Math.pow(2, 31)) {
        return 0;
      } else {
        return ans;
      }
    }



  }

  public static int reverseByDivide(int x) { // official solution
    int rev = 0;
    int pop = 0;
    while (x != 0) {
      pop = x%10;
      x = x/10;
      // int values between -2^31 (-2147483648) and 2^31-1 (2147483647).
      if (rev > Integer.MAX_VALUE/10) return 0;
      if (rev == Integer.MAX_VALUE/10 && pop > 7) return 0;

      if (rev < Integer.MIN_VALUE/10) return 0;
      if (rev == Integer.MIN_VALUE/10 && pop < -8) return 0;


      rev = rev*10 + pop;
    }
    return rev;


  }
}
