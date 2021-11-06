package bfs;

public class IslandPerimeter {

  public int islandPerimeter(int[][] grid) {
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
