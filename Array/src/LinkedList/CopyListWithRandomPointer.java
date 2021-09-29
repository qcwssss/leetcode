package LinkedList;

public class CopyListWithRandomPointer {
  // Definition for a Node.
  class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
      this.val = val;
      this.next = null;
      this.random = null;
    }
  }

  public Node copyRandomList(Node head) {
    // two pass
    Node ptr = head; // traverse original node
    Node newHead = new Node(head.val);

    // map for link random
    // Map<Integer, Node> map = new HashMap<>();
    Node cur = newHead;
    while (ptr != null) {
      // map.put(cur.val, cur);
      ptr = ptr.next;
      cur.next = (ptr == null) ? null : new Node(ptr.val);
    }

    ptr = head;
    cur = newHead;
    while (ptr != null) {
      if (ptr.random == null) {
        cur.random = null;
      } else {
        cur.random = new Node(ptr.random.val);
      }

      ptr = ptr.next;
      cur = cur.next;
    }
    return newHead;
  }
}
