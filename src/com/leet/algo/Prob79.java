package com.leet.algo;

/**
 * Created by ayanc on 1/25/18.
 */
public class Prob79 {
  public boolean exist(char[][] board, String word) {
    if(board == null || board.length < 1 || board[0].length < 1 || word == null || word.length() < 0) return false;
    for(int i = 0; i < board.length; i++){
      for (int j = 0; j < board[i].length; j++){
        if(exist(board, word.toCharArray(), 0, i, j)) return true;
      }
    }
    return false;
  }

  private boolean exist(char[][] board, char[] letters, int start, int i, int j){
    if(start == letters.length) return true;
    if(i < 0 || j < 0 || i == board.length || j == board[i].length) return false;
    if(letters[start] != board[i][j]) return false;
    board[i][j] ^= 1;
    boolean exists = exist(board, letters, start + 1, i + 1, j)
      || exist(board, letters, start + 1, i - 1, j)
      || exist(board, letters, start + 1, i, j + 1)
      || exist(board, letters, start + 1, i, j - 1);
    board[i][j] ^= 1;
    return exists;

  }
}
