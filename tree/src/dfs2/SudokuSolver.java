package dfs2;

public class SudokuSolver {

  public void solveSudoku(char[][] board) {
    solve(board);
  }

  private boolean solve(char[][] board) {
    for (int i = 0; i < board[0].length; i++ ) {
      for (int j = 0; j < board.length; j++) {
        if (board[i][j] == '.') {
          // add value
          for (int k = 0; k <= 9; k++) {
            char fill = (char)(k + '0');
            if (isValid(board, i, j, fill)) {
              board[i][j] = fill;
              if (solve(board)) return true; // If it's the solution, return true. End
              else board[i][j] = '.'; // Otherwise, go back
            }
            return false; 
          }
        }
      }
    }
    return true;
  }

  private boolean isValid(char[][] board, int xPos, int yPos, char val) {
    int width = board[0].length;
    int height = board.length;
    // row
    for (int i = 0; i < width; i++) {
      if (board[xPos][i] == val) return false;
    }

    // column
    for (int j = yPos; j < height; j++) {
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
