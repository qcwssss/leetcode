package dfs2;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
  public List<List<Integer>> combine(int n, int k) {
    List<List<Integer>> res = new ArrayList<>();
    helper(res, new ArrayList<>(), k, n, 1);
    return res;

  }

  void helper(List<List<Integer>> res, List<Integer> list, int k, int n, int index) {
    if (list.size() == k) {
      res.add(new ArrayList<>(list));
    } else {
      for (int i = index; i <= n; i++) {
        list.add(i);
        helper(res, list, k, n, i + 1);
        list.remove(list.size() - 1);

      }
    }
  }
}
