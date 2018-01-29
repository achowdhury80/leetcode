package com.leet.algo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ayanc on 1/24/18.
 */
public class Prob52 {
  public int totalNQueens(int n) {
    if(n < 1) return 0;
    BoardUtil boardUtil = new BoardUtil(n);
    return solveNQueens(n, boardUtil.emptyBoard, 0, boardUtil);
  }

  private int solveNQueens(int n, List<String> board, int row, BoardUtil boardUtil){
    if(n == row) {
      return 1;
    }
    int sum = 0;
    for(int col = 0; col < n; col++){
      boolean safe = true;
      for(int r = 0; r < row; r++){
        int diff = row - r;
        String rthString = board.get(r);
        if(rthString.charAt(col) == 'Q' || (col - diff > -1 && rthString.charAt(col - diff) == 'Q')
            || (col + diff < n  && rthString.charAt(col + diff) == 'Q')) {
          safe = false;
          break;
        }
      }
      if(safe){
        List<String> newBoard = boardUtil.cloneBoard(board);
        newBoard.set(row, boardUtil.placeQueenInRow(col));
        sum  += solveNQueens(n, newBoard, row + 1, boardUtil);
      }

    }
    return sum;
  }

  class BoardUtil{
    int n;
    List<List<String>> board;
    String s = "";
    List<String> emptyBoard;

    BoardUtil(int n){
      this.n = n;
      for(int i = 0; i < n; i++) s += ".";
      emptyBoard = new ArrayList<>();
      for(int i = 0; i < n; i++) emptyBoard.add(s);
    }
    List<String> getEmptyBoard(){
      return new ArrayList<>(emptyBoard);
    }

    List<String> cloneBoard(List<String> board){
      return new ArrayList<>(board);
    }

    String placeQueenInRow(int col){
      if(col == 0){
        return "Q" + s.substring(1);
      }
      if(col == n - 1){
        return s.substring(0, n - 1) + "Q";
      }
      return s.substring(0, col) + "Q" + s.substring(col + 1);
    }
  }

  public static void main(String[] args){
    Prob52 prob52 = new Prob52();
    System.out.println(prob52.totalNQueens(4));
  }
}
