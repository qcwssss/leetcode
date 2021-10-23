package dfs;

import com.sun.source.tree.Tree;
import org.junit.Test;

import static org.junit.Assert.assertFalse;

public class SameTree {

  public boolean isSameTree1(TreeNode p, TreeNode q) {
    StringBuilder strP = new StringBuilder();
    StringBuilder strQ = new StringBuilder();
    dfs(p, strP);
    dfs(q, strQ);
    return strP.toString().equals(strQ.toString());

  }

  private void dfs(TreeNode n, StringBuilder sb) {
    if (n == null) {
      sb.append("#");
      return;
    }

    sb.append(n.val);
    dfs(n.left, sb);
    dfs(n.right, sb);

  }

  public boolean isSameTree(TreeNode p, TreeNode q) {
    if (p == null && q == null) return true;
    if (p == null || q == null) return false;
    if (p.val != q.val) return false;
    return isSameTree(p.right, q.right) && isSameTree(p.left, q.left);
  }


    @Test
  public void testCompareStr() {
    TreeNode p = new TreeNode(1, new TreeNode(1), null);
    TreeNode q = new TreeNode(1, null, new TreeNode(1));
    assertFalse(isSameTree(p, q));
  }
}
