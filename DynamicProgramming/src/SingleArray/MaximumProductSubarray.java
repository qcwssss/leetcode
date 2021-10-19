package SingleArray;

public class MaximumProductSubarray {
  public int maxProduct(int[] nums) {
    int len = nums.length;
    if (len == 1) return nums[0];

    int[] maxEnd = new int[len + 2];
    int[] minEnd = new int[len + 2];
    // initial base case
    maxEnd[0] = nums[0];
    minEnd[0] = nums[0];
    int maxSoFar = nums[0];

    for (int i = 1; i < len; i++) {
      if (nums[i] >= 0) {
        maxEnd[i] = Math.max(nums[i], nums[i] * maxEnd[i-1]);
        minEnd[i] = Math.min(nums[i], nums[i] * minEnd[i-1]);
      } else {
        maxEnd[i] = Math.max(nums[i], nums[i] * minEnd[i-1]);
        minEnd[i] = Math.min(nums[i], nums[i] * maxEnd[i-1]);
      }
      maxSoFar = Math.max(maxEnd[i], maxSoFar);
    }
    return maxSoFar;

  }
}
