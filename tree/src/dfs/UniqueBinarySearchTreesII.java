package dfs;

import java.util.LinkedList;
import java.util.List;

public class UniqueBinarySearchTreesII {

  public List<TreeNode> generateTrees(int n) {
    if (n == 0) return new LinkedList<>();
    return helper(0, n);
  }

  private List<TreeNode> helper(int start, int end) {
    List<TreeNode> res = new LinkedList<>();
    if (start > end) res.add(null);
    for (int i = start; i <= end; i++) {
      List<TreeNode> leftList = helper(start, i - 1);
      List<TreeNode> rightList = helper(i + 1, end);
      for (TreeNode left : leftList) {
        for (TreeNode right : rightList) {
          TreeNode root = new TreeNode(i);
          root.left = left;
          root.right = right;
          res.add(root);
        }
      }
    }
    return res;
  }
}
