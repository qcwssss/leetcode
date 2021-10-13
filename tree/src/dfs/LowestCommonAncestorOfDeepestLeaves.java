package dfs;

public class LowestCommonAncestorOfDeepestLeaves {

  public TreeNode lcaDeepestLeaves(TreeNode root) {
    if (root == null) return null;

    int leftHeight = height(root.left);
    int rightHeight = height(root.right);
    if (leftHeight == rightHeight) return root;
    else if (leftHeight > rightHeight) return lcaDeepestLeaves(root.left);
    else return lcaDeepestLeaves(root.right);


  }

  private int height(TreeNode node) {
    if (node == null) return 0;
    int left = height(node.left) + 1;
    int right = height(node.right) + 1;
    return Math.max(left, right);

  }


  }
