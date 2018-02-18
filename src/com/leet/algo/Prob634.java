package com.leet.algo;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ayanc on 2/16/18.
 */
public class Prob634 {
  final int MOD = 1000000007;
  public int findDerangement(int n) {
    long result = 1;
    for (int i = 1; i <= n; i++)
      result = (i * result % MOD + (i % 2 == 0 ? 1 : -1)) % MOD;
    return (int)result;
  }



  public static void main(String[] args) {
    Prob634 prob634 = new Prob634();
    //System.out.println(prob634.nCp(3,3));
    System.out.println(prob634.findDerangement(3));
    System.out.println(prob634.findDerangement(4));
  }
}
