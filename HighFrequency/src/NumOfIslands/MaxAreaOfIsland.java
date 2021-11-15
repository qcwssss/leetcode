package NumOfIslands;

public class MaxAreaOfIsland {

  public int maxAreaOfIsland(int[][] grid) {
    int res = 0;
    int[] ans = new int[1];
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == 1) {
          ans[0] = 0;
          dfs(grid, i, j, ans);
          res = Math.max(ans[0], res);
        }
      }
    }
    return res;
  }

  void dfs(int[][] grid, int row, int col, int[] ans) {
    if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length
            || grid[row][col] == 0) {
      return;
    }
    grid[row][col] = 0;
    ans[0] += 1;
    dfs(grid, row + 1, col, ans);
    dfs(grid, row - 1, col, ans);
    dfs(grid, row, col + 1, ans);
    dfs(grid, row, col - 1, ans);

  }
}
