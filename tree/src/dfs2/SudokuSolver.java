package dfs2;

public class SudokuSolver {

  public void solveSudoku(char[][] board) {
    solve(board);
  }

  private boolean solve(char[][] board) {
    for (int i = 0; i < board[0].length; i++ ) {
      for (int j = 0; j < board.length; j++) {
        if (board[i][j] == '.') {
          for (char c = '1'; c <= '9'; c++) {
            if (isValid(board, i, j, c)) {
              board[i][j] = c;
              if (solve(board)) return true; // If it's the solution, return true. End
              else board[i][j] = '.'; // Otherwise, go back
            }
          }
          return false; 
        }
      }
    }
    return true; // for signature only
  }

  private boolean isValid(char[][] board, int xPos, int yPos, char val) {
    int width = board[0].length;
    int height = board.length;
    // row
    for (int i = 0; i < width; i++) {
      if (board[xPos][i] == val) return false;
    }

    // column
    for (int j = 0; j < height; j++) {
      if (board[j][yPos] == val) return false;
    }

    // 3*3 square
    int xStart = (xPos / 3) * 3, xEnd = xStart + 3;
    int yStart = (yPos / 3) * 3, yEnd = yStart + 3;
    for (int i = xStart; i < xEnd; i++) {
      for (int j = yStart; j < yEnd; j++ ) {
        if (board[i][j] == val) return false;
      }
    }
    return true;
  }

}
