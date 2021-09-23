package LinkedList;

import org.junit.Test;

import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedLists {

  public ListNode mergeKLists1(ListNode[] lists) {
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

  public ListNode mergeKLists(ListNode[] lists) {
    PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val - b.val); // ascending order
    ListNode dummy = new ListNode(0);
    for (int i = 0; i < lists.length; i++ ) {
      if (lists[i] != null) pq.offer(lists[i]);
    }
      // add new nodes to dummy in ascending order
      ListNode cur = dummy;
      while (!pq.isEmpty()) {
        cur.next = pq.poll();
        cur = cur.next;
        if (pq.isEmpty()) break;
        if (cur.next != null) pq.offer(cur.next);
      }
    return dummy.next;
  }





  @Test
  public void testMergeK1() {
    ListNode l1 = new ListNode(1);
    l1.next = new ListNode(4);
    l1.next.next = new ListNode(5);

    ListNode l2 = new ListNode(1);
    l2.next = new ListNode(3);
    l2.next.next = new ListNode(4);


    ListNode l3 = new ListNode(2);
    l3.next = new ListNode(6);
    ListNode[] lists = new ListNode[]{l1, l2, l3};
    ListNode mergeK = mergeKLists(lists);
    System.out.println(mergeK);
  }

  }
