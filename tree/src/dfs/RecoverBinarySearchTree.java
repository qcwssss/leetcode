package dfs;

import java.util.Deque;
import java.util.LinkedList;

public class RecoverBinarySearchTree {

  public void recoverTree(TreeNode root) {
    TreeNode first = null, second = null; // happy box
    TreeNode prev = new TreeNode(Integer.MIN_VALUE);

    Deque<TreeNode> stack = new LinkedList<>();
    //List<TreeNode> list = new ArrayList<>();

    TreeNode cur = root;
    while (cur != null || !stack.isEmpty()) {
      while (cur != null) {
        stack.push(cur);
        cur = cur.left;
      }
      cur = stack.pop();
      if (prev.val >= cur.val) {
        // store inversion in happy box
        if (first == null) {
          first = prev;
          second = cur;
        } else {
          second = cur;
        }
      }
      prev = cur;
      cur = cur.right;
    }
    // swap first & second
    int tmp = first.val;
    first.val = second.val;
    second.val = tmp;
  }
}
