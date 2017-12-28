package com.leet.algo;

import java.util.Arrays;

/**
 * Created by ayanc on 12/20/17.
 */
public class Prob646 {
  public int findLongestChain(int[][] pairs) {
    int n;
    if(pairs == null || (n = pairs.length) == 0) return 0;
    if(n == 1) return 1;
    Arrays.sort(pairs, (x, y) -> x[1] - y[1]);
    int[][] dp = new int[n][n];
    for(int i = 0; i < n; i++){
      dp[i][i] = 1;
    }
    int result = 1;
    for(int i = 0; i < n; i++){
      int lastRangeNodeMax = pairs[i][1];
      for(int j = i + 1; j < n; j++){
        if(lastRangeNodeMax < pairs[j][0]){
          lastRangeNodeMax = pairs[j][1];
          dp[i][j] = dp[i][j - 1] + 1;
        } else {
          dp[i][j] = dp[i][j - 1];
        }
        result = Math.max(result, dp[i][j]);
      }
    }
    return result;
  }

  public static void main(String[] args){
    Prob646 prob646 = new Prob646();
    System.out.println(prob646.findLongestChain(new int[][]{{1,2}, {2,3}, {3,4}}));
  }


}
