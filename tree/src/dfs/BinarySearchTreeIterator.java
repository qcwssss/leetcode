package dfs;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTreeIterator {

  class BSTIterator {
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
}
