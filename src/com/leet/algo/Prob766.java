package com.leet.algo;

/**
 * Created by ayanc on 1/22/18.
 */
public class Prob766 {
  public boolean isToeplitzMatrix(int[][] matrix) {
    int m, n = 0;
    if((m = matrix.length) == 1 && (n = matrix[0].length) == 1) return true;
    n = matrix[0].length;
    for(int i = m - 1; i > 0; i--){
      int j = i;
      int k = 0;
      int elem = matrix[j][k];
      j++;
      k++;
      while (j < m && k < n){
        if(matrix[j][k] != elem) return false;
        j++;
        k++;
      }
    }
    for(int i = 0; i < n - 1; i++){
      int j = 0;
      int k = i;
      int elem = matrix[0][i];
      j++;
      k++;
      while (j < m && k < n){
        if(matrix[j][k] != elem) return false;
        j++;
        k++;
      }
    }
    return true;
  }

  public static void main(String[] args){
    Prob766 prob766 = new Prob766();
    System.out.println(prob766.isToeplitzMatrix(new int[][]{{1, 2},{2, 2}}));
  }
}
