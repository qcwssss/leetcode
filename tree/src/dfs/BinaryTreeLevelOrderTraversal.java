package dfs;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {

  public List<List<Integer>> levelOrder(TreeNode root) {
    Queue<TreeNode> queue = new LinkedList<>();
    List<List<Integer>> res = new LinkedList<>();

    if (root != null) queue.offer(root);
    while (!queue.isEmpty()) {
      List<Integer> sub = new LinkedList<>();
      while (!queue.isEmpty()) {
        root = queue.poll();
        sub.add(root.val);
      }
      res.add(sub);

      if (root.left != null) queue.offer(root.left);
      if (root.right != null) queue.offer(root.right);

    }
    return res;

  }
}
