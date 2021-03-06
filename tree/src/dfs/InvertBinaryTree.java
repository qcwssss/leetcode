package dfs;

public class InvertBinaryTree {
  public TreeNode invertTree(TreeNode root) {
    helper(root);
    return root;


  }

  private void helper(TreeNode root) {
    // mirror
    if (root == null) return;
    TreeNode temp = root.left;
    root.left = root.right;
    root.right = temp;
    helper(root.left);
    helper(root.right);

  }
}
