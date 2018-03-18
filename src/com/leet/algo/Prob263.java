package com.leet.algo;

/**
 * Created by ayanc on 3/17/18.
 */
public class Prob263 {
  public boolean isUgly(int num) {
    if(num < 1) return false;
    if(num == 1) return true;
    while(num % 2 == 0){
      num = num / 2;
    }
    while(num % 5 == 0){
      num = num / 5;
    }
    while(num % 3 == 0){
      num = num / 3;
    }
    return num == 1;

  }
}
