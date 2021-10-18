package Games;

public class NimSum {
  // heap 1 2 3 4 5 6 7 8
  // Win? W W W L W W W L

  public boolean canWinNim(int n) {
    int len = 5;
    boolean [] memo = new boolean[len];
    for (int i = 1; i < len; i++) {
      if (i % 4 == 0) memo[i] = false;
      else memo[i] = true;
    }
    return memo[n%4];

  }

  public boolean canWinNim2(int n) {
    boolean[] dp = new boolean[Math.max(4, n + 1)];
    dp[1] = dp[2] = dp[3] = true;
    for (int i = 4; i <= n; i++) {
      // update memo
      dp[i] = !dp[i - 1] || !dp[i-2] || !dp[i-3];  // oponent's turn
    }
    return dp[n];

  }

}
