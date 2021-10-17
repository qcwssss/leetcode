package dfs;

import org.junit.Assert;
import org.junit.Test;

public class LongestZigZagPathInABinaryTree {

  int max = 0;
  public int longestZigZag(TreeNode root) {
    int[] res = new int[2]; // [leftSum, rightSum]
    helper(root);
    return max == 0 ? 0 : max -1;

  }

  private int[] helper(TreeNode node) {
    int[] pair = new int[2];
    if (node == null) return pair;
    int[] left  = helper(node.left);
    int[] right  = helper(node.right);
    pair[0] = left[1] + 1; // left sum takes the  left children's right sum
    pair[1] = right[0] + 1; // right sum
    max = Math.max(max, Math.max(pair[0], pair[1]));
    return pair;

  }

  @Test
  public void testZigSum1() {
    TreeNode root = new TreeNode(1, new TreeNode(1), new TreeNode(1));
    root.left.right = new TreeNode(1, new TreeNode(1), new TreeNode(1));
    TreeNode r3 = root.left.right;
    r3.left.right = new TreeNode(1);

    Assert.assertEquals(4, longestZigZag(root));
  }

  @Test
  public void testZigSum2() {
    TreeNode root = new TreeNode(1);
    root.right = new TreeNode(1, new TreeNode(1), new TreeNode(1));
    TreeNode r3 = root.right.right;
    r3.right = new TreeNode(1);
    r3.left = new TreeNode(1, null, new TreeNode(1));
    r3.left.right.right = new TreeNode(1);
    Assert.assertEquals(3, longestZigZag(root));
  }

  public int longestZigZag_1(TreeNode root) {
    int leftPath = maxPath(root, true);
    int rightPath = maxPath(root, false);
    return Math.max(leftPath, rightPath);

  }

  private boolean direct;
  private int maxPath(TreeNode root, boolean right) {
    this.direct = right;
    TreeNode cur = root;
    int count = 0;
    while (true) {
      if (cur == null) break;
      if (right) {
        cur = cur.right;
        count += 1;
        direct = false;
      } else {
        cur = cur.left;
        count += 1;
        direct = true;
      }
    }
    return count--;
  }
}
