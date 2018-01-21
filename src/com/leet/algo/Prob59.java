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
    int i = 0;
    int r = 0, c = 0;
    boolean[] direction = new boolean[4];
    direction[0] = true;
    while(i < n * n){
      i++;
      result[r][c] = i;
      if(direction[0]){
        if(c + 1 < n && result[r][c + 1] == 0){
          c++;
        } else {
          r++;
          direction[0] = false;
          direction[1] = true;
        }
      } else if(direction[1]){
        if(r + 1 < n && result[r + 1][c] == 0){
          r++;
        } else {
          c--;
          direction[1] = false;
          direction[2] = true;
        }
      } else if(direction[2]){
        if(c - 1 > -1 && result[r][c - 1] == 0){
          c--;
        } else {
          r--;
          direction[2] = false;
          direction[3] = true;
        }
      } else {
        if(r - 1 > -1 && result[r - 1][c] == 0){
          r--;
        } else {
          c++;
          direction[3] = false;
          direction[0] = true;
        }
      }
    }
    return result;
  }

  public static void main(String[] args){
    Prob59 prob59 = new Prob59();
    int[][] matrix = prob59.generateMatrix(2);
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
