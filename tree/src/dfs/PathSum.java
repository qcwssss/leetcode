package dfs;

public class PathSum {

  int target;
  public boolean hasPathSum(TreeNode root, int targetSum) {
    if (root == null) return false;
    target = targetSum;
    return targetSum == sum(root, 0);


  }

  private int sum(TreeNode root, int count) {
    if (root == null || count == target) return count;
    if (root.left != null) sum(root.left, count + root.left.val);
    if (root.right != null) sum(root.right, count + root.right.val);
    return count;

  }
}
