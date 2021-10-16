package dfs;

import java.util.LinkedList;
import java.util.List;

public class PathSumII {
  List<List<Integer>> res = new LinkedList<>();

  public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
    List<Integer> path = new LinkedList<>();
    dfs(root, targetSum, path);
    return res;

  }

  private void dfs(TreeNode root, int sum, List<Integer> path) {
    if (root == null) return;
    path.add(root.val);

    // find the path sum
    if (root.left == null && root.right == null && root.val == sum) {
      res.add(path);
      return;
    }

    if (root.left != null) {
      dfs(root.left, sum - root.val, path);
    }

    if (root.right != null) {
      dfs(root.right, sum - root.val, path);
    }
  }

}
