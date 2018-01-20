package com.leet.algo;

import java.util.Arrays;

/**
 * Created by ayanc on 1/20/18.
 */
public class Prob498 {
  public int[] findDiagonalOrder(int[][] matrix) {
    int m, n;
    if(matrix == null || (m = matrix.length) < 1 || (n = matrix[0].length) < 1) return new int[0];
    if(m == 1 && n == 1) return new int[]{matrix[0][0]};
    int[] result = new int[m * n];
    boolean up = true;
    int i = 0;
    int r = 0, c = 0;
    result[i++] = matrix[r][c];
    while(i < result.length){
      if(up){
        c++;
        if(c < n){
          if(r > 0) r--;
          else up = false;
        } else {
          c--;
          r++;
          up = false;
        }
      } else {
        if(c > 0 && r < m - 1){
          c--;
          r++;
        } else if(r < m - 1){
          r++;
          up = true;
        } else {
          c++;
          up = true;
        }
      }
      result[i++] = matrix[r][c];
    }
    return result;
  }

  public static void main(String[] args){
    Prob498 prob498 = new Prob498();
    int[] result = prob498.findDiagonalOrder(new int[][]{{1,2,3},{4,5,6}, {7,8,9}});
    Arrays.stream(result).forEach(x -> System.out.print(x + ", "));
  }
}
