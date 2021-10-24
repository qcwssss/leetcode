package dfs;

public class SumRootToLeafNumbers {

  public int sumNumbers(TreeNode root) {
    //if(root == null) return null;
    return Integer.valueOf(helper(root));

  }

  private String helper(TreeNode root) {
    if(root == null) return "";

    String left = helper(root.left);
    String right = helper(root.right);

    String sumL = String.valueOf(root.val) + String.valueOf(left);
    String sumR = String.valueOf(root.val) + String.valueOf(right);
    int max = Integer.valueOf(sumL) + Integer.valueOf(sumR);
    return String.valueOf(max);

  }
}
