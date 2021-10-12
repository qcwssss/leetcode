package dfs;

import java.util.LinkedList;
import java.util.List;

public class UniqueBinarySearchTreesII {

  public List<TreeNode> generateTrees(int n) {
    if (n == 0) return new LinkedList<>();
    return helper(1, n); // 1 to n
  }

  List<TreeNode> helper(int start, int end) {
    List<TreeNode> res = new LinkedList<>();
    if (start > end) res.add(null);

    // let each number be the root node
    for (int i = start; i <= end; i++) {
      List<TreeNode> leftList = helper(start, i - 1);
      List<TreeNode> rightList = helper(i + 1, end);
      // cartesian product of left and right
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

  public static void main(String[] args) {
    UniqueBinarySearchTreesII u2 = new UniqueBinarySearchTreesII();
    List<TreeNode> ans_3 = u2.generateTrees(3);
    for (TreeNode n : ans_3) {
      System.out.println(n);

    }
  }
}
