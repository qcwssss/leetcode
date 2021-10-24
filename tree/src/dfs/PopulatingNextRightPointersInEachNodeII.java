package dfs;

public class PopulatingNextRightPointersInEachNodeII {
  class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
      val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
      val = _val;
      left = _left;
      right = _right;
      next = _next;
    }
  }

  ;

  public Node connect(Node root) {
    if (root == null) return null;

    Node head = root;
    while (head != null) {
      Node dummy = new Node(0); // dummy points to the head of each level
      Node tmp = dummy; // tmp traverse each level from left to right;

      // build linked list
      while (head != null) {
        if (head.left != null) {
          tmp.next = head.left;
          tmp = tmp.next;
        }
        if (head.right != null) {
          tmp.next = head.right; // connect
          tmp = tmp.next;
        }
        head = head.next; // go right
      }
      head = dummy.next;
    }
    return root;
  }

  // not works, recursive method
  private void helper(Node left, Node right) {
    if (left == null && right == null) return;
    // or
    if (left == null || right == null) return;


    left.next = right;
    helper(left.left, left.right);
    helper(right.left, right.right);
    Node midRight = right.left == null ? right.right : right.left;
    Node midLeft = left.right == null ? left.left : left.right;
    helper(midLeft, midRight);

  }

}
