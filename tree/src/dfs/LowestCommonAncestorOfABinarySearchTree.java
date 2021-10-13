package dfs;

public class LowestCommonAncestorOfABinarySearchTree {

  // recursive
  public TreeNode lowestCommonAncestor_Recur(TreeNode root, TreeNode p, TreeNode q) {
    // BST property: left < root, root > right
    if (root.val > p.val && root.val > q.val)
      return lowestCommonAncestor(root.left, p, q);
    else if (root.val < p.val && root.val < q.val)
      return lowestCommonAncestor(root.right, p, q);
    else return root;

  }

  // iterative
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    while (true) {
      if (root.val > q.val && root.val > p.val) {
        root = root.left;
      } else if (root.val < q.val && root.val < p.val) {
        root = root.right;
      } else {
        return root;
      }
    }
  }
}
