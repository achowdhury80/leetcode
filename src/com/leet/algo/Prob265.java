package com.leet.algo;

/**
 * Created by ayanc on 2/18/18.
 */
public class Prob265 {
  public int minCostII(int[][] costs) {
    if (costs == null || costs.length < 1 || costs[0].length < 1) return 0;
    int n = costs.length, k = costs[0].length;

    int last1 = -1, last2 = -1;

    for (int i = 0; i < n; i++) {
      int min1 = -1, min2 = -1;
      for (int j = 0; j < k; j++) {
        if (j != last1) costs[i][j] += last1 < 0 ? 0 : costs[i - 1][last1];
        else costs[i][j] += last2 < 0 ? 0 : costs[i - 1][last2];
        if (min1 == -1) {
          min1 = j;
        } else {
          if (costs[i][j] <= costs[i][min1]) {
            min2 = min1;
            min1 = j;
          } else {
            if (min2 == -1) min2 = j;
            else if (costs[i][j] < costs[i][min2]) min2 = j;
          }
        }
      }
      last1 = min1;
      last2 = min2;
    }
    return costs[n - 1][last1];
  }

}
