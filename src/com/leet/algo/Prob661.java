package com.leet.algo;

/**
 * Created by ayanc on 8/25/17.
 */
public class Prob661 {
  public static void main(String[] args){
    Prob661 prob661 = new Prob661();
    int[][] result = prob661.imageSmoother(new int[][]{{1,1,1},{1,0,1},{1,1,1}});
    for(int i = 0; i < result.length; i++) {
      System.out.println();
      for (int j = 0; j < result[i].length; j++) {
        System.out.print(result[i][j] + " ");
      }
    }

  }
  public int[][] imageSmoother(int[][] M) {
    if(M == null || M.length == 0) return M;
    int[][] result = new int[M.length][];
    for(int i = 0; i < M.length; i++){
      result[i] = new int[M[0].length];
    }
    for(int i = 0; i < M.length; i++){
      for(int j = 0; j < M[i].length; j++){
        result[i][j] = smoothenScale(M, i, j);
      }
    }
    return result;
  }

  private int smoothenScale(int[][] M, int rowIndex, int colIndex){
    double sum = 0.0;
    int count = 0;
    for(int i = rowIndex - 1; i < rowIndex + 2; i++){
      for(int j = colIndex - 1; j < colIndex + 2; j++){
        if(i < 0 || j < 0 || i >= M.length || j >= M[0].length) continue;
        sum += M[i][j];
        count++;
      }
    }
    return Double.valueOf(Math.floor(sum / count)).intValue();
  }
}
