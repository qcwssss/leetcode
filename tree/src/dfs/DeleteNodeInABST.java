package dfs;

import dfs.TreeNode;

public class DeleteNodeInABST {

  public TreeNode deleteNode(TreeNode root, int key) {
    if (root == null) return null;
    else if (root.val < key) root.right = deleteNode(root.right, key);
    else if (root.val > key) root.left = deleteNode(root.left, key);

    // key found
    // one side is null
    if (root.left == null) return root.right;
    else if (root.right == null) return root.left;
    // left and right both not null
    else {
      int rightMin = findMin(root.right);
      root.val = rightMin;
      root.right = deleteNode(root.right, rightMin);

    }
    return root;
  }

  private int findMin(TreeNode node) {
    int min = node.val;
    while (node.left != null) {
      node = node.left;
      min = node.val;
    }
    return min;
  }
}
