package leetcode;

import java.util.LinkedList;

public class Solution {
  public static String longestPalindrome(String s) {
    LinkedList<Character> arr = new LinkedList<>();
    // reverse string, then compare
    int headPtr = 0;
    int tailPtr = s.length() - 1;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(headPtr) == s.charAt(tailPtr) ){
        arr.addFirst(s.charAt(headPtr));
        arr.add(s.charAt(tailPtr));
      }
      headPtr++;
      tailPtr--;
    }
    return String.valueOf(arr);
  }

    public static String longestPalindrome2(String s) {
      String reverse =  new StringBuilder(s).reverse().toString();
      int ptr = 0;
      int idx = 0;
      LinkedList<Integer> slice = new LinkedList<>();
      while (idx < s.length()) {
        while (ptr < s.length()) {
          if(s.charAt(idx) != reverse.charAt(ptr)) {
            ptr++;
          } else {
            slice.add(idx);
            idx++;
            ptr++;
            break;
          }
        }
        ptr = 0;

      }
      //return s.substring(slice.get(0), slice.remove());
      return String.valueOf(slice);

    }
}
