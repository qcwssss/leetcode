package dfs;

public class ValidateBinarySearchTree {

  // approach #1: pass upper and lower bound
  public boolean isValidBST(TreeNode root) {
    return validHelper(root, null, null);
  }

  private boolean validHelper(TreeNode node, Integer lower, Integer upper) {
      if (node == null) return true;
      if (upper != null && node.val >= upper) return false;
      if (lower != null && node.val <= lower) return false;
      return validHelper(node.left, lower, node.val) && validHelper(node.right, node.val, upper);
  }
}
