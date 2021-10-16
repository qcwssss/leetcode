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

    //Base case: reach the leaf
    if (root.left == null && root.right == null && root.val == sum) {
      // find the path sum
      // res.add(path);
      // line 23 added an adress to res, when backtracking the path in res will be modified.
      // we have to make a deep copy of path into res

      res.add(new LinkedList<>(path));

    } else {
      dfs(root.left, sum - root.val, path);
      dfs(root.right, sum - root.val, path);
    }
    // Backtrack
    path.remove(path.size() -1);

  }

  public static void main (String[] args) {
    TreeNode root = new TreeNode(5, new TreeNode(4), new TreeNode(8));
    root.right = new TreeNode(8, new TreeNode(13), new TreeNode(4));
    root.right.right.left = new TreeNode(5);
    root.right.right.right = new TreeNode(1);
    root.left.left = new TreeNode(11, new TreeNode(7), new TreeNode(2));

    PathSumII p2 = new PathSumII();
    List<List<Integer>> ans = p2.pathSum(root, 22);
    System.out.println(ans);
  }


}
