package dfs;

public class ValidateBinarySearchTree {

  // approach #1: pass upper and lower bound
  public boolean isValidBST(TreeNode root) {
    return validHelper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }

  private boolean validHelper(TreeNode node, int lower, int upper) {
      if (node == null) return true;
      if (upper != Integer.MAX_VALUE && node.val >= upper) return false;
      if (lower != Integer.MIN_VALUE && node.val <= lower) return false;
      return validHelper(node.left, lower, node.val) && validHelper(node.right, node.val, upper);
  }
}
