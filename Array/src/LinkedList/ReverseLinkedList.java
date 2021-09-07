package LinkedList;

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

  public ListNode reverseList(ListNode head) {
    ListNode rev = new ListNode();
    rev.val = head.val;
    ListNode ptrHead = head.next, ptrRev = rev;
    while (head.next != null) {
      ptrRev.next = new ListNode(ptrRev.val, new ListNode());
      ptrHead = ptrHead.next;
      ptrRev = ptrRev.next;
    }
    return rev;
  }
}
