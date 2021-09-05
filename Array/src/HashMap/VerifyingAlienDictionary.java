package HashMap;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

public class VerifyingAlienDictionary {

  /**
   * Approach 1: Compare adjacent words
   * @source https://leetcode.com/problems/verifying-an-alien-dictionary/solution/
   * @param words
   * @param order
   * @return
   */
  public boolean isAlienSorted(String[] words, String order) {
    int[] orderMap = new int[26];
    for (int i = 0; i < order.length(); i++) {
      orderMap[order.charAt(i) - 'a'] = i;
    }

    for (int i = 0; i < words.length - 1; i++) {

      for (int j = 0; j < words[i].length(); j++) {
        // If we do not find a mismatch letter between words[i] and words[i + 1],
        // we need to examine the case when words are like ("apple", "app").
        if (j >= words[i + 1].length()) return false;

        if (words[i].charAt(j) != words[i + 1].charAt(j)) {
          int currentWordChar = words[i].charAt(j) - 'a';
          int nextWordChar = words[i + 1].charAt(j) - 'a';
          if (orderMap[currentWordChar] > orderMap[nextWordChar]) return false;
          // if we find the first different letter and they are sorted,
          // then there's no need to check remaining letters
          else break;
        }
      }
    }

    return true;
  }

  public boolean isAlienSortedMine(String[] words, String order) {
        /* case 1: compare the first letter
            if ==, compare next
            else compare the rest, move pointer
        */
    HashMap<Character, Integer> map = new HashMap<>(26);
    for(int i = 0; i < order.length(); i++) {
      map.put(order.charAt(i), i);
    }

    int numOfWords = words.length;
    for(int i = 0; i < numOfWords - 1; i++) {
      for (int j = 0; j < words[0].length(); j++) {

        /*
        According to lexicographical rules "apple" > "app", because 'l' > '∅',
        where '∅' is defined as the blank character which is less than any other character.
         */
        if (j > words[i + 1].length() - 1) return false;

        if (words[i].charAt(j) != words[i + 1].charAt(j)) {
          if (map.get(words[i].charAt(j)) > map.get(words[i + 1].charAt(j))) {
            return false;
          } else break;
        }
      }
    }
    return true;

  }

  @Test
  public void testVerifying1() {
    String[] words = new String[]{"hello","leetcode"};
    String order = "hlabcdefgijkmnopqrstuvwxyz";
    Assert.assertTrue(isAlienSorted(words, order));
  }


  @Test
  public void testVerifyingMine() {
    String[] words = new String[]{"hello","leetcode"};
    String order = "hlabcdefgijkmnopqrstuvwxyz";
    Assert.assertTrue(isAlienSortedMine(words, order));
  }


  @Test
  public void testVerifyWord() {
    String[] words = new String[]{"word","world","row"};
    String order =  "worldabcefghijkmnpqstuvxyz";
    Assert.assertFalse(isAlienSortedMine(words, order));
  }

}
