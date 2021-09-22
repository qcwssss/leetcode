package LinkedList;

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

  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    if (l1 == null) return l1;
    if (l2 == null) return l2;

    if (l1.val < l2.val) {
      return mergeTwoLists(l1.next, l2);
    } else {
      return mergeTwoLists(l2.next, l1);
    }
  }

  }
