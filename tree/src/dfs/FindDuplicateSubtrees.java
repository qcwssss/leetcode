package dfs;

import org.junit.Test;

public class FindDuplicateSubtrees {

  /**
   * https://leetcode.com/problems/find-duplicate-subtrees/discuss/106011/Java-Concise-Postorder-Traversal-Solution
   * @param root
   * @return
   */
  String preorder(TreeNode root) {
    if (root == null) return "#";

    String left = preorder(root.left);
    String sequence = root.val + "," + left + "," + preorder(root.right);
    return sequence;
  }

  @Test
  public void testPreorderString() {
    TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3));
    System.out.println(preorder(root));
  }
}
