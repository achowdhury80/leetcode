package com.leet.algo;

/**
 * Created by ayanc on 2/10/18.
 */
public class Prob256 {
  public int minCost(int[][] costs) {
    if(costs == null || costs.length < 1) return 0;
    for (int i = 1; i < costs.length; i++) for (int j = 0; j < 3; j++)
      costs[i][j] += Math.min(costs[i - 1][(j + 1) % 3], costs[i - 1][(j + 2) % 3]);
    return Math.min(costs[costs.length - 1][0], Math.min(costs[costs.length - 1][1], costs[costs.length - 1][2]));
  }
}
