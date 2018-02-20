package com.leet.algo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ayanc on 2/19/18.
 */
public class Prob85 {
  public int maximalRectangle(char[][] matrix) {
    int m, n;
    if (matrix == null || (m = matrix.length) < 1 || (n = matrix[0].length) < 1) return 0;
    int result = 0;
    for (int i = 0; i < m - 1; i++) {
      List<Integer> list = new ArrayList<>();
      int last = 0;
      for (int j = 0; j < n; j++) {
        if (matrix[i][j] == '1') {
          last++;
          list.add(j);
        }
        else {
          if (last > result) {
            result = last;
          }
          last = 0;
        }
      }
      result = Math.max(result, last);
      for (int k = i + 1; k < m; k++) {
        if (list.isEmpty()) break;
        int max = 0;
        for (int l : list) {
          if (matrix[k][l] == '1') {
            max += k - i + 1;
          } else {
            result = Math.max(result, max);
            max = 0;
          }
        }
        result = Math.max(result, max);
      }
      if (result >= n * (m - i -1)) break;
    }
    return result;
  }

  public static void main(String[] args) {
    Prob85 prob85 = new Prob85();
    System.out.println(prob85.maximalRectangle(new char[][]{
        {'1', '0', '1', '0', '0'},
        {'1', '0', '1', '1', '1'},
        {'1', '1', '1', '1', '1'}}));
//        ('1', '0', '0', '1', '0'}
   // }));
  }
}
