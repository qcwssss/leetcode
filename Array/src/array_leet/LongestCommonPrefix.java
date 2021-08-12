package array_leet;

public class LongestCommonPrefix {
  public String longestCommonPrefix1(String[] strs) {
    String prefix = strs[0];
    if (strs == null) return  "";
    for(int i = 1; i < strs.length; i++) {
      while(strs[i].indexOf(prefix) != 0) {
        prefix = prefix.substring(0, prefix.length() -1);
      }
    }
    return prefix;

  }

  public static String longestCommonPrefix2(String[] strs) {
    if (strs == null || strs.length == 0) return "";
    for (int i = 0; i < strs[0].length() ; i++){
      char c = strs[0].charAt(i);
      for (int j = 1; j < strs.length; j ++) {
        if (i == strs[j].length() || strs[j].charAt(i) != c)
          return strs[0].substring(0, i);
      }
    }
    return strs[0];
  }

  public static void main(String[] args) {
    String[] s1 = {"flower","flow","flight"};
    String[] s0 = {""};
    String[] s2 = {"a", "b"};

    String ans = LongestCommonPrefix.longestCommonPrefix2(s1);
    String ans0 = LongestCommonPrefix.longestCommonPrefix2(s0);

    System.out.println(ans);
    System.out.println("ans0: " + ans0);
    System.out.println("ans02: " + LongestCommonPrefix.longestCommonPrefix2(s2));


  }
}

