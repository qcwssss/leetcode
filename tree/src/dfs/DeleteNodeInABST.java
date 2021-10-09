package dfs;

import dfs.TreeNode;

public class DeleteNodeInABST {

  public TreeNode deleteNode(TreeNode root, int key) {
    if (root == null) return null;
    else if (root.val < key) root.right = deleteNode(root.right, key);
    else if (root.val > key) root.left = deleteNode(root.left, key);

    // key found
    // one side is null
    else if (root.left == null) return root.right;
    else if (root.right == null) return root.left;
    // left and right both not null
    else {
      root.val = findMin(root.right);
      root.right = deleteNode(root.right, root.val);

    }
    return root;
  }

  private int findMin(TreeNode node) {
    while (node.left != null) {
      node = node.left;
    }
    return node.val;
  }
}
