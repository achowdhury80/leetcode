package com.leet.algo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ayanc on 1/23/18.
 */
public class Prob54 {
  public List<Integer> spiralOrder(int[][] matrix) {
    int m, n;
    List<Integer> result = new ArrayList<>();
    if(matrix == null || (m = matrix.length) < 1 || (n = matrix[0].length) < 1) return result;
    if(m == 1 && n == 1){
      result.add(matrix[0][0]);
      return result;
    }
    int r = 0;
    int c = -1;
    int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    int d = 0;
    int[] border = {-1, m, -1, n};
    for (int i = 0; i < m * n; i++) {
      int j = r + dirs[d][0];
      int k = c + dirs[d][1];
      while (j == border[0] || j == border[1] || k == border[2] || k == border[3]) {
        if (d == 0) border[0]++;
        else if (d == 1) border[3]--;
        else if (d == 2) border[1]--;
        else border[2]++;
        d = (d + 1) % 4;
        j = r + dirs[d][0];
        k = c + dirs[d][1];
      }
      r = j;
      c = k;
      result.add(matrix[r][c]);

    }
    return result;
  }

  public static void main(String[] args){
    Prob54 prob54 = new Prob54();
    System.out.println(prob54.spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9 }}));
  }
}
