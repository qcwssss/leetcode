package LinkedList;

public class RemoveZeroSumConsecutiveNodes {

  public ListNode removeZeroSumSublists(ListNode head) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode cur = head;
    // calculate sum ends in i-index, store sum in a map
    Map<Integer, ListNode> map = new HashMap<>();
    int sum = 0;
    map.put(sum, dummy);

    while(cur != null) {
      sum += cur.val;
      map.put(sum, cur);
      cur = cur.next;
    }

    // find the node with same value
    sum = 0;
    for (ListNode i = dummy; i != null; i = i.next) {
      sum += i.val;
      if (map.get(sum) != i) {
        // there may be more than one sum zero
        i.next = map.get(sum).next;
      }
    }
    return dummy.next;



  }
}
