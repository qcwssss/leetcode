package LinkedList;

public class RemoveDuplicatesFromSortedList {

  public ListNode deleteDuplicates(ListNode head) {
    if (head == null) return head;

    // set a dummy head
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    while (head.next != null) {
      int val = head.val;
      if (head.next.val == val) {
        // skip duplicate
        head.next = head.next.next;
      } else {
        head = head.next;
      }
    }
    return dummy.next;
  }
}
