package NumOfIslands;

class ClosedIslands {
    public int closedIsland(int[][] grid) {
        int count = 0;
        for(int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0 && isClose(grid, i, j)) count++;
            }
        }
        return count;
    }
    
    // helper incorrect
    boolean isClose(int[][] grid, int row, int col) {
        if (row < 0 || row > grid.length - 1 || col < 0 || col < grid[0].length - 1) {
            return false;
        }
        if (grid[row][col] == 1) return true;
        grid[row][col] = 1;
        return 
                isClose(grid, row - 1, col) &
                isClose(grid, row, col - 1) & 
                isClose(grid, row + 1, col) &
                isClose(grid, row, col + 1);  
            
    }

    public int closedIsland2(int[][] grid) {
        int res = 0;
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0 && dfs(grid, i, j, m, n)) res++;
            }
        }
        return res;
    }

    private boolean dfs(int[][] grid, int i, int j, int m, int n) {
        if (i < 0 || j < 0 || j >= n || i >= m) return false;
        if (grid[i][j] == 1) return true;
        grid[i][j] = 1;
        return dfs(grid, i - 1, j, m, n) &
               dfs(grid, i, j - 1, m, n) &
               dfs(grid, i + 1, j, m, n) &
               dfs(grid, i, j + 1, m, n);  
    }

// https://stackoverflow.com/questions/5564410/what-is-the-difference-between-and-in-java
/*
&" will evaluate both side even the left part is false
"&&" will ignore the right part if the left part is false

res = res && dfs(grid, x + d[0], y + d[1]);
if res is false, the right dfs will not be evaluated.
for this question, we need to enter dfs(grid, x + d[0], y + d[1]) no matter what.
*/
}