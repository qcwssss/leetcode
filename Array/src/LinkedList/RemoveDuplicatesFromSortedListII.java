package LinkedList;

import org.junit.Test;

public class RemoveDuplicatesFromSortedListII {

  public ListNode deleteDuplicates(ListNode head) {

    // two pointers
    ListNode dummy  = new ListNode(-1);
    dummy.next = head;
    ListNode prev = dummy, cur = dummy.next;
    while (cur != null && cur.next != null) {
      if (cur.next.val == cur.val) {
        int temp = cur.val;
        while (cur != null && cur.val == temp) {
          // move cur to next
          cur = cur.next;
        }
        prev.next = cur;
      } else {
        cur = cur.next;
        prev = prev.next;
      }

    }

    return dummy.next;
  }

  @Test
  public void testRemoveDup() {
    ListNode l1 = new ListNode(1);
    l1.next = new ListNode(1);


    ListNode remove = deleteDuplicates(l1);
    System.out.println(remove);
  }
}
