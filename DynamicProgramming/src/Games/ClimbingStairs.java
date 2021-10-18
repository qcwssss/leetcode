package Games;

public class ClimbingStairs {

  // fibonacci
  public int climbStairs(int n) {
    int[] memo = new int[Math.max(2 + 1, n + 1)];
    memo[1] = 1;
    memo[2] = 2;
    if (n <= 2) return memo[n];
    // DP
    for (int i = 3; i <= n; i++) {
      memo[i] = memo[i-1] + memo[i-2];
    }
    return memo[n];

  }
}
