package com.leet.algo;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by ayanc on 7/11/17.
 */
public class SquareSun {
  Set<Integer> set = new HashSet();
  public static void main(String[] args){
    SquareSun squareSun = new SquareSun();
    System.out.println(squareSun.judgeSquareSum(2147482647));
  }
  public boolean judgeSquareSum(int c) {
    for(int guess = 0; guess * guess <= c; guess++){
      if(set.contains(guess * guess) || c == 2 * guess * guess) {
        return true;
      }
      set.add(c - guess * guess);
    }
    return false;
  }

  public double myPow(double x, int n) {
    if(x == 0) return 0;
    if(n == 0) return 1;
    if(n < 0) {
      x = 1 / x;
      n = (-1) * n;
    }
    if(n % 2 == 0) {
      x = x * x;
      n = n/2;
      return myPow(x, n);
    }
    return 0;
  }
}
