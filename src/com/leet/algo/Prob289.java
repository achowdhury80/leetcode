package com.leet.algo;

/**
 * Created by ayanc on 2/2/18.
 */
public class Prob289 {
  public void gameOfLife(int[][] board) {
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        board[i][j] = nextState(board, i, j);
      }
    }
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        board[i][j] = (board[i][j] & 2) >> 1;
      }
    }
  }

  private int nextState(int[][] board, int i, int j) {
    int liveNeighbor = 0;
    if (i - 1 > -1) {
      if(j - 1 > - 1) {
        if ((board[i - 1][j - 1] & 1) == 1) liveNeighbor++;
      }
      if ((board[i - 1][j] & 1) == 1) liveNeighbor++;
      if(j + 1 < board[0].length) {
        if ((board[i - 1][j + 1] & 1) == 1) liveNeighbor++;
      }
    }
    if(j - 1 > - 1) {
      if ((board[i][j - 1] & 1) == 1) liveNeighbor++;
    }
    if(j + 1 < board[0].length) {
      if ((board[i][j + 1] & 1) == 1) liveNeighbor++;
    }
    if(i + 1 < board.length) {
      if(j - 1 > - 1) {
        if ((board[i + 1][j - 1] & 1) == 1) liveNeighbor++;
      }
      if ((board[i + 1][j] & 1) == 1) liveNeighbor++;
      if(j + 1 < board[0].length) {
        if ((board[i + 1][j + 1] & 1) == 1) liveNeighbor++;
      }
    }
    if ((board[i][j] & 1) == 0) {
      if (liveNeighbor == 3) return 2;
      return 0;
    }
    if (liveNeighbor == 2 || liveNeighbor == 3) return 3;
    return 1;
  }

  public static void main(String[] args) {
    Prob289 prob289 = new Prob289();
//    int[][] board = new int[][]{{1, 1}};
    int[][] board = new int[][]{{1, 1}, {1, 0}};
    prob289.gameOfLife(board);
    System.out.println(board);
  }
}
