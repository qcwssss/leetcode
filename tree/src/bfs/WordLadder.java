package bfs;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class WordLadder {
  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    // BFS
    Set<String> listSet = new HashSet<>(wordList);
    if (!listSet.contains(endWord)) return 0;

    Deque<String> queue = new LinkedList<>();
    queue.offer(beginWord);
    int step = 1, N = beginWord.length();
    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        String cur = queue.poll();
        // iterate each letter of cur word
        for (int j = 0; j < N; j++) {
          for (char letter = 'a'; letter <= 'z'; letter++) {
            StringBuilder next = new StringBuilder(cur);
            next.setCharAt(j, letter);
            String nextStr = next.toString();
            if (listSet.contains(nextStr)) {
              if (nextStr.equals(endWord)) return step + 1;
              listSet.remove(nextStr); // avoid infinite loop
              queue.offer(nextStr);
            }
          }
        }
      }
      if (queue.isEmpty()) return 0;
      step += 1;
    }
    return step;
  }

  @Test
  public void testLadder() {
    String begin = "hit", end = "cog";

    String[] listStr = {"hot", "dot", "dog", "lot", "log", "cog"};
    List<String> list = new ArrayList<>();            //["hot","dot","dog","lot","log","cog"]
    for (String word : listStr) {
      list.add(word);
    }
    Assert.assertEquals(5, ladderLength(begin, end, list));
  }

}
