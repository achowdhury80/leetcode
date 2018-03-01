package com.leet.algo;

/**
 * Created by ayanc on 2/26/18.
 */
public class Prob37 {
  public void solveSudoku(char[][] board) {
    if (board == null || board.length == 0) return;
    solve(board);
  }

  public boolean solve(char[][] board) {
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        if (board[i][j] == '.') {
          for (char c = '1'; c <= '9'; c++) {
            if (isValid(board, i, j, c)){
              board[i][j] = c;
              if (solve(board)) return true;
              board[i][j] = '.';
            }
          }
          return false;
        }
      }
    }
    return true;
  }

  private boolean isValid(char[][] board, int i, int j, char c) {
    int startRow = (i / 3) * 3;
    int startCol = (j / 3) * 3;
    int boxR = startRow;
    int boxC = startCol;
    for (int k = 0; k < 9; k++) {
      if (board[i][k] == c || board[k][j] == c || board[boxR][boxC] == c) return false;
      boxC++;
      if (boxC % 3 == 0) {
        boxR++;
        boxC = startCol;
      }
    }
    return true;
  }
}
