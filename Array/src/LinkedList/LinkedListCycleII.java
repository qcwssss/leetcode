package LinkedList;

public class LinkedListCycleII {

  public ListNode detectCycle(ListNode head) {
    // two pointers
    ListNode fast = head, slow = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if (slow == fast) {
        fast = head;
        while (fast != slow) {
          fast = fast.next;
          slow = slow.next;
        }
        return slow;
      }
    }
    return null;
  }
}
