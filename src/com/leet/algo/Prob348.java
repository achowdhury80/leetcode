package com.leet.algo;

/**
 * Created by ayanc on 2/12/18.
 */
public class Prob348 {
  /** Initialize your data structure here. */
  Boolean[][] board;
  boolean finished;
  public Prob348(int n) {
    board = new Boolean[n][n];
    finished = false;
  }

  /** Player {player} makes a move at ({row}, {col}).
   @param row The row of the board.
   @param col The column of the board.
   @param player The player, can be either 1 or 2.
   @return The current winning condition, can be either:
   0: No one wins.
   1: Player 1 wins.
   2: Player 2 wins. */
  public int move(int row, int col, int player) {
    if (board[row][col] != null || finished) return 0;
    board[row][col] = playerToValue(player);
    if (isFinished(row, col, player)) {
      finished = true;
      return player;
    }
    return 0;
  }

  private boolean isFinished(int row, int col, int player) {
    if (rowSuccess(col, player) || colSuccess(row, player) || diagonalSuccess(row, col, player)) {
      return true;
    }
    return false;
  }

  private boolean rowSuccess(int col, int player){
    boolean mark = playerToValue(player);
    for (int i = 0; i < board.length; i++) {
      if (board[i][col] == null || board[i][col] != mark) return false;
    }
    return true;
  }

  private boolean colSuccess(int row, int player){
    boolean mark = playerToValue(player);
    for (int i = 0; i < board.length; i++) {
      if (board[row][i] == null || board[row][i] != mark) return false;
    }
    return true;
  }

  private boolean diagonalSuccess(int row, int col, int player){
    if (row != col && row + col + 1 != board.length) return false;
    boolean mark = playerToValue(player);
    boolean success = true;
    if (row == col) {
      success = true;
      for (int i = 0; i < board.length; i++) {
        if (board[i][i] == null || board[i][i] != mark) {
          success = false;
          break;
        }
      }
      if (success) return true;
    }
    success = false;
    if (row + col + 1 == board.length) {
      success = true;
      for (int i = 0; i < board.length; i++) {
        if (board[i][board.length - i - 1] == null || board[i][board.length - i - 1] != mark) {
          success = false;
          break;
        }
      }
    }
    return success;

  }

  private boolean playerToValue(int player) {
    return player == 1;
  }
}
