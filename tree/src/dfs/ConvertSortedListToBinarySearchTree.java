package dfs;

import org.junit.Test;

public class ConvertSortedListToBinarySearchTree {



  public TreeNode sortedListToBST(ListNode head) {
    if (head == null) return null;

    // base case
    if (head.next == null) return new TreeNode(head.val);

    ListNode dummy = new ListNode(Integer.MIN_VALUE);
    dummy.next = head;
    // two pointer
    ListNode slow = head, fast = head;
    ListNode prev = dummy;
    // check fast then check fast.next, in case even number of nodes
    while (fast != null && fast.next != null) {
      prev = prev.next;
      slow = slow.next;
      fast = fast.next.next;
    }
    // slow ends in middle
    TreeNode root = new TreeNode(slow.val);
    // break list in the middle
    prev.next = null;

    root.left = sortedListToBST(head);
    root.right = sortedListToBST(slow.next);

    return root;


  }

  @Test
  public void testConvert() {
    ListNode node = new ListNode(-10, new ListNode(-3, new ListNode(0, new ListNode(5, new ListNode(9)))));
    TreeNode root = sortedListToBST(node);
    System.out.println(root);
  }
}
