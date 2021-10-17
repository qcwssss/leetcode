package dfs;

public class LongestZigZagPathInABinaryTree {

  int max = 0;
  public int longestZigZag(TreeNode root) {
    int[] res = new int[2]; // [leftSum, rightSum]
    helper(root);
    return max;
  }

  private int[] helper(TreeNode node) {
    int[] pair = new int[2];
    if (node == null) return pair;
    int[] left  = helper(node.left);
    int[] right  = helper(node.right);
    pair[0] = left[1] + 1; // left sum takes the  left children's right sum
    pair[1] = right[0] + 1; // right sum
    max = Math.max(pair[0], pair[1]);
    return pair;

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
