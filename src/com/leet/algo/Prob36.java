package com.leet.algo;

/**
 * Created by ayanc on 11/3/17.
 */
public class Prob36 {
  public boolean isValidSudoku(char[][] board) {
    for(int i = 0; i < 9; i++){
      if(!isValidRow(board, i)) return false;
      if(!isValidCol(board, i)) return false;
      if(!isValidMatrix(board, i)) return false;
    }
    return true;
  }

  public boolean isValidRow(char[][] board, int row){
    byte[] present = new byte[9];
    for(int i = 0; i < 9; i++){
      char chr = board[row][i];
      if(chr == '.') continue;
      int val = Integer.valueOf("" + chr);
      if(present[val] == 1) return false;
      present[val] = 1;
    }
    return true;
  }

  public boolean isValidCol(char[][] board, int col){
    byte[] present = new byte[9];
    for(int i = 0; i < 9; i++){
      char chr = board[i][col];
      if(chr == '.') continue;
      int val = Integer.valueOf("" + chr);
      if(present[val] == 1) return false;
      present[val] = 1;
    }
    return true;
  }

  public boolean isValidMatrix(char[][] board, int matrix){
    byte[] present = new byte[9];
    int startingRow = (matrix / 3) * 3;
    int startingCol = (matrix % 3) * 3;
    for(int i = 0; i < 9; i++){
      int row = startingRow + i / 3;
      int col = startingCol + (i % 3);
      char chr = board[row][col];
      if(chr == '.') continue;
      int val = Integer.valueOf("" + chr);
      if(present[val] == 1) return false;
      present[val] = 1;
    }
    return true;
  }


}
