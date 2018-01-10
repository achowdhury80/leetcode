package com.leet.algo;

/**
 * Created by ayanc on 1/9/18.
 */
public class Prob130 {
  public void solve(char[][] board) {
    int m , n;
    if(board == null || (m = board.length) < 3 || (n = board[0].length) < 3) return;
    int[] ids = new int[m * n];
    int[] size = new int[m * n];
    boolean allCovered = true;
    for(int i = 0; i < n; i++) {
      if(board[0][i] == 'O'){
        ids[i] = -1;
        allCovered = false;
      }
      if(board[m - 1][i] == 'O'){
        ids[(m - 1) * n + i] = -1;
        allCovered = false;
      }
    }
    for(int i = 0; i < m; i++) {
      if(board[i][0] == 'O'){
        ids[i * n + 0] = -1;
        allCovered = false;
      }
      if(board[i][n - 1] == 'O') {
        ids[i * n + n - 1] = -1;
        allCovered = false;
      }
    }
    if(allCovered){
      for(int i = 1; i < m - 1; i++){
        for(int j = 1; j < n - 1; j++) board[i][j] = 'X';
      }
    }

    for(int i = 1; i < m - 1; i++){
      for(int j = 1; j < n - 1; j++){
        if(board[i][j] == 'O'){
          ids[n * i + j] = (n * i + j);
          size[n * i + j] = 1;
        }
      }
    }

    for(int i = 1; i < m - 1; i++){
      for(int j = 1; j < n - 1; j++){
        if(board[i][j] == 'O'){
          if(board[i - 1][j] == 'O'){
            connect(ids, size, n * (i - 1) + j, n * i + j);
          }
          if(board[i + 1][j] == 'O'){
            connect(ids, size, n * (i + 1) + j, n * i + j);
          }
          if(board[i][j - 1] == 'O'){
            connect(ids, size, n * i + j - 1, n * i + j);
          }
          if(board[i][j + 1] == 'O'){
            connect(ids, size, n * i + j + 1, n * i + j);
          }
        }
      }
    }

    for(int i = 1; i < m - 1; i++) {
      for (int j = 1; j < n - 1; j++) {
        if(board[i][j] == 'O' && find(ids, i * n + j) != -1) board[i][j] = 'X';
      }
    }


  }

  private int find(int[] ids, int id){
    if(ids[id] == -1) return  -1;
    return ids[id] == id ? id : find(ids, ids[id]);
  }

  private void connect(int[]ids, int[] size, int id1, int id2){
    int parent1 = find(ids, id1);
    int parent2 = find(ids, id2);
    if(parent1 == parent2) return;
    if(parent1 == -1){
      ids[parent2] = -1;
      //size[parent2] = 2;
    } else if(parent2 == -1){
      ids[parent1] = -1;
      //size[parent1] = 1;
    } else {
      if(size[parent1] > size[parent2]){
        ids[parent2] = parent1;
        size[parent1] = size[parent1] + size[parent2];
      } else {
        ids[parent1] = parent2;
        size[parent2] = size[parent1] + size[parent2];
      }
    }
  }

  public static void main(String[] arhs) {
    Prob130 prob130 = new Prob130();
    char[][] board = new char[][]{{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}};
    prob130.solve(board);
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        System.out.print(board[i][j] + " ");
      }
      System.out.println();
    }
  }

}
