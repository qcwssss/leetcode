package dfs2;

import java.util.ArrayList;
import java.util.List;

public class NQueens {

  public List<List<String>> solveNQueens(int n) {
    char[][] board = new char[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        board[i][j] = '.';
      }
    }

    List<List<String>> res = new ArrayList<>(n);
    dfs(board,0, res);
    return res;

  }

  void dfs(char[][] board, int colIndex, List<List<String>> res) {
    if (colIndex == board.length) {
      res.add(construct(board));
      return;
    }
    // backtrack
    for (int i = 0; i < board.length; i++) {
      // increment by column
      if (isValid(board, i, colIndex)) { // i -> row
        board[i][colIndex] = 'Q';
        dfs(board, colIndex + 1, res);
        board[i][colIndex] = '.';

      }
    }
  }

  private boolean isValid(char[][] board, int xPos, int yPos) {
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < yPos; j++) {
        // only need to examine /\ and --
        // col starts from 0 and increment, it can't dup in the same col
        if (board[i][j] == 'Q' &&
                (i == xPos || xPos + yPos == i + j || xPos + j == yPos + i)) {
          return false;
          // xPos + yPos == i + j -> /
          // xPos + j == yPos + i -> \
        }
      }
    }
    return true;

  }

  private List<String> construct(char[][] board) {
    List<String> list = new ArrayList<>();
    for (int i = 0; i < board.length; i++) {
      list.add(new String(board[i])); // char[] to string
    }
    return list;
  }
}
