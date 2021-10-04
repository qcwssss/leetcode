package dfs;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Preorder {
  public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> list = new LinkedList<>();
    preorder(root, list);
    return list;
  }
  // time O(n), space O(1) if don't count list
  private void preorder(TreeNode n, List<Integer> list) {
    if (n == null) return;
    list.add(n.val);
    preorder(n.left, list);
    preorder(n.right, list);

  }

  // iterative
  public List<Integer> preorderTraversal_Iter(TreeNode root) {
    Stack<TreeNode> stack = new Stack<>();
    List<Integer> list = new LinkedList<>();

    stack.push(root);
    while (!stack.isEmpty()) {
      TreeNode cur = stack.pop();
      if (cur != null) {
        list.add(cur.val);
        stack.push(cur.right);
        stack.push(cur.left); // LIFO
      }
    }
    return list;

  }
}
