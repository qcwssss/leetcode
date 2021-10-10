package dfs;

import java.util.Deque;
import java.util.LinkedList;

public class ValidateBinarySearchTree {

  // approach #1: pass upper and lower bound
  public boolean isValidBST1(TreeNode root) {
    return validHelper(root, null, null);
  }

  private boolean validHelper(TreeNode node, Integer lower, Integer upper) {
    if (node == null) return true;
    if (upper != null && node.val >= upper) return false;
    if (lower != null && node.val <= lower) return false;
    return validHelper(node.left, lower, node.val) && validHelper(node.right, node.val, upper);
  }

  // approach #2: inoreder recursive
  // inorder traversal for a BST is an array in ascending order
  long prev = Long.MIN_VALUE;
  public boolean isValidBST2(TreeNode root) {
    if (root == null) return true;

    boolean left = isValidBST(root.left);
    if (!left) return false;

    if (prev >= root.val) return false; // prev always smaller than root
    prev = root.val;
    return isValidBST(root.right);

  }

  // approach #3: inoreder iterative
  public boolean isValidBST(TreeNode root) {
    Deque<TreeNode> stack = new LinkedList<>();
    TreeNode cur = root;
    TreeNode prev = null;

    while (root != null || !stack.isEmpty()) {
      // exhaust left children
      while (root != null) {
        stack.push(root);
        root = root.left;
      }
      root = stack.pop();
      if (prev != null && prev.val >= root.val) return false;
      prev = root;
      root = root.right;
    }

    return true;
  }
}
