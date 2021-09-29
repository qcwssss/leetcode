package LinkedList;

import java.util.HashMap;
import java.util.Map;

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
    // copy all nodes' val
    Map<Node, Node> map = new HashMap<>();
    for(Node i = head; i != null; i = i.next) {
      map.put(i, new Node(i.val));
    }

    // copy all nodes' next and random in the hashmap
    for(Node i = head; i != null; i = i.next) {
      map.get(i).next = map.get(i.next);
      map.get(i).random = map.get(i.random);
    }
    return map.get(head);


  }
}
