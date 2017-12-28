package com.ctci.chapter8;

/**
 * Created by ayanc on 7/23/17.
 */
public class Problem1 {
  long[] wayCount = null;
  public long noOfWays(int n){
    if(n < 0) return 0;
    if(n < 3) return n;
    wayCount = new long[n + 1];
    wayCount[0] = 0;
    wayCount[1] = 1;
    wayCount[2] = 2;
    return compute(n);
  }

  private long compute(int n){
    if(n == 0) return 1;
    if(wayCount[n] > 0) return wayCount[n];
    wayCount[n] = compute(n - 1) + compute(n - 2) + compute(n - 3);
    return wayCount[n];
  }

  public static void main(String[] args){
    Problem1 tripleStep = new Problem1();
    System.out.println(tripleStep.noOfWays(38));
  }
}
