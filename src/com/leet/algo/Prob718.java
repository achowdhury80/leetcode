package com.leet.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by ayanc on 12/8/17.
 */
public class Prob718 {
  public int findLength(int[] A, int[] B) {
    int m, n;
    if(A == null || B == null || (m = A.length) == 0 || (n = B.length) == 0) return 0;
    int[][] dp = new int[m + 1][n + 1];
    int result = 0;
    for(int i = m - 1; i > -1; i--){
      for(int j = n - 1; j > -1; j--){
        dp[i][j] = (A[i] == B[j] ? (1 + dp[i + 1][j + 1]): 0);
        result = Math.max(result, dp[i][j]);
      }
    }
    return result;
  }

}
