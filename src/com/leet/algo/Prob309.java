package com.leet.algo;

/**
 * Created by ayanc on 12/19/17.
 */
public class Prob309 {
  public int maxProfit(int[] prices) {
    if(prices == null || prices.length < 2) return 0;
    int previousT_1 = Integer.MIN_VALUE;
    int prviousT_0 = 0;
    int olderT_0 = 0;
    for(int i = 0; i < prices.length; i++){
      int currentT_0 = Math.max(prviousT_0, previousT_1 + prices[i]);
      int currentT_1 = Math.max(previousT_1, olderT_0 - prices[i]);
      olderT_0 = prviousT_0;
      prviousT_0 = currentT_0;
      previousT_1 = currentT_1;

    }
    return prviousT_0;
  }


  public static void main(String[] args){
    Prob309 prob309 = new Prob309();
    //System.out.println(prob309.maxProfit(new int[]{1, 3, 2, 8, 4, 9}));
    //System.out.println(prob309.maxProfit(new int[]{1,3,7,5,10,3}));
    System.out.println(prob309.maxProfit(new int[]{1, 2, 3, 0, 2}));
  }
}
