package LinkedList;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class IntersectionOfTwoLList {

  /*
  O(n) space, O(n) time
   */
  public ListNode getIntersectionNode3(ListNode headA, ListNode headB) {
    // traverse one list, store val and node in a set
    // see if there is a same node in the other head
    Set<ListNode> visited = new HashSet<>();
    ListNode a = headA, b = headB;

    while (a != null) {
      visited.add(a);
      a = a.next;
    }

    // compare val and node in headB
    while (b != null) {
      if (visited.contains(b)) {
        return b;
      }
      b = b.next;
    }
    return null;
  }

  /**
   * O(1) space, O(n) time a = len of headA, b = len of headB, c = len of intersection a + c + b = b
   * + c + a
   *
   * @param headA a list
   * @param headB b list
   * @return intersect node
   */
  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    ListNode a = headA, b = headB;
    while (a != b) {
      a = a == null ? headB : a.next;
      b = b == null ? headA : b.next;
    }
    return a;
  }

  public ListNode getIntersectionNode_len(ListNode headA, ListNode headB) {
    int len1 = countLength(headA), len2 = countLength(headB);
    if (len1 > len2) {
      while (len1 > len2) {
        headA = headA.next;
        len1--;
      }
    } else {
      while (len1 < len2) {
        headB = headB.next;
        len2--;
      }
    }
    // start from the same dist from the intersection
    while (headA != headB) {
      headA = headA.next;
      headB = headB.next;
    }
    return headA;
  }

  private int countLength(ListNode n) {
    int count = 0;
    while (n != null) {
      n = n.next;
      count += 1;
    }
    return count;
  }

  // why not works? different address?
  public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
    Map<Integer, ListNode> map = new HashMap<>();
    ListNode a = headA, b = headB;

    while (a != null) {
      map.put(a.val, a);
      a = a.next;
    }

    while (b != null) {
      if (b == map.get(b.val)) { // address?
        return b;
      }
      b = b.next;
    }
    return null;
  }

  /*
  4
  [2,2,4,5,4]
  [2,2,4,5,4]
  2
  2
  failed
  */
}
