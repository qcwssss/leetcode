package array_leet;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RomanToInteger {

  public int romanToInt(String s) {
    if (s==null) return 0;

    int sum = 0;

    Map<Character, Integer> map = new HashMap<>();
    map.put('I', 1);
    map.put('V', 5);
    map.put('X', 10);
    map.put('L', 50);
    map.put('C', 100);
    map.put('D', 500);
    map.put('M', 1000);

    for(int i = 0; i < s.length() -1; i++) {
      int cur = map.get(s.charAt(i));
      int next = map.get(s.charAt(i + 1));

      if ( cur < next ) {
        sum -= cur;
      } else {
        sum += cur;
      }
    }

    sum += map.get(s.charAt(s.length() -1));
    return sum;

  }

  public static void main(String[] args) {
    String s58 = "LVIII";
    String s1994 = "MCMXCIV";
    System.out.println("III: " + new RomanToInteger().romanToInt("III"));
    System.out.println(s58 +": " + new RomanToInteger().romanToInt(s58));
    System.out.println(s1994 +": " + new RomanToInteger().romanToInt(s1994));

  }

}
