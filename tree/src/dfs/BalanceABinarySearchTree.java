package dfs;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BalanceABinarySearchTree {

  public TreeNode balanceBST(TreeNode root) {
    Deque<TreeNode> stack = new LinkedList<>();
    List<Integer> list = new ArrayList<>();

    while (root != null || !stack.isEmpty()) {
      while (root != null) {
        stack.push(root);
        root = root.left;
      }
      root = stack.pop();
      list.add(root.val);
      root = root.right;
    }
    return helper(list, 0, list.size() -1);
  }

  private TreeNode helper(List<Integer> list, int left, int right) {
    if (left > right) return null;
    int mid = left + (right - left)/2;
    TreeNode root = new TreeNode(list.get(mid));
    root.left = helper(list, left, mid - 1);
    root.right = helper(list, mid + 1, right);
    return root;
  }
}
