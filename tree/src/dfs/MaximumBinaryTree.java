package dfs;

public class MaximumBinaryTree {

  public TreeNode constructMaximumBinaryTree(int[] nums) {
    return helper(nums, 0, nums.length - 1);
  }

  private TreeNode helper(int[] nums, int left, int right) {
    if (left > right) return null;
    //if (left == right) return new TreeNode(nums[left]);

    int maxCur = maxIndex(nums, left, right);
    TreeNode root = new TreeNode(nums[maxCur]);

    root.left = helper(nums, left, maxCur - 1);
    root.right = helper(nums, maxCur + 1, right);
    return root;
  }

  private int maxIndex(int[] nums, int left, int right) {
    int max = Integer.MIN_VALUE;
    int idx = left;
    for (int i = left; i <= right; i++) {
      if (nums[i] > max) {
        max = nums[i];
        idx = i;
      }
    }
    return idx;
  }
}
