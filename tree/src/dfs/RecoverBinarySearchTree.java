package dfs;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

public class RecoverBinarySearchTree {

  public void recoverTree(TreeNode root) {
    TreeNode first = null, second = null; // happy box
    TreeNode prev = new TreeNode(Integer.MIN_VALUE);

    Deque<TreeNode> stack = new LinkedList<>();
    TreeNode cur = root;
    while (cur != null || !stack.isEmpty()) {
      while (cur != null) {
        stack.push(cur);
        cur = cur.left;
      }
      cur = stack.pop();
      // inorder ascending, BST property
      if (prev.val > cur.val) { // can't use >=, in case node val is Integer.MIN_VALUE
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
    int tmp = first.val; // swap first & second
    first.val = second.val;
    second.val = tmp;
  }

  public void recoverTree2(TreeNode root) {

    TreeNode first = null;     // first node need to be swap
    TreeNode second = null;    // second node need to be swap
    TreeNode pre = new TreeNode(Integer.MIN_VALUE);  //previous node.

    while (root != null) {
      TreeNode node = root.left;

      // If left is not null, we need to find the rightmost node of left subtree,
      // Set its right child to current node
      if (node != null) {

        //find the rightmost
        while (node.right != null && node.right != root) {
          node = node.right;
        }

        //There are two cases,
        //null: first time we access current, set node.right to current and move to left child of current and continue;
        //current: we accessed current before, thus we've finished traversing left subtree, set node.right back to null;
        if (node.right == null) {
          node.right = root;
          root = root.left;
          continue;
        } else {
          node.right = null;
        }
      }

      // compare current node with previous node
      if (root.val < pre.val) {
        // first time we enconter reversed order, we set previous node to first
        if (first == null) {
          first = pre;
        }
        //In case that two nodes are successive, we set second to current every time.
        second = root;
      }
      pre = root;
      root = root.right;
    }

    //swap the value;
    int temp = second.val;
    second.val = first.val;
    first.val = temp;
  }


  @Test
  public void testRecovery() {
    // [5,3,9,-2147483648,2]
    TreeNode root = new TreeNode(5);
    root.left = new TreeNode(3);
    root.right = new TreeNode(9);
    TreeNode node3 = root.left;
    node3.left = new TreeNode(-2147483648);
    node3.right = new TreeNode(2);

    recoverTree(root);

  }

}
