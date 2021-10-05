package dfs;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserializeBinaryTree {

  // Encodes a tree to a single string.
  public String serialize(TreeNode root) {
    StringBuilder builder = new StringBuilder();
    // BFS
    Queue<TreeNode> q = new LinkedList<>();
    if (root != null) q.offer(root);
    while (!q.isEmpty()) {
      int size = q.size();
      StringBuilder level = new StringBuilder();
      for (int i = 0; i < size; i++) {
        TreeNode cur = q.poll();
        level.append(cur.val);
        level.append(',');
        // build data
        if (cur.left != null) q.offer(cur.left);
        else q.offer(null);
        if (cur.right != null) q.offer(cur.right);
        else q.offer(null);

      }
      builder.append(level);
    }
    String res = builder.substring(0, builder.length() - 1);
    return res;
  }

  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {
    int len = data.length();
    String[] dataArr = data.split(",");
    int[] vals = new int[len];
    // build int array
    for (int i = 0; i < len; i++) {
      vals[i] = Integer.parseInt(dataArr[i]);
    }
    // build tree
    TreeNode root = new TreeNode(vals[0]);

    int idx = 1;
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);

    while (!queue.isEmpty()) {
      for (int i = 0; i < queue.size(); i++) {
        TreeNode cur = queue.poll();
        cur.left = new TreeNode(vals[idx]);
        cur.right = new TreeNode(vals[idx+1]);
        queue.offer(cur.left);
        queue.offer(cur.right);
      }
    }
    return root;


  }

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
}
