package dfs2;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class Subsets {
  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> res = new LinkedList<>();
    backtrack(res, nums, new LinkedList<>(), 0);
    return res;
  }

  private void backtrack(List<List<Integer>> res,int[] nums, List<Integer> temp, int start ){
    res.add(new LinkedList<>(temp));
    for (int i = start; i < nums.length; i++) {
      temp.add(nums[i]);
      backtrack(res, nums, temp, i + 1);
      temp.remove(temp.size() - 1);
    }
  }

  @Test
  public void testSubsets() {
    int[] nums = new int[] {1, 2, 3};
    System.out.println(subsets(nums));
  }

}
