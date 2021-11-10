package dfs2;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SubsetsII {

  //Subsets II
  public List<List<Integer>> subsetsWithDup(int[] nums) {
    List<List<Integer>> res = new LinkedList<>();
    Arrays.sort(nums);
    //backtrack(res, nums, new LinkedList<>(), 0);
    backtrack(res, nums, new LinkedList<>(), 0, true);

    return res;
  }

  // iterative
  void backtrack(List<List<Integer>> res, int[] nums, List<Integer> temp, int start) {
    res.add(new LinkedList<>(temp));
    for (int i = start; i < nums.length; i++) {
      if (i != start && nums[i] == nums[i - 1]) continue; // check duplicate
      temp.add(nums[i]); // add current value
      backtrack(res, nums, temp, i + 1);
      temp.remove(temp.size() - 1); // don't add current

    }
  }

  // recursive
  void backtrack(List<List<Integer>> res, int[] nums, List<Integer> temp, int start, boolean isPicked) {
    // isPicked -> is current value added to subset?
    if (start >= nums.length) {
      res.add(new LinkedList<>(temp));
      return;
    }
    backtrack(res, nums, temp, start + 1, false);
    if (start > 0 && nums[start - 1] == nums[start] && !isPicked) return;
    temp.add(nums[start]);
    backtrack(res, nums, temp, start + 1, true);
    temp.remove(temp.size() - 1);
    // temp is a pointer, if temp is modified in recursive call, temp will remain modified after returns


  }

  @Test
  public void testSubsetsII() {
    int[] nums = new int[]{1, 2};
    System.out.println(subsetsWithDup(nums));
  }
}
