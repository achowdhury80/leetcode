package com.leet.algo;

/**
 * Created by ayanc on 1/21/18.
 */
public class Prob73 {
  public void setZeroes(int[][] matrix) {
    int m, n;
    if(matrix == null || (m = matrix.length) < 1 || (n = matrix[0].length) < 1) return;
    int col0 = 1;
    for(int i = 0; i < m; i++){
      if(matrix[i][0] == 0) col0 = 0;
      for(int j = 1; j < n; j++){
        if(matrix[i][j] == 0){
          matrix[i][0] = 0;
          matrix[0][j] = 0;
        }
      }
    }

    for(int i = m - 1; i > -1; i--){
      for(int j = 1; j < n; j++){
        if(matrix[i][0] == 0 || matrix[0][j] == 0) matrix[i][j] = 0;
      }
      if(col0 == 0) matrix[i][0] = 0;
    }
  }

  public static void main(String[] args){
    Prob73 prob73 = new Prob73();
    int[][] matrix;
//    matrix = new int[][]{{0,1}};
//    prob73.setZeroes(matrix);
//    for(int i = 0; i < matrix.length; i++){
//      for(int j = 0; j < matrix[0].length; j++){
//        System.out.print(matrix[i][j] + ",");
//      }
//      System.out.println();
//    }
//    System.out.println();
    matrix = new int[][]{{1, 1, 1}, {0, 1, 2}};
    prob73.setZeroes(matrix);
    for(int i = 0; i < matrix.length; i++){
      for(int j = 0; j < matrix[0].length; j++){
        System.out.print(matrix[i][j] + ",");
      }
      System.out.println();
    }
  }
}
