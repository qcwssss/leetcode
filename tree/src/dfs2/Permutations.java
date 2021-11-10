package dfs2;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class Permutations {

  public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> res = new LinkedList<>();
    //Arrays.sort(nums);
    List<Integer> temp = new LinkedList<>();
    helper(res, nums, temp);
    return res;

  }

  void helper(List<List<Integer>> res, int[] nums, List<Integer> temp) {
    if (temp.size() == nums.length) {
      res.add(new LinkedList<>(temp));
      //return;
    } else {
      for (int i = 0; i < nums.length; i++) {
        if (temp.contains(nums[i])) continue;
        temp.add(nums[i]);
        helper(res, nums, temp);
        temp.remove(temp.size() - 1);
      }
    }
  }

  @Test
  public void testPermutation() {
    int[] nums = new int[]{1, 2, 3};
    System.out.println(permute(nums));
  }

  @Test
  public void testPermutation2() {
    int[] nums = new int[]{1, 1, 2};
    System.out.println(permute(nums));
  }
}
