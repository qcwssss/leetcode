package dfs;

public class LongestZigZagPathInABinaryTree {

  private boolean direct;

  public int longestZigZag(TreeNode root) {
    int leftPath = maxPath(root, true);
    int rightPath = maxPath(root, false);
    return Math.max(leftPath, rightPath);

  }

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
