package NumOfIslands;

class islandPerimeter {
    public int islandPerimeter_3(int[][] grid) {
        int islands = 0, neighbors = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    islands++;
                    // count right, down neighbors
                    if (i < grid.length - 1 && grid[i + 1][j] == 1) neighbors++;
                    if (j < grid[0].length - 1 && grid[i][j + 1] == 1) neighbors++;

                }
            }
        }
        
        return islands*4 - 2*neighbors;
        
    }
    
    // dfs counting edge
    public int islandPerimeter(int[][] grid) {
        int[] ans = new int[2];
        ans[0] = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) dfs(grid, i, j, ans);
            }
        }
        return ans[0];

    }

    void dfs(int[][] grid, int row, int col, int[] ans) {
        
        if (row < 0 || row > grid.length - 1 || 
            col < 0 || col > grid[0].length - 1 || 
            grid[row][col] == 0) {
                ans[0]++;
                return;
            }
        else if (grid[row][col] == -1) return;
        
        grid[row][col] = -1; // mark visited
        dfs(grid, row + 1 , col, ans);
        dfs(grid, row - 1, col, ans);
        dfs(grid, row, col - 1, ans);
        dfs(grid, row, col + 1, ans);
        
    }

    

    // count edge
    public int islandPerimeter_2(int[][] grid) {
    int m = grid.length;
    int n = grid[0].length; // [m][n]
    //                 up      right   left     down
    int[][] direct = {{0, 1}, {1, 0}, {-1, 0}, {0, -1} } ;
    int count = 0; // count boundry
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == 1) {
          // check four directions
          for (int[] dir : direct) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (x < 0 || y < 0
                    || x == m || y == n
                    || grid[x][y] == 0) {
              count += 1;
            }
          }
        }
      }
    }
    return count;
  }
}