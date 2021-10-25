package dfs;

import org.junit.Assert;
import org.junit.Test;

public class SumRootToLeafNumbers {

  public int sumNumbers(TreeNode root) {
    return sumHelper(root, 0);
  }
  // pass sum to next level
  private int sumHelper(TreeNode node, int sum) {
    if (node == null) return 0;
    if (node.left == null && node.right == null) return sum * 10 + node.val;
    int left = sumHelper(node.left, sum * 10 + node.val);
    int right = sumHelper(node.right, sum * 10 + node.val);
    return left + right;
  }

  @Test
  public void testSum() {
    //    1, 2, 3
    TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3));
    Assert.assertEquals(25, sumNumbers(root));
  }
}
