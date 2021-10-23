package dfs;

public class EasyDepth {
  public int minDepth(TreeNode root) {
    if (root == null) return 0;
    if (root.left == null) return minDepth(root.right) + 1;
    if (root.right == null) return minDepth(root.left) + 1;

    int left = minDepth(root.left) + 1;
    int right = minDepth(root.right) + 1;
    return Math.min(left, right);
  }

  public int maxDepth(TreeNode root) {
    if (root == null) return 0;
    int left = 1 + maxDepth(root.left);
    int right = 1 + maxDepth(root.right);
    return Math.max(left, right);
  }
}
