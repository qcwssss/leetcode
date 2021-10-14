package dfs;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class BinaryTreePaths {

  public List<String> binaryTreePaths(TreeNode root) {
    if (root == null) return new LinkedList<>();
    List<String> res = new LinkedList<>();
    dfs(root, String.valueOf(root.val), res);
    return res;

  }

  private void dfs(TreeNode node, String path, List<String> list) {
    if (node.left == null && node.right == null) list.add(path);

    if (node.left != null) {
      dfs(node.left, path + "->"+ node.left.val, list);
    }
    if (node.right != null) {
      /*
            //path += "->"+ node.right.val;
      we can't update path's value here, because we want path start from root
      like 1->2->5; if path is updated, path 1->3 will become 1->2->3.
       */
      dfs(node.right, path + "->"+ node.right.val, list);
    }
  }

  @Test
  public void testBTPaths() {
    // [1,2,3,null,5]
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2, null,  new TreeNode(5));
    root.right = new TreeNode(3);
    List<String> actual = binaryTreePaths(root);

    Assert.assertEquals( actual.toString(), ("1->2->5,1->3"));

  }
}
