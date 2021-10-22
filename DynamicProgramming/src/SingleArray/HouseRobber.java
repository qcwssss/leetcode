package SingleArray;

public class HouseRobber {
  // https://leetcode.com/problems/house-robber/discuss/156523/From-good-to-great.-How-to-approach-most-of-DP-problems.
  public int rob(int[] nums) {
    int N = nums.length;
    int maxSoFar, maxEnd;
    int[] memo = new int[N + 1];
    memo[1] = nums[0];
    if (N < 2) return memo[1];

    memo[2] = Math.max(nums[1], nums[0]);
    maxSoFar = Math.max(memo[1], memo[2]);
    for(int i = 3; i <= N; i++) {
      memo[i] = Math.max(nums[i-1] + memo[i-2], memo[i-1]);
      maxSoFar = Math.max(maxSoFar, memo[i]);
    }


    return maxSoFar;

  }
}
