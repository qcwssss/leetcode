package Sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

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
    ArrayList<String> letterArr = new ArrayList<>();
    ArrayList<String> digitArr = new ArrayList<>();
    for (String str : logs) {
      String[] arr = str.split(" ");
      // if (String. arr[1])
      /*
      if (arr[1] is word, letterArr.add(str)
      else digitArr.add(str)

      sort letterArr
      put all items in letterArr to res[], then copy from digitArr
       */

    }
    String res[] = new String[logs.length];
    return res;
  }

  /**
   * @source https://leetcode.com/problems/reorder-data-in-log-files/solution/
   * Approach 1: Comparator
   */
  public String[] reorderLogFiles(String[] logs) {

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
            if (!isDigit1 && isDigit2)
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
}
