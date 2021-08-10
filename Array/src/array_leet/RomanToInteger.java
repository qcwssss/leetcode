package array_leet;

import java.util.Map;
import java.util.Scanner;

public class RomanToInteger {

  public int romanToInt(String s) {
    if (s==null) return 0;

    int sum = 0;

    Map<Character, Integer> map =
    for(int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      int[] num = new int[s.length()];

      switch(c) {
        case 'I':
          num[i] =1;
          break;

        case 'V':
          num[i] = 5;
          break;

        case 'X':
          num[i] = 10;
          break;

        case 'L':
          num[i] = 50;
          break;

        case 'C':
          num[i] = 100;
          break;

        case 'D':
          num[i] = 500;
          break;

        case 'M':
          num[i] = 1000;
          break;

        default:
          break;

      }
    }
    return sum;

  }

  public static void main(String[] args) {
    System.out.println(new RomanToInteger().romanToInt("III"));
  }

}
