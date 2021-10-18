package Games;

public class FibonacciNumber {
  public int fib(int n) {
    if (n < 2) return n;
    int[] memo = new int[n + 1];
    memo[1] = 1;
    memo[2] = 1;
    for (int i = 3; i <= n; i++) {
      memo[i] = memo[i - 1] + memo[i - 2];

    }

    return memo[n];

  }
}
