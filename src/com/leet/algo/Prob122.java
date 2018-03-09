package com.leet.algo;

/**
 * Created by ayanc on 3/3/18.
 */
public class Prob122 {
  public int maxProfit(int[] prices) {
    if (prices == null || prices.length == 0) return 0;
    int t_i0 = 0, t_i1 = Integer.MIN_VALUE;
    for (int i = 0; i < prices.length; i++) {
      int temp = t_i0;
      t_i0 = Math.max(t_i0, t_i1 + prices[i]);
      t_i1 = Math.max(t_i1, temp - prices[i]);
    }
    return t_i0;
  }
}
