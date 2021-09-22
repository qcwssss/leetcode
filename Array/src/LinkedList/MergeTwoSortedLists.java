package LinkedList;

import java.util.List;

// #21.
public class MergeTwoSortedLists {

  /* iterative  */
  public ListNode mergeTwoListsItr(ListNode l1, ListNode l2) {
    ListNode dummy = new ListNode(0);
    ListNode cur = dummy;
    while (l1 != null && l2 != null) {
      if (l1.val < l2.val) {
        cur.next = l1;
        l1 = l1.next;
      } else {
        cur.next = l2;
        l2 = l2.next;
      }

      cur = cur.next;
    }
    // link rest nodes
    cur.next = l1 == null ? l2:l1;
    return dummy.next;

  }

  public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    // link un-linked nodes, when one LList is exhausted
    if (l1 == null) return l2;
    if (l2 == null) return l1;

    if (l1.val < l2.val) {
      l1.next = mergeTwoLists(l1.next, l2);
      return l1;
    } else {
      l2.next = mergeTwoLists(l2.next, l1);
      return l2;
    }
  }

  public static void main(String[] args) {
    ListNode l1 = new ListNode(1);
    l1.next = new ListNode(2);
    l1.next.next = new ListNode(4);

    ListNode l2 = new ListNode(1);
    l2.next = new ListNode(3);
    l2.next.next = new ListNode(5);

    ListNode merged = mergeTwoLists(l1, l2);
    System.out.println(merged);
  }

  }
