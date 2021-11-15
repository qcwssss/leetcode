package NumOfIslands;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {

  public int numIslands(char[][] grid) {
    int count = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == '1') {
          count++;
          dfs(grid, i, j);
          //bfs(grid, i, j);

        }
      }
    }
    return count;

  }

  void dfs(char[][] grid, int x, int y) {
    if (x >= grid.length || y >= grid[0].length
            || x < 0 || y < 0 || grid[x][y] == '0') {
      return;
    }
    grid[x][y] = '0';

    dfs(grid, x + 1, y);
    dfs(grid, x - 1, y);
    dfs(grid, x, y + 1);
    dfs(grid, x, y - 1);

  }

  // BFS
  int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

  void bfs(char[][] grid, int row, int col) {
    Queue<int[]> q = new LinkedList<>();
    q.offer(new int[]{row, col});
    while (!q.isEmpty()) {
//      int size = q.size();
//      for (int[] pos : q)  -> this is for counting steps
      int[] cur = q.poll();
      int x = cur[0], y = cur[1];
      if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length
              || grid[x][y] == '0') continue;
      grid[x][y] = '0';
      for (int[] dir : dirs) {
        q.add(new int[]{x + dir[0], y + dir[1]});
      }
    }
  }

}
