package dfs;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserializeBinaryTree {

  // Encodes a tree to a single string.
  public String serialize(TreeNode root) {
    // preorder
    if (root == null) return "#";
    String res = String.valueOf(root.val);
    res += "," + serialize(root.left);
    res += "," + serialize(root.right);

    //return root.val + "," + serialize(root.left) +"," + serialize(root.right);
    return res;
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
