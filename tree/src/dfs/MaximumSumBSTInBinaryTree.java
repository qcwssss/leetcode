package dfs;

import org.junit.Test;

public class MaximumSumBSTInBinaryTree {

  int maxSum;

  public int maxSumBST(TreeNode root) {
    if (root == null) return 0;

    sumTree(root);
    return maxSum;

  }

  private int sumTree(TreeNode root) {
    if (root == null) return 0;

    int leftSum = sumTree(root.left);
    int rightSum = sumTree(root.right);
    if (isBST(root, Integer.MIN_VALUE)) {
      maxSum = leftSum + rightSum + root.val;
    }
    return maxSum;
  }

  private boolean isBST(TreeNode root, int prev) {
    if (root == null) return true;

    boolean isLeftBST = isBST(root.left, prev);
    // inorder
    if (!isLeftBST) return false;
    if (prev >= root.val) return false;
    else prev = root.val;
    return isBST(root.right, prev);


  }

  @Test
  public void testDfsString() {
    TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3));

    System.out.println(sumTree(root));
  }
}
