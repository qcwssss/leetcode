package dfs;

public class FlattenBinaryTreeToLinkedList {

  // O(n) time
  // O(height) space
  public void flatten(TreeNode root) {
    if (root == null) return;

    flatten(root.left);
    flatten(root.right);
    // postorder
    TreeNode left = root.left;
    TreeNode right = root.right;
    root.left = null;

    TreeNode cur = root;
    root.right = left;
    while (cur.right != null) {
      cur = cur.right;
    }
    cur.right = right;

  }

  }
