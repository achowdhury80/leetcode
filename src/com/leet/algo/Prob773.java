package com.leet.algo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ayanc on 1/28/18.
 */
public class Prob773 {
  public int slidingPuzzle(int[][] board) {
    Map<Board, Integer> map = new HashMap<>();
    return slidingPuzzle(new Board(board), map, 0);
  }

  private int slidingPuzzle(Board board, Map<Board, Integer> map, int steps){
    if(map.containsKey(board) && map.get(board) <= steps) return -1;
    map.put(board, steps);
    if (isSolved(board))return map.get(board);
    Board[] nextBoards = nextBoards(board);
    int res = -1;
    for(int i = 0; i < nextBoards.length; i++){
      if (nextBoards[i] == null) continue;
      int result = slidingPuzzle(nextBoards[i], map, steps + 1);
      if(result == -1) continue;
      if(res == -1) res = result;
      else res = Math.min(res, result);
    }
    return res;
  }

  private boolean isSolved(Board board){
    for(int i = 0; i < 2; i++){
      for(int j = 0; j < 3; j++){
        if((i * 3 + j + 1) % 6 != board.board[i][j]) return false;
      }
    }
    return true;
  }
  private Board[] nextBoards(Board board){
    int zeroI = -1;
    int zeroJ = -1;
    for(int i = 0; i < 2; i++){
      for(int j = 0; j < 3; j++){
        if(board.board[i][j] == 0) {
          zeroI = i;
          zeroJ = j;
          break;
        }
      }
    }
    Board[] result = new Board[3];
    int j = -1;
    if(zeroI == 0) result[++j] = swap(board, zeroI, zeroJ, 1, zeroJ);
    if(zeroI == 1) result[++j] = swap(board, zeroI, zeroJ, 0, zeroJ);
    if(zeroJ + 1 < 3) result[++j] = swap(board, zeroI, zeroJ, zeroI, zeroJ + 1);
    if(zeroJ - 1 > -1) result[++j] = swap(board, zeroI, zeroJ, zeroI, zeroJ - 1);
    return result;
  }

  private Board swap(Board board, int i, int j, int k, int l){
    Board newBoard = board.copy();
    int temp = newBoard.board[i][j];
    newBoard.board[i][j] = newBoard.board[k][l];
    newBoard.board[k][l] = temp;
    return newBoard;
  }

  class Board {
    int[][] board;
    Board(int[][] board){
      this.board = board;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;

      Board board1 = (Board) o;

      return Arrays.deepEquals(board, board1.board);

    }

    @Override
    public int hashCode() {
      return Arrays.deepHashCode(board);
    }

    Board copy(){
      Board result = new Board(new int[2][3]);
      for(int i = 0; i < 2; i++){
        for (int j = 0; j < 3; j++){
          result.board[i][j] = this.board[i][j];
        }
      }
      return result;
    }
  }

  public static void main(String[] args){
    Prob773 prob773 = new Prob773();
    System.out.println(prob773.slidingPuzzle(new int[][]{{1,2,3},{4,0,5}}));
    System.out.println(prob773.slidingPuzzle(new int[][]{{1,2,3},{5,4,0}}));
    System.out.println(prob773.slidingPuzzle(new int[][]{{4,1,2},{5,0,3}}));
    System.out.println(prob773.slidingPuzzle(new int[][]{{3,2,4},{1,5,0}}));
  }
}
