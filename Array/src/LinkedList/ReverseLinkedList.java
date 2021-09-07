package LinkedList;

import java.util.List;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode() {}
 * ListNode(int val) { this.val = val; } ListNode(int val, ListNode next) { this.val = val;
 * this.next = next; } }
 */
public class ReverseLinkedList {
  public class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }

  /**
   * @source https://leetcode.com/problems/reverse-linked-list/discuss/58125/In-place-iterative-and-recursive-Java-solution
   * @param head
   * @return
   */
  public ListNode reverseList(ListNode head) {
    /* iterative solution. */
    ListNode newHead = null;
    while (head != null) {
      // put head.next in the prev of head
      ListNode next = head.next;
      head.next = newHead;
      newHead = head;
      head = next;
    }
    return newHead;

  }
}
