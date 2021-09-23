package LinkedList;

import java.util.PriorityQueue;

public class MergeKSortedLists {

  public ListNode mergeKLists(ListNode[] lists) {
    int len = lists.length;
    if (len == 0) return lists[0];

    // use a priority queue to store all values of nodes
    // O(n^2)
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    for (int i = 0; i < len; i++ ) {
      ListNode cur = lists[i];
      while (cur != null) {
        pq.add(cur.val);
        cur = cur.next;
      }
    }

    // build a new LList
    // O(k log n), n is the total number of nodes in lists array
    ListNode dummy = new ListNode(0);
    ListNode curr = dummy;
    while (pq.isEmpty()) {
      curr.next = new ListNode(pq.poll());
      curr = curr.next;
    }
    
    return dummy.next;

  }
}
