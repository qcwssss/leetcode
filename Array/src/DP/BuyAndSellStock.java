package DP;

public class BuyAndSellStock {

  /*
  Solution #1. Brute force
      Time complexity: O(N^2), Time limit exceeded. :(
   */
  public int maxProfit(int[] prices) {
    int maxProfit = 0;
    for (int i = 0; i < prices.length; i++) {
      for (int j = i + 1; j < prices.length; j++) {
        int profit = prices[j] - prices[i];
        if (profit > maxProfit) maxProfit = profit;
      }
    }
    return maxProfit;
  }

  /**
   * DP solutions. Approach 2: One Pass
   *
   * @source https://leetcode.com/problems/best-time-to-buy-and-sell-stock/solution/
   */
  public int maxProfitPeakMinusValley(int[] prices) {
    int valley = prices[0], peak = 0, profit = 0;
    for (int i = 0; i < prices.length; i++) {
      int cur = prices[i];
      if (cur < valley) valley = cur;
      else profit = Math.max(profit, cur - valley);
    }
    return profit;
  }
}
