package dfs;

import com.sun.source.tree.Tree;
import org.junit.Test;

public class ConvertSortedArraytoBinarySearchTree {

  public TreeNode sortedArrayToBST(int[] nums) {
    int N = nums.length;
    return build(0, N - 1, nums);


  }

  private TreeNode build(int left, int right, int[] nums) {
    if (left > right) return null;
    int mid = left + (right - left)/2;
    TreeNode root = new TreeNode(nums[mid]);
    root.left = build(left, mid - 1, nums);
    root.right = build(mid + 1, right, nums);
    return root;
  }

  //if (left == right) return new TreeNode (left);
  // [-10,-3,0,5,9]
  @Test
  public void testBuildBST() {
    int[] nums = new int[] {-10,-3,0,5,9};
    TreeNode root = sortedArrayToBST(nums);
  }
}
