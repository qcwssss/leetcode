package dfs;

import org.junit.Assert;
import org.junit.Test;

public class BinaryTreeMaximumPathSum {

  public int maxPathSum(TreeNode root) {
    return helper(root, 0);

  }

  private int helper(TreeNode root, int curMax) {
    if (root == null) return curMax;
    curMax = Math.max(root.val + curMax, curMax);
    int left = helper(root.left, curMax);
    int right = helper(root.right, curMax);
    int lrSum = left + right - root.val;
    return Math.max(lrSum, Math.max(left, right) );

  }

  @Test
  public void testMaxPathSum() {
    TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3));
    Assert.assertEquals(5, maxPathSum(root));
  }
}
