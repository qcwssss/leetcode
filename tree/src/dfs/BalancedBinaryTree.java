package dfs;

public class BalancedBinaryTree {
  // O(n^2) time
  public boolean isBalanced1(TreeNode root) {
    if (root == null) return true;
    int left = depth(root.left);
    int right = depth(root.right);
    if (Math.abs(left - right) > 1) return false;
    return isBalanced(root.left) && isBalanced(root.right);

  }

  private int depth(TreeNode root) {
    if (root == null) return 0;
    int left = depth(root.left);
    int right = depth(root.right);
    return Math.max(left, right) + 1;

  }

  // O(n) time
  public boolean isBalanced(TreeNode root) {
    if (root == null) return true;
    return getDepth(root) != -1;

  }
  // count depth
  private int getDepth(TreeNode root) {
    if (root == null) return 0;
    int left = getDepth(root.left);
    int right = getDepth(root.right);
    // check left right difference
    if (Math.abs(left - right)> 1 || left == -1 || right == -1) {
      return -1;
    }
    return Math.max(left, right) + 1;

  }
}
