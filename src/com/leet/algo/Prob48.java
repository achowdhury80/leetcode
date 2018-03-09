package com.leet.algo;

/**
 * Created by ayanc on 1/21/18.
 */
public class Prob48 {
  public void rotate(int[][] matrix) {
    int n;
    if(matrix == null || (n = matrix.length) < 2) return;
    int i = 0, j = n - 1;
    while (i < j){
      for (int k = 0; k < n; k++) swap(matrix, i, k, j, k);
      i++;
      j--;
    }
    for (i = 0; i < n; i++){
      for (j = i; j < n; j++) {
        swap(matrix, i, j, j, i);
      }
    }
  }

  private void swap(int[][] matrix, int i, int j, int k, int l){
    int temp = matrix[i][j];
    matrix[i][j] = matrix[k][l];
    matrix[k][l] = temp;
  }

  public static void main(String[] args) {
    Prob48 prob48 = new Prob48();
    int[][] matrix;
    matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
    prob48.rotate(matrix);
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        System.out.print(matrix[i][j] + " ");
      }
      System.out.println();
    }
  }

}
