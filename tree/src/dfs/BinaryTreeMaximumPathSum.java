package dfs;

import org.junit.Assert;
import org.junit.Test;

public class BinaryTreeMaximumPathSum {
  int curMax = Integer.MIN_VALUE;
  public int maxPathSum(TreeNode root) {
    helper(root);
    return curMax;

  }
  /*
   information pass,
     1
    / \
   2   3
   This subtree sum is 1+2+3 = 6, pass 6 to its parent.
   */
  private int helper(TreeNode root) {
    if (root == null) return 0;
    int left = Math.max(0, helper(root.left));
    int right = Math.max(0, helper(root.right));
    // update global variable
    curMax = Math.max(left + right + root.val, curMax);
    return Math.max(left, right) + root.val;

  }

  @Test
  public void testMaxPathSum() {
    TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3));
    Assert.assertEquals(6, maxPathSum(root));
  }
}
