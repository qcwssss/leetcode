package dfs;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTreeIterator {
  // O(n) memory, O(1) time
  class BSTIterator1 {
    int cur = -1;
    List<TreeNode> inorder;
    int capacity;

    public BSTIterator(TreeNode root) {
      inorder = new ArrayList<>();
      buildList(root, inorder);
      capacity = inorder.size();
    }

    private void buildList(TreeNode node, List<TreeNode> list) {
      if (node == null) return;

      buildList(node.left, list);
      list.add(node);
      buildList(node.right, list);

    }

    public int next() {
      cur++;
      return inorder.get(cur).val;

    }

    public boolean hasNext() {
      return cur < capacity - 1;

    }
  }

  // O(h) memory, O(1) time
  // optimize
  class BSTIterator {
    Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        pushAllLeft(root);

    }

    public int next() {
        TreeNode top = stack.pop();
        pushAllLeft(top.right);
        return top.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    private void pushAllLeft(TreeNode root) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }
}
}
