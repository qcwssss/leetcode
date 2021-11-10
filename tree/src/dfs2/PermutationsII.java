package dfs2;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PermutationsII {

  public List<List<Integer>> permuteUnique(int[] nums) {
    List<List<Integer>> res = new LinkedList<>();
    Arrays.sort(nums);
    boolean[] visited = new boolean[nums.length];
    helper(res, nums, new LinkedList<>(), visited);
    return res;

  }

  void helper(List<List<Integer>> res, int[] nums, List<Integer> temp, boolean[] visited) {
    if (temp.size() == nums.length) {
      res.add(new LinkedList<>(temp));
    } else {
      for (int i = 0; i < nums.length; i++) {
        if (visited[i]) continue; // don't pick the same value twice
        // In > 1st iteration, where the first dup is not visited
        if (i > 0 && nums[i] == nums[i-1] && !visited[i-1]) continue;
        temp.add(nums[i]);
        visited[i] = true;
        helper(res, nums, temp, visited);
        temp.remove(temp.size() - 1);
        visited[i] = false;
      }
    }
  }

  @Test
  public void testPermutation() {
    int[] nums = new int[]{1, 2, 3};
    System.out.println(permuteUnique(nums));
  }

  @Test
  public void testPermutation2() {
    int[] nums = new int[]{1, 1, 2};
    System.out.println(permuteUnique(nums));
  }
}
