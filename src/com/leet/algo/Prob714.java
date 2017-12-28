package com.leet.algo;

/**
 * Created by ayanc on 12/19/17.
 */
public class Prob714 {
  public int maxProfit(int[] prices, int fee) {
    if(prices == null || prices.length < 2) return 0;
    long previousT_1 = Integer.MIN_VALUE;
    long prviousT_0 = 0;
    for(int i = 0; i < prices.length; i++){
      long currentT_0 = Math.max(prviousT_0, previousT_1 + prices[i] - fee);
      long currentT_1 = Math.max(previousT_1, prviousT_0 - prices[i]);
      prviousT_0 = currentT_0;
      previousT_1 = currentT_1;
    }
    return (int)prviousT_0;
  }


  public static void main(String[] args){
    Prob714 prob714 = new Prob714();
    System.out.println(prob714.maxProfit(new int[]{1, 3, 2, 8, 4, 9}, 2));
    System.out.println(prob714.maxProfit(new int[]{1,3,7,5,10,3}, 3));
  }
}
