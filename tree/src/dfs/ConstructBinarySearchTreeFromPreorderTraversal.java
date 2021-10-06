package dfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ConstructBinarySearchTreeFromPreorderTraversal {

  /**
   * Definition for a binary tree node.
   * public class TreeNode {
   * int val;
   * TreeNode left;
   * TreeNode right;
   * TreeNode() {}
   * TreeNode(int val) { this.val = val; }
   * TreeNode(int val, TreeNode left, TreeNode right) {
   * this.val = val;
   * this.left = left;
   * this.right = right;
   * }
   * }
   */
  public TreeNode bstFromPreorder(int[] preorder) {
    Queue<Integer> q = new LinkedList<>();
    for (int i : preorder) {
      q.offer(i);
    }
    return helper(q, Integer.MIN_VALUE, Integer.MAX_VALUE);

  }

  private TreeNode helper(Queue<Integer> queue, int lower, int upper) {
    if (queue.isEmpty()) return null;
    int val = queue.peek();
    if (val < lower || val > upper) return null;
    queue.poll();
    TreeNode root = new TreeNode(val);
    root.left = helper(queue, lower, val);
    root.right = helper(queue, val, upper);

    return root;

  }
}
