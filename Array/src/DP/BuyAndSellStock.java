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

  /**
   * Convert into max subarray
   * @source https://leetcode.com/problems/best-time-to-buy-and-sell-stock/discuss/39038/Kadane's-Algorithm-Since-no-one-has-mentioned-about-this-so-far-%3A)-(In-case-if-interviewer-twists-the-input)
   * @param prices
   * @return
   */
  public int maxProfit_MaxSubarray(int[] prices) {
    int maxSoFar = 0, maxCur = 0;
    for (int i = 1; i < prices.length; i++) {
      maxCur = Math.max(0, maxCur + (prices[i] - prices[i - 1]));
      maxSoFar = Math.max(maxSoFar, maxCur);
    }
    return maxSoFar;
  }
}
