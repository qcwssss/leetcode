package dfs;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UniqueBinarySearchTrees {

  public int numTrees(int n) {
    Integer[] memo = new Integer[n + 1];
    return dfs(n, memo);
  }

  int dfs(int num, Integer[] memo) {
    if (num == 0 || num == 1) return 1;
    if (memo[num] != null) return memo[num];
    int sum = 0;
    // recursive
    for (int i = 1; i <= num; i++) {
      sum += dfs(i - 1, memo) * dfs(num - i, memo);
    }
    return memo[num] = sum;
  }

  public int numTreesDP(int n) {
    int[] dp = new int[n + 1];
    dp[0] = 1;
    dp[1] = 1;
    for (int i = 2; i <= n; i++) {
      for (int j = 1; j <= i; j++) {
        dp[i] += dp[j - 1] * dp[i - j];
      }
    }
    return dp[n];
  }

  @Test
  public void testNumOfTrees() {
    //assertEquals(5, numTrees(3));
    assertEquals(5, numTreesDP(3));

  }
}
