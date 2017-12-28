package com.leet.algo;

/**
 * Created by ayanc on 12/26/17.
 */
public class Prob304 {
  private int[][] matrix;
  private int[][] dp;
  public Prob304(int[][] matrix) {
    this.matrix = matrix;
    if(matrix.length != 0 && matrix[0].length != 0) {
      this.dp = new int[matrix.length][matrix[0].length];
      dp[0][0] = matrix[0][0];
      for (int j = 1; j < matrix[0].length; j++) {
        dp[0][j] = dp[0][j - 1] + matrix[0][j];
      }
      for (int i = 1; i < matrix.length; i++) {
        dp[i][0] = dp[i - 1][0] + matrix[i][0];
      }
      for (int i = 1; i < matrix.length; i++) {
        for (int j = 1; j < matrix[0].length; j++) {
          dp[i][j] = dp[i - 1][j] + (dp[i][j - 1] - dp[i - 1][j - 1]) + matrix[i][j];
        }
      }
    }
  }

  public int sumRegion(int row1, int col1, int row2, int col2) {
    if(matrix.length == 0 || matrix[0].length == 0) return 0;
    return dp[row2][col2] - (row1 > 0 ? dp[row1 - 1][col2] : 0) - (col1 > 0 ? dp[row2][col1 - 1] : 0) + (row1 > 0 && col1 > 0 ? dp[row1 - 1][col1 - 1] : 0);
  }

  public static void main(String[] args){
    Prob304 prob304 = new Prob304(new int[][]{{3, 0, 1, 4, 2},{5, 6, 3, 2, 1},{1, 2, 0, 1, 5},{4, 1, 0, 1, 7},{1, 0, 3, 0, 5}});
    System.out.println(prob304.sumRegion(2, 1, 4, 3));
    System.out.println(prob304.sumRegion(1, 1, 2, 2));
    System.out.println(prob304.sumRegion(1, 2, 2, 4));
  }
}
