package dfs;

import org.junit.Assert;
import org.junit.Test;

public class CountGoodNodesInBinaryTree {
  int count = 0;
  public int goodNodes(TreeNode root) {
    if (root == null) return 0;

    helper(root, Integer.MIN_VALUE);
    return count;
  }

  private void helper(TreeNode node, int max) {
    if (node == null) return;

    if (node.val >= max) count++;
    int larger = Math.max(node.val, max);
    helper(node.left, larger);
    helper(node.right, larger);

  }

  @Test
  public void testCount() {
    TreeNode root = new TreeNode(3, new TreeNode(1), new TreeNode(4));
    root.left.left = new TreeNode(3);
    root.right.right = new TreeNode(5);
    root.right.left = new TreeNode(1);
    Assert.assertEquals(4, goodNodes(root));

  }
}
