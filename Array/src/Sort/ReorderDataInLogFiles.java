package Sort;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

import static org.junit.Assert.assertEquals;

public class ReorderDataInLogFiles {

  public String[] reorderLogFilesMine(String[] logs) {
    /*
    identify letter log, digit log
    put the letter log at the front, and sorted lexicographically
    put the digit log behind
    */
    /*
    identify letter log, digit log
    put the letter log at the front, and sorted lexicographically
    put the digit log behind
    */

    /*
    if (arr[1] is word, letterArr.add(str)
    else digitArr.add(str)

    sort letterArr
    put all items in letterArr to res[], then copy from digitArr
     */
    Comparator<String> myCmp =
        new Comparator<String>() {
          @Override
          public int compare(String o1, String o2) {
            String[] split1 = o1.split(" ", 2);
            String[] split2 = o2.split(" ", 2);

            boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
            boolean isDigit2 = Character.isDigit(split2[1].charAt(0));
            // case 1). both are letters
            if (!isDigit1 && isDigit2) {
              //  sorted lexicographically by their contents
              int cmp = split1[1].compareTo(split2[1]);
              if (cmp != 0) return cmp;
              // If contents are the same, sort them by their identifiers.
              return split1[0].compareTo(split2[0]);
            }
            // case 2). only one log is letter
            if (!isDigit1 && isDigit2) {
              return -1;
            } else if (isDigit1 && !isDigit2) {
              return 1;
            } else {
              // case 3). both are digit
              return 0;
            }
          }
        };

    Arrays.sort(logs, myCmp);
    return logs;
  }

  /**
   * @source https://leetcode.com/problems/reorder-data-in-log-files/solution/ Approach 1:
   *     Comparator
   */
  public String[] reorderLogFiles(String[] logs) {

    /*
        int compare(T o1, T o2) {
        if (o1 < o2)
            return -1;
        else if (o1 == o2)
            return 0;
        else // o1 > o2
            return 1;
    }
         */

    Comparator<String> myComp =
        new Comparator<String>() {
          @Override
          public int compare(String log1, String log2) {
            // split each log into two parts: <identifier, content>
            String[] split1 = log1.split(" ", 2);
            String[] split2 = log2.split(" ", 2);

            boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
            boolean isDigit2 = Character.isDigit(split2[1].charAt(0));

            // case 1). both logs are letter-logs
            if (!isDigit1 && !isDigit2) {
              // first compare the content
              int cmp = split1[1].compareTo(split2[1]);
              if (cmp != 0) return cmp;
              // logs of same content, compare the identifiers
              return split1[0].compareTo(split2[0]);
            }

            // case 2). one of logs is digit-log
            if (!isDigit1 && isDigit2) // 1 is not digit, 2 is. letter goes first
              // the letter-log comes before digit-logs
              return -1;
            else if (isDigit1 && !isDigit2) return 1;
            else
              // case 3). both logs are digit-log
              return 0;
          }
        };

    Arrays.sort(logs, myComp);
    return logs;
  }

  @Test
  public void testReorderLogs() {
    String[] log1 = {
      "dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig", "let3 art zero"
    };
    String[] expected1 = {
      "let1 art can", "let3 art zero", "let2 own kit dig", "dig1 8 1 5 1", "dig2 3 6"
    };
    String[] actual1 = reorderLogFiles(log1);
    String[] actual1b = reorderLogFilesMine(log1);

    assertEquals(expected1, actual1);
    assertEquals(expected1, actual1b);

  }
}
