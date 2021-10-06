package dfs;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserializeBinaryTree {

  // Encodes a tree to a single string.
  public String serialize(TreeNode root) {
    StringBuilder builder = new StringBuilder();
    // BFS
    preOrder(root, builder);
    return builder.toString();
  }

  private void preOrder(TreeNode node, StringBuilder ans) {
    if (node == null) {
      ans.append("#,");
      return;
    }
    ans.append(node.val + ",");
    preOrder(node.left, ans);
    preOrder(node.right, ans);

  }

  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {
    Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));

    // build tree
    return build(queue);
  }

  private TreeNode build(Queue<String> q) {
    String rootStr = q.poll();
    if (rootStr == null || rootStr.equals("#")) return null;
    TreeNode root = new TreeNode(Integer.parseInt(rootStr));
    root.left = build(q);
    root.right = build(q);
    if (q.isEmpty()) return root;

    return root;


  }

  @Test
  public void testDeserialize() {
    String input = "1,2,3,#,#,4,5";
    TreeNode root = deserialize(input);
  }


// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
}
