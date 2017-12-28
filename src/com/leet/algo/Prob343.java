package com.leet.algo;

/**
 * Created by ayanc on 12/11/17.
 */
public class Prob343 {
  public int integerBreak(int n) {
    int[] prod = new int[n + 1];
    if(n == 2) return 1;
    if(n == 3) return 2;
    prod[2] = 2;
    prod[1] = 1;
    prod[3] = 3;
    for(int i = 4; i <= n; i++){
      int max = Integer.MIN_VALUE;
      for(int j = 1; j <= i / 2; j++){
        if(max < prod[j] * prod[i -j]) max = prod[j] * prod[i -j];
      }
      prod[i] = max;
    }
    return prod[n];
  }
  public static void main(String[] args){
    Prob343 prob343 = new Prob343();
    System.out.println(prob343.integerBreak(8));
  }
}
