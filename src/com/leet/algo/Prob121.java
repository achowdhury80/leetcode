package com.leet.algo;

/**
 * Created by ayanc on 2/24/18.
 */
public class Prob121 {
  public int maxProfit(int[] prices) {
    if (prices == null || prices.length < 2) return 0;
    Integer min_price = null;
    int result = 0;
    for (int i = 0; i < prices.length; i++) {
      if (min_price == null) {
        min_price = prices[i];
        continue;
      }
      if (prices[i] > min_price) result = Math.max(result, prices[i] - min_price);
      else min_price = prices[i];
    }
    return result;
  }
}
