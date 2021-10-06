package dfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserializeBST {

  // Encodes a tree to a single string.
  public String serialize(TreeNode root) {
    // preorder
    if (root == null) return "";
    String builder = String.valueOf(root.val);
    if (root.left != null) builder += "," + serialize(root.left);
    if (root.right != null) builder += "," + serialize(root.right);

    return builder;

  }

  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {
    if (data.isEmpty()) return null;
    Queue<String> q = new LinkedList<>(Arrays.asList(data.split(",")));
    TreeNode root = dfs(q, Integer.MIN_VALUE, Integer.MAX_VALUE);
    return root;

  }

  private TreeNode dfs(Queue<String> queue, int lower, int upper) {
    if (queue.isEmpty()) return null; // in case input []

    String rootStr = queue.peek();
    int val = Integer.parseInt(rootStr);
    if (val < lower || val > upper) return null;
    queue.poll();
    TreeNode root = new TreeNode(Integer.valueOf(rootStr));
    root.left = dfs(queue, lower, val);
    root.right = dfs(queue, val, upper);
    return root;
  }
}
