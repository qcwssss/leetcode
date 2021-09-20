package LinkedList;

public class ReverseLinkedListII {

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

    // didn't work
    public ListNode reverseBetween1st(ListNode head, int left, int right) {
      // decouple
      int count1 = 1, count2 = 1;
      ListNode fakeHead = head, fakeTail = head;
      while (count1 < left - 1) {
        fakeHead = fakeHead.next;
        count1++;
      }
      // is it useful
      while (count2 < right) {
        fakeTail = fakeTail.next;
        count2++; // end as 4
      }
      ListNode endNode = fakeTail.next;
      fakeTail.next = null;


      // reconnect endNode
      ListNode temp = fakeHead;
      while (temp != null) {
        temp = temp.next;
      }
      temp.next = endNode;

      // reverse, connect reversed fakeHead
      fakeHead.next = reverse(fakeHead.next);

      return fakeHead;

    }

    private ListNode reverse(ListNode head) {
      ListNode newHead = null;
      while(head != null) {
        ListNode next = head.next;
        head.next = newHead; // decouple
        newHead = head;
        head = next;
      }
      return newHead;
    }
  }

  public ListNode reverseBetween(ListNode head, int left, int right) {
    ListNode fakeHead = new ListNode(-1);
    fakeHead.next = head;
    ListNode prev = fakeHead;
    ListNode cur = fakeHead.next;

    // find the start node of reverse
    int i = 1;
    while (i < left) {
      cur = cur.next;
      prev = prev.next;
      i++;
    }
    ListNode node = prev;

    // reverse
    while (i <= right) {
      ListNode next = cur.next;
      cur.next = prev;
      prev = cur;
      cur = next;

      i++;
    }

    // reconnect
    node.next.next = cur;
    node.next = prev;

    return fakeHead.next;


  }

}
