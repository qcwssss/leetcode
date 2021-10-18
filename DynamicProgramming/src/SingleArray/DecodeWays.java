package SingleArray;

public class DecodeWays {

  public int numDecodings(String s) {
    int count = 1;
    for(int i = 1; i < s.length(); i++) {
      if (s.charAt(i-1) == '0') {
        String twoChars = String.valueOf(s.charAt(i - 1) + s.charAt(i));
        int dual = Integer.parseInt(twoChars);
        if (dual <= 26) count++;
      }
    }

    return count;
  }
}
