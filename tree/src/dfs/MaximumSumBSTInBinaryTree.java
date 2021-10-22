package dfs;

import org.junit.Test;

// https://leetcode.com/problems/maximum-sum-bst-in-binary-tree/discuss/534877/Java-One-pass-post-order-DFS-O(N)
public class MaximumSumBSTInBinaryTree {

  int maxSum = 0;// 0 at first
  public int maxSumBST(TreeNode root) {
    if (root == null) return 0;
    dfs(root);
    return maxSum;

  }

  private int[] dfs(TreeNode root) {
    if (root == null) {
      return new int[]
              {1, Integer.MAX_VALUE, Integer.MIN_VALUE, 0};
      // [isBST(1 = true), min_root, max_root, rootSum]
    }

    int[] left = dfs(root.left);
    int[] right = dfs(root.right);

    //postorder
    int[] res = new int[4];
    if (left[0] == 1 && right[0] == 1
            && root.val > left[2] && root.val < right[1]) {
      res[0] = 1; // is BST
      res[1] = Math.min(left[1], root.val);
      res[2] = Math.max(right[2], root.val);
      res[3] = right[3] + left[3] + root.val;
      maxSum = Math.max(res[3], maxSum);
    } else {
      res[0] = 0; // not BST
    }
    return res;
  }


  int[] traverse(TreeNode root) {
    // base case
    if (root == null) {
      return new int[]
              {1, Integer.MAX_VALUE, Integer.MIN_VALUE, 0};
    }

    // 递归计算左右子树
    int[] left = traverse(root.left);
    int[] right = traverse(root.right);

    /******* 后序遍历位置 *******/
    int[] res = new int[4];
    // 这个 if 在判断以 root 为根的二叉树是不是 BST
    if (left[0] == 1 && right[0] == 1 &&
            root.val > left[2] && root.val < right[1]) {
      // 以 root 为根的二叉树是 BST
      res[0] = 1;
      // 计算以 root 为根的这棵 BST 的最小值
      res[1] = Math.min(left[1], root.val);
      // 计算以 root 为根的这棵 BST 的最大值
      res[2] = Math.max(right[2], root.val);
      // 计算以 root 为根的这棵 BST 所有节点之和
      res[3] = left[3] + right[3] + root.val;
      // 更新全局变量
      maxSum = Math.max(maxSum, res[3]);
    } else {
      // 以 root 为根的二叉树不是 BST
      res[0] = 0;
      // 其他的值都没必要计算了，因为用不到
    }
    /**************************/

    return res;
  }




  private int sumTree(TreeNode root) {
    if (root == null) return 0;

    int leftSum = sumTree(root.left);
    int rightSum = sumTree(root.right);
    if (isBST(root, Integer.MIN_VALUE)) {
      maxSum = Math.max(leftSum + rightSum + root.val, maxSum);
    }
    return maxSum;
  }

  private boolean isBST(TreeNode root, int prev) {
    if (root == null) return true;

    boolean isLeftBST = isBST(root.left, prev);
    // inorder
    if (!isLeftBST) return false;
    if (prev >= root.val) return false;
    else prev = root.val;
    return isBST(root.right, prev);


  }

  @Test
  public void testDfsString() {
    TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3));

    System.out.println(sumTree(root));
  }


  @Test
  public void testSum1() {
    TreeNode root = new TreeNode(-4, new TreeNode(-2), new TreeNode(-5));
    int[] res = dfs(root);
    System.out.println(res[3]);
  }

  @Test
  public void testSum2() {
    TreeNode root = new TreeNode(2, new TreeNode(1), new TreeNode(3));
    int res = maxSumBST(root);
    System.out.println(res);
  }
}
