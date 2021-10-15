package dfs;

public class PathSum {

  public boolean hasPathSum(TreeNode root, int targetSum) {
    // root to leaf path, because of that we can subtract root val form sum.
    if (root == null) return false;
    if (root.left == null && root.right == null && targetSum == root.val) return true;
    return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);

  }


}
