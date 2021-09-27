package LinkedList;

public class RemoveNthNodeFromEndofList {

  // two pass
  public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode dummy = new ListNode(-1);
    dummy.next = head;

    // count length, need 1 pass
    int count = 0;
    ListNode temp = head;
    while (temp != null) {
      count++;
      temp = temp.next;
    }

    // remove n-th node
    ListNode cur = dummy;
    // find the previous node before n
    count -= n;
    while (count > 0) {
      cur = cur.next;
      count--;
    }
    cur.next = cur.next.next;
    return dummy.next;
  }

  // one pass
  public ListNode removeNthFromEnd1(ListNode head, int n) {
    // one pass, two pointers, diff n
    ListNode dummy = new ListNode(-1);
    dummy.next = head;
    ListNode first = dummy, second = dummy;

    // first pointer moves first
    while (n >= 0) {
      first = first.next;
      n -= 1;
    }
    // traverse with first, second pointers
    while (first != null) {
      first = first.next;
      second = second.next;
    }

    second.next = second.next.next;
    return dummy.next;
  }
}
