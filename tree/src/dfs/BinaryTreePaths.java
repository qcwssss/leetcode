package dfs;

import java.util.LinkedList;
import java.util.List;

public class BinaryTreePaths {

  public List<String> binaryTreePaths(TreeNode root) {
    if (root == null) return new LinkedList<>();
    List<String> res = new LinkedList<>();
    dfs(root, "", res);
    return res;

  }

  private void dfs(TreeNode node, String path, List<String> list) {
    if (node == null) return;
    path += node.val + "->";
    if (node.left != null) dfs(node.left, path, list);
    if (node.right != null) dfs(node.right, path, list);
    list.add(path);
  }
}
