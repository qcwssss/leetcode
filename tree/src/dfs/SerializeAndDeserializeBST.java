package dfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserializeBST {
  
  // Encodes a tree to a single string.
  public String serialize(TreeNode root) {
    // preorder
    if (root == null) return "#";
    String builder = String.valueOf(root.val);
    if (root.left != null) builder += "," + serialize(root.left);
    if (root.right != null) builder += "," + serialize(root.right);

    return builder;

  }

  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {
    Queue<String> q = new LinkedList<>(Arrays.asList(data.split(",")));
    TreeNode root = dfs(q);
    return root;

  }

  private TreeNode dfs(Queue<String> queue) {
    String rootStr = queue.poll();
    if (rootStr == null || rootStr.equals("#")) return null;
    TreeNode root = new TreeNode(Integer.valueOf(rootStr));
    root.left = dfs(queue);
    root.right = dfs(queue);
    return root;
  }
}
