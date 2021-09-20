package LinkedList;

public class AddTwoNumbers {

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode dummy = new ListNode(0);
    ListNode cur = dummy;
    int carry = 0;
    while (l1 != null || l2 != null || carry == 1) {
      int sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val);
      int val = sum + carry;
      cur.next = new ListNode(val % 10);
      carry = val/10;

      l1 = (l1 == null) ? l1: l1.next;
      l2 = (l2 == null) ? l2: l2.next;
      cur = cur.next;
    }

    return dummy.next;
  }
}
