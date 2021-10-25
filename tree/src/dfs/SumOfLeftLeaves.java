package dfs;

public class SumOfLeftLeaves {

  public int sumOfLeftLeaves(TreeNode root) {
    return helper(root, false);
  }

  private int helper(TreeNode n, boolean isLeft) {
    if (n == null) return 0;
    // check if cur node is left leaf
    if (n.left == null && n.right == null && isLeft) {
      return n.val;
    }
    return helper(n.left, true) + helper(n.right, false);
  }

}
