package dfs;

public class PathSum {

  public boolean hasPathSum(TreeNode root, int targetSum) {
    if (root == null) return false;
    if (root.left == null && root.right == null && targetSum == root.val) return true;
    return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);

  }

  public boolean hasPathSum2(TreeNode root, int sum) {
    if(root == null) return false;
    if(root.left == null && root.right == null) return sum == root.val;
    return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
  }

}
