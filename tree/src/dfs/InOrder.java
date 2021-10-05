package dfs;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class inOrder {


  // recursive
  public List<Integer> inorderTraversal_Recur(TreeNode root) {
    List<Integer> list = new ArrayList<>();
    inOrder(root, list);
    return list;

  }

  private void inOrder(TreeNode root, List<Integer> list) {
    if (root == null) return;

    inOrder(root.left, list);
    list.add(root.val);
    inOrder(root.right, list);
  }



  // iterative
  public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    Deque<TreeNode> stack = new LinkedList<>();

    while (root != null || !stack.isEmpty()) {
      while (root != null) {
        stack.push(root);
        root = root.left;
      }
      root = stack.pop();
      res.add(root.val);
      root = root.right;
    }
    return res;
  }

}
