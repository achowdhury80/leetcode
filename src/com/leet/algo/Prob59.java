package com.leet.algo;

/**
 * Created by ayanc on 1/21/18.
 */
public class Prob59 {
  public int[][] generateMatrix(int n) {
    if(n < 1) return new int[0][0];
    if(n == 1){
      return new int[][]{{1}};
    }
    int[][] result = new int[n][n];
    int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1},{-1, 0}};
    int dirIndex = 0;
    int i = 1;
    int r = 0, c = -1;
    while(i <= n * n){
      int j = r + dirs[dirIndex][0];
      int k = c + dirs[dirIndex][1];
      while (j == n || j < 0 || k == n || k < 0 || result[j][k] != 0) {
        dirIndex = (dirIndex + 1) % 4;
        j = r + dirs[dirIndex][0];
        k = c + dirs[dirIndex][1];
      }
      r = j;
      c = k;
      result[r][c] = i;
      i++;
    }
    return result;
  }

  public static void main(String[] args){
    Prob59 prob59 = new Prob59();
    int[][] matrix = null;
    matrix = prob59.generateMatrix(2);
    for(int i = 0; i < matrix.length; i++){
      System.out.println();
      for(int j = 0; j < matrix.length; j++){
        System.out.print(matrix[i][j] + ",");
      }
    }
    System.out.println();
    matrix = prob59.generateMatrix(3);
    for(int i = 0; i < matrix.length; i++){
      System.out.println();
      for(int j = 0; j < matrix.length; j++){
        System.out.print(matrix[i][j] + ",");
      }
    }
    System.out.println();
    matrix = prob59.generateMatrix(4);
    for(int i = 0; i < matrix.length; i++){
      System.out.println();
      for(int j = 0; j < matrix.length; j++){
        System.out.print(matrix[i][j] + ",");
      }
    }
  }
}
