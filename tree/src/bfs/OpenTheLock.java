package bfs;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class OpenTheLock {

  public int openLock2(String[] deadends, String target) {
    Set<String> begin = new HashSet<>(), end = new HashSet<>();
    Set<String> deads = new HashSet<>(Arrays.asList(deadends));
    begin.add("0000");
    end.add(target);
    int level = 0; // return optimal result
    while (!begin.isEmpty() && !end.isEmpty()) {
      Set<String> temp = new HashSet<>();
      // check if cur string is the target
      for (String s : begin) {
        if (end.contains(s)) return level;
        if (deads.contains(s)) continue;
        deads.add(s);
        //char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < s.length(); i++) {
          char c = sb.charAt(i);
          String s1 = sb.substring(0, i) + (c == '9' ? 0 : c - '0' + 1) + sb.substring(i + 1);
          String s2 = sb.substring(0, i) + (c == '0' ? 9 : c - '0' - 1) + sb.substring(i + 1);
          if (!deads.contains(s1)) temp.add(s1);
          if (!deads.contains(s2)) temp.add(s2);

        }
      }
      level++;
      begin = end;
      end = temp;

    }
    return -1;


  }

  public int openLock(String[] deadends, String target) {
    Set<String> deads = new HashSet<>(Arrays.asList(deadends));
    Set<String> begin = new HashSet<>(), end = new HashSet<>();
    begin.add("0000");
    end.add(target);

    // BFS
    int level = 0;
    while (!begin.isEmpty() && !end.isEmpty()) {
      Set<String> temp = new HashSet<>();
      for (String s : begin) {
        if (end.contains(s)) return level;
        if (deads.contains(s)) continue;
        deads.add(s); // visited

        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < 4; i++) {
          char c = sb.charAt(i);
          int c1 = c == '9' ? 0 : c - '0' + 1; // +1
                // c == '9' ? 0 : c - '0' + 1
          int c2 = c == '0' ? 9 : c - '0' - 1; // -1
              //   c == '0' ? 9 : c - '0' - 1
          String s1 = sb.substring(0, i) + c1 + sb.substring(i+1);
          String s2 = sb.substring(0, i) + c2 + sb.substring(i+1);

          if (!deads.contains(s1)) temp.add(s1);
          if (!deads.contains(s2)) temp.add(s2);
        }
      }
      level += 1;
      begin = end;
      end = temp;

    }

    return -1;
  }

  @Test
  public void testLock() {
    String t1 = "0009";
    String[] d1 = new String[] {"8888"};
    openLock(d1, t1);
  }

}
