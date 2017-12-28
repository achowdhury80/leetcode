package com.leet.algo;

/**
 * Created by ayanc on 12/24/17.
 */
public class Prob123 {
  public int maxProfit(int[] prices) {
    if(prices == null || prices.length < 2) return 0;
    int T_i10 = 0, T_i11 = Integer.MIN_VALUE, T_i20 = 0, T_i21 = Integer.MIN_VALUE;

    for (int price : prices) {
      T_i20 = Math.max(T_i20, T_i21 + price);
      T_i21 = Math.max(T_i21, T_i10 - price);
      T_i10 = Math.max(T_i10, T_i11 + price);
      T_i11 = Math.max(T_i11, -price);
    }

    return T_i20;
  }

  public static void main(String[] args){
    Prob123 prob123 = new Prob123();
    //System.out.println(prob123.maxProfit(new int[]{1,2}));
    System.out.println(prob123.maxProfit(new int[]{2,1,2,0,1}));
  }
}
