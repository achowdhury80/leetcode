package com.leet.algo;

import java.util.Arrays;

/**
 * Created by ayanc on 12/24/17.
 */
public class Prob188 {
  public int maxProfit(int k, int[] prices) {
    int n;
    if(prices == null || (n = prices.length) < 2 || k < 1) return 0;
    if(k >= n/2){
      int t_i_k_0 = 0, t_i_k_1 = Integer.MIN_VALUE;
      for(int price : prices){
        int old = t_i_k_0;
        t_i_k_0 = Math.max(t_i_k_0, t_i_k_1 + price);
        t_i_k_1 = Math.max(t_i_k_1, old - price);
      }
      return t_i_k_0;
    } else {
      int[] t_i_k_0 = new int[k + 1];
      int[] t_i_k_1 = new int[k + 1];
      Arrays.fill(t_i_k_1, Integer.MIN_VALUE);
      for(int price : prices){
        for(int j = k; j > 0; j--){
          t_i_k_0[j] = Math.max(t_i_k_0[j], t_i_k_1[j] + price);
          t_i_k_1[j] = Math.max(t_i_k_1[j], t_i_k_0[j - 1] - price);
        }
      }
      return t_i_k_0[k];
    }
  }

  public static void main(String[] args){
    Prob188 prob188 = new Prob188();
    System.out.println(prob188.maxProfit(2, new int[]{3,2,6,5,0,3}));
  }
}
