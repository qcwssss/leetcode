package dfs;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class PostOrder {


  /**
   * Definition for a binary tree node.
   * public class TreeNode {
   *     int val;
   *     TreeNode left;
   *     TreeNode right;
   *     TreeNode() {}
   *     TreeNode(int val) { this.val = val; }
   *     TreeNode(int val, TreeNode left, TreeNode right) {
   *         this.val = val;
   *         this.left = left;
   *         this.right = right;
   *     }
   * }
   */
    public List<Integer> postorderTraversal_Recur(TreeNode root) {
      List<Integer> res = new ArrayList<>();
      postOrder(root, res);
      return res;

    }

    private void postOrder(TreeNode node, List<Integer> list) {
      if (node == null) return;
      postOrder(node.left, list);
      postOrder(node.right, list);
      list.add(node.val);

    }

    // iterative
    public List<Integer> postorderTraversal(TreeNode root) {
      Deque<TreeNode> stack = new LinkedList<>();
      List<Integer> res = new ArrayList<>();
      if (root != null) stack.push(root);
      while (!stack.isEmpty()) {
        root = stack.pop();
        res.add(0, root.val); //add to the front
        if(root.left != null) stack.push(root.left);
        if(root.right != null) stack.push(root.right);

      }
      return res;
    }


}
