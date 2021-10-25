package dfs;

import org.junit.Assert;
import org.junit.Test;

public class SumRootToLeafNumbers {

  public int sumNumbers(TreeNode root) {
    //if(root == null) return null;
    return Integer.valueOf(helper(root));

  }

  private String helper(TreeNode root) {
    if(root == null) return "";

    String left = helper(root.left);
    String right = helper(root.right);

    String sumL = String.valueOf(left);
    String sumR = String.valueOf(right);
    int max = Integer.valueOf(sumL) + Integer.valueOf(sumR);
    return String.valueOf(max);

  }

  @Test
  public void testSum() {
    //    1, 2, 3
    TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3));
    Assert.assertEquals(25, sumNumbers(root));
  }
}
