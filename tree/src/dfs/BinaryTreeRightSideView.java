package dfs;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeRightSideView {

  public List<Integer> rightSideView(TreeNode root) {
    if (root == null) return new LinkedList<>();
    // BFS
    Deque<TreeNode> queue = new LinkedList<>();
    List<Integer> res = new LinkedList<>();
    queue.offer(root);
    while (queue.size() != 0) {
      int N = queue.size();
      for (int i = 0; i < N; i++) {
        TreeNode cur = queue.poll();
        if (i == N - 1) {
          res.add(cur.val);
        }
        if (cur.left != null) queue.offer(cur.left);
        if (cur.right != null) queue.offer(cur.right);
      }
    }
    return res;

  }
 @Test
  public void testRight(){
    TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3));
    System.out.println(rightSideView(root));
  }

}
