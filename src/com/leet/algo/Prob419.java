package com.leet.algo;

/**
 * Created by ayanc on 11/13/17.
 */
public class Prob419 {
//  public int countBattleships(char[][] board) {
//    if(board == null || board.length == 0) return -1;
//    return countBattleships(board, 0, board.length - 1, 0, board[0].length - 1);
//  }
//
//  public int findLengthHorizontal(char[][] board, int rowIndex, int colIndex){
//    if(rowIndex - 1 > 0 && board[rowIndex - 1][colIndex] == 'X') return 0;
//    if(colIndex - 1 > 0 && board[rowIndex][colIndex - 1] == 'X') return 0;
//    int length = 1;
//    for(int i = colIndex + 1; i < board[rowIndex].length; i++){
//      if(board[rowIndex][colIndex] != 'X') break;
//      length++;
//    }
//    return length;
//  }
//
//  public int countBattleships(char[][] board, int rowStart, int rowEnd, int colStart, int colEnd) {
//    int result = 0;
//    for(int i = rowStart; i <= rowEnd; i++){
//      for(int j = colStart; j <= colEnd; j++){
//        if(board[i][j] == '.') continue;
//        int k = findLengthHorizontal(board, i, j);
//        if(k != 0) result++;
//        j += (k - 1);
//      }
//    }
//    return result;
//  }


  public int countBattleships(char[][] board) {
    if(board == null || board.length == 0) return -1;
    int result = 0;
    for(int i = 0; i < board.length; i++){
      for(int j = 0; j < board[i].length; j++){
        if(board[i][j] == '.') continue;
        int k = findLengthHorizontal(board, i, j);
        if(k != 0) {
          result++;
          j += (k - 1);
        }
      }
    }
    return result;
  }

  public int findLengthHorizontal(char[][] board, int rowIndex, int colIndex){
    if(rowIndex - 1 >= 0 && board[rowIndex - 1][colIndex] == 'X') return 0;
    if(colIndex - 1 >= 0 && board[rowIndex][colIndex - 1] == 'X') return 0;
    int length = 1;
    for(int i = colIndex + 1; i < board[rowIndex].length; i++){
      if(board[rowIndex][i] != 'X') break;
      length++;
    }
    return length;
  }

  public static void main(String[] args){
    Prob419 prob419 = new Prob419();
    //System.out.println(prob419.countBattleships(new char[][]{{'X','.','.','X'},{'.','.','.','X'},{'.','.','.','X'}}));
    //System.out.println(prob419.countBattleships(new char[][]{{'X','.','X'}}));
    System.out.println(prob419.countBattleships(new char[][]{{'X','.','.','X'},{'.','.','.','X'},{'.','.','.','X'}}));
  }
}
