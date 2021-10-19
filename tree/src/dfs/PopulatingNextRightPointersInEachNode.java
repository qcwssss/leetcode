package dfs;

public class PopulatingNextRightPointersInEachNode {
  public Node connect(Node root) {
    if (root == null) return null;

    helper(root.left, root.right);
    return root;
  }

  private void helper(Node node1, Node node2) {
    if (node1 == null) return;
    node1.next = node2;
    helper(node1.left, node1.right);
    helper(node2.left, node2.right);
    helper(node1.right, node2.left);

  }

  /**
   * Better recursive idea
   * https://leetcode.com/problems/populating-next-right-pointers-in-each-node/discuss/37473/My-recursive-solution(Java)
   * @param root
   */
  public void connect2(Node root) {
    if(root == null)
      return;

    if(root.left != null){
      root.left.next = root.right;
      if(root.next != null)
        root.right.next = root.next.left;
    }

    connect(root.left);
    connect(root.right);
  }
}
